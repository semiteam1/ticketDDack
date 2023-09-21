package com.kh.semi01.book.model.service;

import java.sql.Connection;

import static com.kh.semi01.common.JDBCTemplate.*;

import com.kh.semi01.book.model.dao.BookNPaymentDao;
import com.kh.semi01.user.model.vo.Book;

public class BookNPaymentService {
	
	public int insertBook(Book b) {
		
		Connection conn = getConnection();
		
		int result = new BookNPaymentDao().insertBook(conn, b);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int decreaseCount(Book b) {
		
		Connection conn = getConnection();
		
		int result = new BookNPaymentDao().decreaseCount(conn, b);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn); 
		}
		
		close(conn);
		
		return result;
		
	}

}
