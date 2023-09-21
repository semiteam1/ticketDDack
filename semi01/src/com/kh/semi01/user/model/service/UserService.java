package com.kh.semi01.user.model.service;

import static com.kh.semi01.common.JDBCTemplate.close;
import static com.kh.semi01.common.JDBCTemplate.commit;
import static com.kh.semi01.common.JDBCTemplate.getConnection;
import static com.kh.semi01.common.JDBCTemplate.rollback;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.Connection;

import com.kh.semi01.book.model.dao.BookNPaymentDao;
import com.kh.semi01.common.model.vo.PageInfo;
import com.kh.semi01.product.model.dao.ProductDao;
import com.kh.semi01.product.model.dao.ProductDao;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductLike;
import com.kh.semi01.user.model.dao.UserDao;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Grade;
import com.kh.semi01.user.model.vo.Review;
import com.kh.semi01.user.model.vo.User;

public class UserService {

	public User loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		User u = new UserDao().loginMember(conn,userId,userPwd);
		
		close(conn);
		
		
		return u;
	}

	public int insertUser(User u) {
		Connection conn = getConnection();
		
		int result = new UserDao().insertUser(conn,u);
		
		if(result > 0) { 
			commit(conn);
		}else { 
			rollback(conn); 
		}
		
		close(conn);
		
		return result;
	}
	
	public User updateUser(User u) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().updateUser(conn, u);
		
		User updateUser = null;
		
		if(result > 0) {
			commit(conn);
			
			updateUser = new UserDao().selectUser(conn, u.getUserNo());
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateUser;
		
	}
	
	public int deleteUser(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().deleteUser(conn, userNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int updatePwd(int userNo, String updatePwd) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().updatePwd(conn, userNo, updatePwd);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public User findIdWithEmail(String chPwd, String chBday, String chEmail) {
		Connection conn = getConnection();
		
		User u = new UserDao().findIdWithEmail(conn,chPwd,chBday,chEmail);
		
		close(conn);
		
		return u;
	}

	public User findIdWithPhone(String chPwd, String chBday, String chPhone) {
		Connection conn = getConnection();
		
		User u = new UserDao().findIdWithPhone(conn,chPwd,chBday,chPhone);
		
		close(conn);
		
		return u;
	}

	public User findPwdWithEmail(String chId, String chBday, String chEmail) {
		Connection conn = getConnection();
		
		User u = new UserDao().findPwdWithEmail(conn,chId,chBday,chEmail);
		
		close(conn);
		
		return u;
	}

	public User findPwdWithPhone(String chId, String chBday, String chPhone) {
		Connection conn = getConnection();
		
		User u = new UserDao().findPwdWithPhone(conn,chId,chBday,chPhone);
		
		close(conn);
		
		return u;
	}

	public int changePwd(String fine_pwd, String userNo, String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new UserDao().changePwd(conn,fine_pwd,userNo,userId,userPwd);
		
		if(result > 0) { 
			commit(conn);
		}else { 
			rollback(conn); 
		}
		
		close(conn);
		
		return result;
	}

	public int idCheck(String checkId) {
		Connection conn = getConnection();
		
		int count = new UserDao().idCheck(conn,checkId);
		
		close(conn);
		
		return count;
	}
	
	public int selectBookCount(int userNo) {
		
		Connection conn = getConnection();
		
		int count = new UserDao().selectBookCount(conn, userNo);
		
		close(conn);
		
		return count;
		
	}
	
	public String selectBookPrice(int userNo) {
		
		Connection conn = getConnection();
		
		String price = new UserDao().selectBookPrice(conn, userNo);
		
		close(conn);
		
		return price;
		
	}
	
	public int selectReviewCount(int userNo) {
		
		Connection conn = getConnection();
		
		int reviewCount = new UserDao().selectReviewCount(conn, userNo);
		
		close(conn);
		
		return reviewCount;
		
	}
	
	public ArrayList<Review> selectAllReview(int userNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Review> list = new UserDao().selectAllReview(conn, userNo, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public Review selectReview(int reviewNo) {
		
		Connection conn = getConnection();
		
		Review r = new UserDao().selectReview(conn, reviewNo);
		
		close(conn);
		
		return r;
		
	}
	
	public Review updateReview(int reviewNo, String reviewContent) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().updateReview(conn, reviewNo, reviewContent);
		
		Review r = null;
		
		if(result > 0) {
			commit(conn);
			
			r = new UserDao().selectReview(conn, reviewNo);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return r;
		
	}
	
	public int deleteReview(int reviewNo) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().deleteReview(conn, reviewNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int selectTicketCount(int userNo) {
		
		Connection conn = getConnection();
		
		int ticketCount = new UserDao().selectTicketCount(conn, userNo);
		
		close(conn);
		
		return ticketCount;
		
	}
	
	public ArrayList<Book> selectAllTicket(int userNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Book> list = new UserDao().selectAllTicket(conn, userNo, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public Book selectTicketDetail(int bookedNo) {
		
		Connection conn = getConnection();
		
		Book b = new UserDao().selectTicketDetail(conn, bookedNo);
		
		close(conn);
		
		return b;
		
	}
	
	public int increaseCount(int bookedNo) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().increaseCount(conn, bookedNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn); 
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteTicket(int bookedNo) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().deleteTicket(conn, bookedNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public Grade selectGradeInfo(int userNo) {
		
		Connection conn = getConnection();
		
		Grade g = new UserDao().selectGradeInfo(conn, userNo);
		
		close(conn);
		
		return g;
		
	}
	
	public int insertReview(Review r) {
		
		Connection conn = getConnection();
		
		int result = new UserDao().insertReview(conn, r);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int selectTicketWithoutReviewCount(int userNo) {
		
		Connection conn = getConnection();
		
		int ticketCount = new UserDao().selectTicketWithoutReviewCount(conn, userNo);
		
		close(conn);
		
		return ticketCount;
		
	}
	
	public ArrayList<Book> selectTicketWithoutReview(int userNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Book> list = new UserDao().selectTicketWithoutReview(conn, userNo, pi);
		
		close(conn);
		
		return list;
		
	}
	
	public int selectLikeCount(int userNo) {
		
		Connection conn = getConnection();
		
		int likeCount = new UserDao().selectLikeCount(conn, userNo);
		
		close(conn);
		
		return likeCount;
		
	}
	
	public ArrayList<ProductLike> selectAllLike(int userNo, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<ProductLike> list = new UserDao().selectAllLike(conn, userNo, pi);
		
		close(conn);
		
		return list;
		
	}

	public ArrayList<Review> selectProductReview(int productNo){
		Connection conn = getConnection();
		ArrayList<Review> relist = new UserDao().selectProductReview(conn, productNo);
		
		close(conn);
		return relist;
		
	}
	
}
