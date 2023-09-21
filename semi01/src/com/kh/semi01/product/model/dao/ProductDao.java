package com.kh.semi01.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.semi01.common.JDBCTemplate.*;

import com.kh.semi01.product.model.vo.Editor;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductIMG;
import com.kh.semi01.product.model.vo.ProductLike;
import com.kh.semi01.product.model.vo.ScreeningInfo;

public class ProductDao {
	
	private Properties prop = new Properties();
	
	public ProductDao() {
		String filePath = ProductDao.class.getResource("/db/sql/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Product> searchProduct(Connection conn, String sKeyWord) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(sKeyWord.isEmpty()) {
				list.isEmpty();
			}else {
			
			pstmt.setString(1, "%" +  sKeyWord + "%");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("product_no"),
								   rset.getString("product_title"),
								   rset.getString("address"),
								   rset.getString("start_period"),
								   rset.getString("end_period"),
								   rset.getInt("price"),
								   rset.getString("image_path"),
								   rset.getString("poster_name")
								   ));
			}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		}
	
	public Product selectProductDetail(Connection conn, int productNo) {
		Product p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getInt("product_no"),
								rset.getString("product_title"),
								rset.getString("address"),
								rset.getString("start_period"),
								rset.getString("end_period"),
								rset.getString("level_name"),
								rset.getInt("run_time"),
								rset.getInt("price"),
								rset.getString("poster_name"),
								rset.getString("image_path")
								);
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}
	
	public ProductIMG selectProductIMG(Connection conn, int productNo) {
		ProductIMG pi = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductIMG");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pi = new ProductIMG(rset.getInt("product_no"),
							 		rset.getString("poster_name"),
							 		rset.getString("detail1_name"),
							 		rset.getString("detail2_name"),
							 		rset.getString("detail3_name"),
							 		rset.getString("detail4_name"),
							 		rset.getString("detail5_name"),
							 		rset.getString("image_path"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pi;
		
	}
	
	public ScreeningInfo selectScreeningInfo(Connection conn, int productNo) {
		ScreeningInfo si = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectScreeningInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				si = new ScreeningInfo(rset.getInt("product_no"),
							 		rset.getString("screening_date"),
							 		rset.getString("screening_day_time"),
							 		rset.getString("screening_night_time"),
							 		rset.getInt("screening_day_seat"),
							 		rset.getInt("screening_night_seat"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return si;
	}
	
	public ArrayList<Product> selectProductTotalRank(Connection conn){
		ArrayList<Product> plist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductTotalRank");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist.add(new Product(rset.getInt("product_no"),
								   rset.getString("product_title"),
								   rset.getString("start_period"),
								   rset.getString("end_period")
								   ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return plist;
	}
	
	public ArrayList<ProductIMG> selectProductTotalRankIMG(Connection conn){
		ArrayList<ProductIMG> ilist = new ArrayList<ProductIMG>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductTotalRankIMG");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ilist.add(new ProductIMG(rset.getInt("product_no"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("detail1_name"),
				 					  rset.getString("detail2_name"),
				 					  rset.getString("detail3_name"),
				 					  rset.getString("detail4_name"),
				 					  rset.getString("detail5_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return ilist;
		
	}
	
	public ArrayList<Product> selectProductDisplayRank(Connection conn, int userNo){
		ArrayList<Product> dlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductDisplayRank");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				dlist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return dlist;
	
	}
	
	public ArrayList<Product> selectProductMovieRank(Connection conn, int userNo){
		ArrayList<Product> mlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductMovieRank");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mlist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return mlist;
	
	}
	
	public ArrayList<Product> selectProductShowRank(Connection conn, int userNo){
		ArrayList<Product> slist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductShowRank");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				slist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return slist;
	
	}
	
//	여기부터 소카테고리별 상위 5개씩 메인화면에 쏴주는 상품들 Dao 12개
	public ArrayList<Product> selectProductCategoryTotalRank1(Connection conn){
		ArrayList<Product> plist1 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank1");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist1.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist1;
	
	}
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank2(Connection conn){
		ArrayList<Product> plist2 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist2.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist2;
	
	}
	
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank3(Connection conn){
		ArrayList<Product> plist3 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist3.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist3;
	
	}
	
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank4(Connection conn){
		ArrayList<Product> plist4 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank4");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist4.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist4;
	
	}
	
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank5(Connection conn){
		ArrayList<Product> plist5 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank5");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist5.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist5;
	
	}
	
	// 6
	public ArrayList<Product> selectProductCategoryTotalRank6(Connection conn){
		ArrayList<Product> plist6 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank6");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist6.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist6;
	
	}
	
	// 7
	public ArrayList<Product> selectProductCategoryTotalRank7(Connection conn){
		ArrayList<Product> plist7 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank7");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist7.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist7;
	
	}
	
	// 8
	public ArrayList<Product> selectProductCategoryTotalRank8(Connection conn){
		ArrayList<Product> plist8 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank8");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist8.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist8;
	
	}
	
	// 9
	public ArrayList<Product> selectProductCategoryTotalRank9(Connection conn){
		ArrayList<Product> plist9 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank9");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist9.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist9;
	
	}
	
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank10(Connection conn){
		ArrayList<Product> plist10 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank10");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist10.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist10;
	
	}
	
	// 2
	public ArrayList<Product> selectProductCategoryTotalRank11(Connection conn){
		ArrayList<Product> plist11 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank11");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist11.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist11;
	
	}
	
	// 12
	public ArrayList<Product> selectProductCategoryTotalRank12(Connection conn){
		ArrayList<Product> plist12 = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductCategoryTotalRank12");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				plist12.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return plist12;
	
	}
	
	public ArrayList<Product> selectExpectedMovieList(Connection conn, String ctype){
		ArrayList<Product> mlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectExpectedMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("영화")) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 2);
				pstmt.setInt(3, 3);
				pstmt.setInt(4, 4);
			}else if(ctype.equals("전시")){
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 6);
				pstmt.setInt(3, 7);
				pstmt.setInt(4, 8);
			}else if(ctype.equals("공연")) {
				pstmt.setInt(1, 9);
				pstmt.setInt(2, 10);
				pstmt.setInt(3, 11);
				pstmt.setInt(4, 12);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mlist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return mlist;
	}
	
	public ArrayList<Product> selectTotalMovieList(Connection conn, String ctype){
		ArrayList<Product> mtlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTotalMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("영화")) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, 2);
				pstmt.setInt(3, 3);
				pstmt.setInt(4, 4);
			}else if(ctype.equals("전시")){
				pstmt.setInt(1, 5);
				pstmt.setInt(2, 6);
				pstmt.setInt(3, 7);
				pstmt.setInt(4, 8);
			}else if(ctype.equals("공연")) {
				pstmt.setInt(1, 9);
				pstmt.setInt(2, 10);
				pstmt.setInt(3, 11);
				pstmt.setInt(4, 12);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				mtlist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return mtlist;
	}
	public ArrayList<Product> selectExpectedMovieRomanceList(Connection conn, String ctype){
		ArrayList<Product> rlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectExpectedMovieRomanceList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("로맨스")) {
				pstmt.setInt(1, 1);
			}else if(ctype.equals("공포스릴러")){
				pstmt.setInt(1, 2);
			}else if(ctype.equals("코미디")) {
				pstmt.setInt(1, 3);
			}else if(ctype.equals("액션")){
				pstmt.setInt(1, 4);
			}else if(ctype.equals("그림전시")) {
				pstmt.setInt(1, 5);
			}else if(ctype.equals("작품전시")){
				pstmt.setInt(1, 6);
			}else if(ctype.equals("사진전시")) {
				pstmt.setInt(1, 7);
			}else if(ctype.equals("체험전시")){
				pstmt.setInt(1, 8);
			}else if(ctype.equals("뮤지컬")) {
				pstmt.setInt(1, 9);
			}else if(ctype.equals("연극")){
				pstmt.setInt(1, 10);
			}else if(ctype.equals("클래식")) {
				pstmt.setInt(1, 11);
			}else if(ctype.equals("콘서트")){
				pstmt.setInt(1, 12);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rlist.add(new Product(rset.getInt("product_no"),
						rset.getString("product_title"),
						rset.getString("start_period"),
						rset.getString("end_period"),
						rset.getString("poster_name"),
						rset.getString("image_path")
						));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rlist;
	}
	public ArrayList<Product> selectTotalMovieRomanceList(Connection conn, String ctype){
		ArrayList<Product> rtlist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTotalMovieRomanceList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("로맨스")) {
				pstmt.setInt(1, 1);
			}else if(ctype.equals("공포스릴러")){
				pstmt.setInt(1, 2);
			}else if(ctype.equals("코미디")) {
				pstmt.setInt(1, 3);
			}else if(ctype.equals("액션")){
				pstmt.setInt(1, 4);
			}else if(ctype.equals("그림전시")) {
				pstmt.setInt(1, 5);
			}else if(ctype.equals("작품전시")){
				pstmt.setInt(1, 6);
			}else if(ctype.equals("사진전시")) {
				pstmt.setInt(1, 7);
			}else if(ctype.equals("체험전시")){
				pstmt.setInt(1, 8);
			}else if(ctype.equals("뮤지컬")) {
				pstmt.setInt(1, 9);
			}else if(ctype.equals("연극")){
				pstmt.setInt(1, 10);
			}else if(ctype.equals("클래식")) {
				pstmt.setInt(1, 11);
			}else if(ctype.equals("콘서트")){
				pstmt.setInt(1, 12);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rtlist.add(new Product(rset.getInt("product_no"),
						rset.getString("product_title"),
						rset.getString("start_period"),
						rset.getString("end_period"),
						rset.getString("poster_name"),
						rset.getString("image_path")
						));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return rtlist;
	}
	
	public ProductLike selectLike(Connection conn, int userNo, int productNo) {
		
		ProductLike pl = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLike");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pl = new ProductLike(rset.getInt("product_no"), 
									 rset.getInt("user_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pl;
		
	}
	
	public int insertLike(Connection conn, int userNo, int productNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertLike");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteLike(Connection conn, int userNo, int productNo) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteLike");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			pstmt.setInt(2, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int selectSeat(Connection conn, int productNo, String screeningDate, String time) {
		
		int seatCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "";
		
		if(time.equals("11:00")) {
			query = "selectDaySeat";
		}
		else {
			query = "selectNightSeat";
		}
		
		String sql = prop.getProperty(query);
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			pstmt.setString(2, screeningDate);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
			
				seatCount = rset.getInt("seat");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return seatCount;
		
	}
	
	public ArrayList<Editor> selectProductEditor(Connection conn, int productNo){
	      ArrayList<Editor> llist = new ArrayList<Editor>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectProductEditor");
	      System.out.println("dao no" + productNo);
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, productNo);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            llist.add(new Editor(rset.getInt("product_no"),
	                            rset.getString("editor"),
	                            rset.getString("deit_comment")
	                  ));
	            
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return llist;
	   }
	   
	// 랭킹 카테고리 10개 상품 조회
	public ArrayList<Product> selectProductRank(Connection conn){
	      ArrayList<Product> prclist = new ArrayList<Product>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectProductRank");
	      
	      try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			 while(rset.next()) {
		            prclist.add(new Product(rset.getInt("product_no"),
		                            		rset.getString("product_title"),
		                            		rset.getString("address"),
		                            		rset.getString("start_period"),
		                            		rset.getString("end_period"),
		                            		rset.getInt("price"),
		                            		rset.getString("image_path"),
		                            		rset.getString("poster_name")
		                  ));
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	      return prclist;
	      
	   }
	
	public ArrayList<Product> selectLocationProduct(Connection conn, String ctype){
		ArrayList<Product> lolist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectLocationProduct");

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("서울")) {
				pstmt.setInt(1, 1);
			}else if(ctype.equals("경기")) {
				pstmt.setInt(1, 2);
			}else if(ctype.equals("충청")) {
				pstmt.setInt(1, 3);
			}else if(ctype.equals("전라")) {
				pstmt.setInt(1, 4);
			}else if(ctype.equals("경상")) {
				pstmt.setInt(1, 5);
			}else if(ctype.equals("제주")) {
				pstmt.setInt(1, 6);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				lolist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return lolist;
	
	}
	
	public ArrayList<Product> selectLocationTotalProduct(Connection conn, String ctype){
		ArrayList<Product> lolist = new ArrayList<Product>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectLocationTotalProduct");

		
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(ctype.equals("서울")) {
				pstmt.setInt(1, 1);
			}else if(ctype.equals("경기")) {
				pstmt.setInt(1, 2);
			}else if(ctype.equals("충청")) {
				pstmt.setInt(1, 3);
			}else if(ctype.equals("전라")) {
				pstmt.setInt(1, 4);
			}else if(ctype.equals("경상")) {
				pstmt.setInt(1, 5);
			}else if(ctype.equals("제주")) {
				pstmt.setInt(1, 6);
			}
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				lolist.add(new Product(rset.getInt("product_no"),
				 					  rset.getString("product_title"),
				 					  rset.getString("start_period"),
				 					  rset.getString("end_period"),
				 					  rset.getString("poster_name"),
				 					  rset.getString("image_path")
								   ));
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			return lolist;
	}

}
