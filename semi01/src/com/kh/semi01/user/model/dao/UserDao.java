package com.kh.semi01.user.model.dao;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import static com.kh.semi01.common.JDBCTemplate.*;

import com.kh.semi01.common.model.vo.PageInfo;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductLike;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Grade;
import com.kh.semi01.user.model.vo.Review;
import com.kh.semi01.user.model.vo.User;

public class UserDao {
	
	private Properties prop = new Properties();
	
	public UserDao() { // 메소드 아니라 memberdao의 기본 생성자 생성자는 반환형 x 괄호안에 변수 없으니까 기본 생성자다 ~ 실행할 내용이 있어서 쓴거임
		// 언제 실행됨? service.java 가보면 dao호출할 때마다 읽을 거 서버 구동없이 쿼리를 읽을 수가 있음
		String filePath = UserDao.class.getResource("/db/sql/user-mapper.xml").getPath(); // 멤버dao 클래스 이 파일패스 경로에가서 있으면 찾아와달라
		
		try {
			prop.loadFromXML(new FileInputStream(filePath)); // 파일패스에 있는 파일을 읽어들여 xml파일을 읽어들이면서 키는 벨류
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public User loginMember(Connection conn, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("USER_NO"),
							 rset.getString("USER_ID"), 
							 rset.getString("USER_PWD"), 
							 rset.getString("USER_NAME"), 
							 rset.getString("USER_BIRTH"),
							 rset.getString("INTEREST_MOVIE"),
							 rset.getString("INTEREST_DISPLAY"),
							 rset.getString("INTEREST_SHOW"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getString("GRADE_NAME"),
							 rset.getString("ENROLL_DATE"),
							 rset.getString("STATUS")
							);
				
				System.out.println("loginMember : " + u);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return u;
	}

	public int insertUser(Connection conn, User u) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertUser");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPwd());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getUserBirth());
			pstmt.setInt(5, Integer.parseInt(u.getInterestMovie()));
			pstmt.setInt(6, Integer.parseInt(u.getInterestDisplay()));
			pstmt.setInt(7, Integer.parseInt(u.getInterestShow()));
			pstmt.setString(8, u.getEmail());
			pstmt.setString(9, u.getPhone());
			
			result = pstmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
//=======

	public User findIdWithEmail(Connection conn, String chPwd, String chBday, String chEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		String sql = prop.getProperty("findIdWithEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chPwd);
			pstmt.setString(2, chBday);
			pstmt.setString(3, chEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("USER_NO"),
							 rset.getString("USER_ID"), 
							 rset.getString("USER_PWD"), 
							 rset.getString("USER_NAME"), 
							 rset.getString("USER_BIRTH"),
							 rset.getString("INTEREST_MOVIE"),
							 rset.getString("INTEREST_DISPLAY"),
							 rset.getString("INTEREST_SHOW"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getString("GRADE_NAME"),
							 rset.getString("STATUS")
							);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
	}

	public User findIdWithPhone(Connection conn, String chPwd, String chBday, String chPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		String sql = prop.getProperty("findIdWithPhone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chPwd);
			pstmt.setString(2, chBday);
			pstmt.setString(3, chPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("USER_NO"),
							 rset.getString("USER_ID"), 
							 rset.getString("USER_PWD"), 
							 rset.getString("USER_NAME"), 
							 rset.getString("USER_BIRTH"),
							 rset.getString("INTEREST_MOVIE"),
							 rset.getString("INTEREST_DISPLAY"),
							 rset.getString("INTEREST_SHOW"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getString("GRADE_NAME"),
							 rset.getString("STATUS")
							);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
	}

	public User findPwdWithEmail(Connection conn, String chId, String chBday, String chEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		String sql = prop.getProperty("findPwdWithEmail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chId);
			pstmt.setString(2, chBday);
			pstmt.setString(3, chEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("USER_NO"),
							 rset.getString("USER_ID"), 
							 rset.getString("USER_PWD"), 
							 rset.getString("USER_NAME"), 
							 rset.getString("USER_BIRTH"),
							 rset.getString("INTEREST_MOVIE"),
							 rset.getString("INTEREST_DISPLAY"),
							 rset.getString("INTEREST_SHOW"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getString("GRADE_NAME"),
							 rset.getString("STATUS")
							);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
	}

	public User findPwdWithPhone(Connection conn, String chId, String chBday, String chPhone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User u = null;
		
		String sql = prop.getProperty("findPwdWithPhone");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chId);
			pstmt.setString(2, chBday);
			pstmt.setString(3, chPhone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("USER_NO"),
							 rset.getString("USER_ID"), 
							 rset.getString("USER_PWD"), 
							 rset.getString("USER_NAME"), 
							 rset.getString("USER_BIRTH"),
							 rset.getString("INTEREST_MOVIE"),
							 rset.getString("INTEREST_DISPLAY"),
							 rset.getString("INTEREST_SHOW"),
							 rset.getString("EMAIL"),
							 rset.getString("PHONE"),
							 rset.getString("GRADE_NAME"),
							 rset.getString("STATUS")
							);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
	}

	public int changePwd(Connection conn, String fine_pwd, String userNo, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("changePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fine_pwd);
			pstmt.setInt(2, Integer.parseInt(userNo));
			pstmt.setString(3, userId);
			pstmt.setString(4, userPwd);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public int idCheck(Connection conn, String checkId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return count;
	}
	
//>>>>>>> Stashed changes
	
	public int updateUser(Connection conn, User u) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateUser");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, u.getUserName());
			pstmt.setInt(2, Integer.parseInt(u.getInterestMovie()));
			pstmt.setInt(3, Integer.parseInt(u.getInterestDisplay()));
			pstmt.setInt(4, Integer.parseInt(u.getInterestShow()));
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getPhone());
			pstmt.setInt(7, u.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public User selectUser(Connection conn, int userNo) {
		
		User u = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUser");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				u = new User(rset.getInt("user_no"), 
							 rset.getString("user_id"), 
							 rset.getString("user_pwd"), 
							 rset.getString("user_name"), 
							 rset.getString("user_birth"), 
							 rset.getString("interest_movie"), 
							 rset.getString("interest_display"), 
							 rset.getString("interest_show"), 
							 rset.getString("email"), 
							 rset.getString("phone"), 
							 rset.getString("grade_name"), 
							 rset.getString("enroll_date"),
							 rset.getString("status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return u;
		
	}
	
	public int deleteUser(Connection conn, int userNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteUser");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int updatePwd(Connection conn, int userNo, String updatePwd) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwd");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int selectBookCount(Connection conn, int userNo) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBookCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	public String selectBookPrice(Connection conn, int userNo) {
		
		String price = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBookPrice");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				price = rset.getString("price");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return price;
		
	}
	
	public int selectReviewCount(Connection conn, int userNo) {
		
		int reviewCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reviewCount = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviewCount;
		
	}
	
	public ArrayList<Review> selectAllReview(Connection conn, int userNo, PageInfo pi) {
		
		ArrayList<Review> list = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllReview");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("review_no"),
									rset.getInt("product_no"),
									rset.getString("title_img"),
									rset.getString("product_title"),
									rset.getString("review_content"),
									rset.getString("user_id"),
									rset.getString("review_date"),
									rset.getString("status")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public Review selectReview(Connection conn, int reviewNo) {
		
		Review r = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReview");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review();
				
				r.setReviewNo(rset.getInt("review_no"));
				r.setBookedProduct(rset.getString("product_title"));
				r.setUser(rset.getString("user_id"));
				r.setReviewDate(rset.getString("review_date"));
				r.setReviewContent(rset.getString("review_content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
		
	}
	
	public int updateReview(Connection conn, int reviewNo, String reviewContent) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReview");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewContent);
			pstmt.setInt(2, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteReview(Connection conn, int reviewNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int selectTicketCount(Connection conn, int userNo) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTicketCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	public ArrayList<Book> selectAllTicket(Connection conn, int userNo, PageInfo pi) {
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllTicket");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Book(rset.getInt("booked_no"), 
								  rset.getInt("product_no"),
								  rset.getString("product_title"), 
								  rset.getString("screen_date"),
								  rset.getString("title_img"), 
								  rset.getString("address")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public Book selectTicketDetail(Connection conn, int bookedNo) {
		
		Book b = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTicketDetail");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookedNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				b = new Book(rset.getInt("booked_no"),
							 rset.getString("product_title"),
							 rset.getInt("audience"),
							 rset.getString("payment_name"),
							 rset.getInt("price"),
							 rset.getString("screen_date"),
							 rset.getString("address")
							 );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
		
	}
	
	public int increaseCount(Connection conn, int bookedNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		Book b = selectTicketDetail(conn, bookedNo);
		
		String query = "";
		
		if(b.getScreenDate().substring((b.getScreenDate().indexOf(")")) + 1).equals(" 11:00")) {
			
			query = "increaseDaySeatCount";
			
		}
		else {
			
			query = "increaseNightSeatCount";
			
		}
		
		String sql = prop.getProperty(query);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookedNo);
			pstmt.setInt(2, bookedNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteTicket(Connection conn, int bookedNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteTicket");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookedNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public Grade selectGradeInfo(Connection conn, int userNo) {
		
		Grade g = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectGradeInfo");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				g = new Grade(rset.getInt("grade_no"),
							  rset.getString("grade_name"),
							  rset.getDouble("grade_discount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return g;
		
	}
	
	public int insertReview(Connection conn, Review r) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(r.getBookedProduct()));
			pstmt.setString(2, r.getReviewContent());
			pstmt.setInt(3, Integer.parseInt(r.getUser()));
			
			result = pstmt.executeUpdate();;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int selectTicketWithoutReviewCount(Connection conn, int userNo) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTicketWithoutReviewCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	public ArrayList<Book> selectTicketWithoutReview(Connection conn, int userNo, PageInfo pi) {
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTicketWithoutReview");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Book(rset.getInt("booked_no"), 
								  rset.getInt("product_no"),
								  rset.getString("product_title"), 
								  rset.getString("screen_date"),
								  rset.getString("title_img"), 
								  rset.getString("address")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public int selectLikeCount(Connection conn, int userNo) {
		
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLikeCount");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return count;
		
	}
	
	public ArrayList<ProductLike> selectAllLike(Connection conn, int userNo, PageInfo pi) {
		
		ArrayList<ProductLike> list = new ArrayList<ProductLike>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllLike");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new ProductLike(rset.getInt("product_no"), 
								  rset.getString("product_title"), 
								  rset.getString("title_img")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}

	public ArrayList<Review> selectProductReview(Connection conn, int productNo){
		ArrayList<Review> relist = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				relist.add(new Review(rset.getInt("review_no"),
									  rset.getInt("product_no"),
									  rset.getString("user_id"),
									  rset.getString("review_date"),
									  rset.getString("review_content")
									  ));
			}
			
			System.out.println("dao" + relist);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return relist;
	}
	
}
