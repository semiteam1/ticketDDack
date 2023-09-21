package com.kh.semi01.book.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.semi01.common.JDBCTemplate.*;
import com.kh.semi01.user.model.vo.Book;

public class BookNPaymentDao {
	
	private Properties prop = new Properties();
	
	public BookNPaymentDao() {
		
		String filePath = BookNPaymentDao.class.getResource("/db/sql/bookNPayment-mapper.xml").getPath();
		
		try {
			
			prop.loadFromXML(new FileInputStream(filePath));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int insertBook(Connection conn, Book b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBook");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(b.getUser()));
			pstmt.setInt(2, Integer.parseInt(b.getProduct()));
			pstmt.setInt(3, b.getAudience());
			pstmt.setInt(4, Integer.parseInt(b.getPayment()));
			pstmt.setInt(5, Integer.parseInt(b.getCard()));
			pstmt.setString(6, b.getScreenDate());
			pstmt.setString(7, b.getScreenTime());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int decreaseCount(Connection conn, Book b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = "";
		
		if(b.getScreenTime().equals("11:00")) {
			query = "decreaseDaySeatCount";
		}
		else {
			query = "decreaseNightSeatCount";
		}
		
		String sql = prop.getProperty(query);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, b.getAudience());
			pstmt.setInt(2, Integer.parseInt(b.getProduct()));
			pstmt.setString(3, b.getScreenDate());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

}
