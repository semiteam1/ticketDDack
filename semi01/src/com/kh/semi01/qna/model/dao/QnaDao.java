package com.kh.semi01.qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi01.qna.model.vo.Qna;
import static com.kh.semi01.common.JDBCTemplate.*;

public class QnaDao {
	private Properties prop = new Properties();
	
	public QnaDao() {
		try {
			prop.loadFromXML(new FileInputStream(QnaDao.class.getResource("/db/sql/qna-mapper.xml").getPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Qna> selectQnaList(Connection conn){
		
		ArrayList<Qna> list = new ArrayList<Qna>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Qna(rset.getInt("qna_no"),
								 rset.getString("user_id"),
								 rset.getString("qna_title"),
								 rset.getString("qna_content"),
								 rset.getString("qna_reply"),
								 rset.getString("qna_date")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}return list;
		
	}
	
	public int insertQna(Connection conn, Qna q) {
		int result= 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getQnaTitle());
			pstmt.setString(2, q.getQnaContent());
			pstmt.setInt(3, Integer.parseInt(q.getUser()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Qna selectQna(Connection conn, int qnaNo) {
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				q = new Qna(rset.getInt("qna_no"),
							rset.getString("qna_title"),
							rset.getString("qna_content"),
							rset.getString("user_id"),
							rset.getString("qna_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
		
		
	}
	
	public int deleteQna(Connection conn, int qnaNo ) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	public int insertAnswer(Connection conn, Qna a) {
		int result= 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAnswer");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, a.getQnaReply());
			pstmt.setInt(2, a.getQnaNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
