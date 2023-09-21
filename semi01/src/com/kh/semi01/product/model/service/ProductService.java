package com.kh.semi01.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.semi01.common.JDBCTemplate.*;
import com.kh.semi01.product.model.dao.ProductDao;
import com.kh.semi01.product.model.vo.Editor;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductIMG;
import com.kh.semi01.product.model.vo.ProductLike;
import com.kh.semi01.product.model.vo.ScreeningInfo;

public class ProductService {
	
	public ArrayList<Product> searchProduct(String sKeyWord) {
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().searchProduct(conn, sKeyWord);

		close(conn);
		
		return list;
		
	}
	
	public Product selectProductDetail(int productNo) {
		Connection conn = getConnection();
		Product p = new ProductDao().selectProductDetail(conn, productNo);
		
		close(conn);
		return p;
		
	}
	
	public ProductIMG selectProductIMG(int productNo) {
		Connection conn = getConnection();
		ProductIMG pi = new ProductDao().selectProductIMG(conn, productNo);
		
		close(conn);
		return pi;
	}
	
	public ScreeningInfo selectScreeningInfo(int productNo) {
		Connection conn = getConnection();
		ScreeningInfo si = new ProductDao().selectScreeningInfo(conn, productNo);
		
		close(conn);
		return si;
	}
	
	public ArrayList<Product> selectProductTotalRank(){
		Connection conn = getConnection();
		ArrayList<Product> plist = new ProductDao().selectProductTotalRank(conn);
		
		close(conn);
		return plist;
	}
	
	public ArrayList<ProductIMG> selectProductTotalRankIMG(){
		Connection conn = getConnection();
		ArrayList<ProductIMG> ilist = new ProductDao().selectProductTotalRankIMG(conn);
		
		close(conn);
		return ilist;
	}
	
	public ArrayList<Product> selectProductDisplayRank(int userNo){
		Connection conn = getConnection();
		ArrayList<Product> dlist = new ProductDao().selectProductDisplayRank(conn, userNo);
		
		close(conn);
		return dlist;
	}
	
	public ArrayList<Product> selectProductMovieRank(int userNo){
		Connection conn = getConnection();
		ArrayList<Product> mlist = new ProductDao().selectProductMovieRank(conn, userNo);
		
		close(conn);
		return mlist;
	}
	
	public ArrayList<Product> selectProductShowRank(int userNo){
		Connection conn = getConnection();
		ArrayList<Product> slist = new ProductDao().selectProductShowRank(conn, userNo);
		
		close(conn);
		return slist;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank1(){
		Connection conn = getConnection();
		ArrayList<Product> plist1 = new ProductDao().selectProductCategoryTotalRank1(conn);
		
		close(conn);
		return plist1;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank2(){
		Connection conn = getConnection();
		ArrayList<Product> plist2 = new ProductDao().selectProductCategoryTotalRank2(conn);
		
		close(conn);
		return plist2;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank3(){
		Connection conn = getConnection();
		ArrayList<Product> plist3 = new ProductDao().selectProductCategoryTotalRank3(conn);
		
		close(conn);
		return plist3;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank4(){
		Connection conn = getConnection();
		ArrayList<Product> plist4 = new ProductDao().selectProductCategoryTotalRank4(conn);
		
		close(conn);
		return plist4;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank5(){
		Connection conn = getConnection();
		ArrayList<Product> plist5 = new ProductDao().selectProductCategoryTotalRank5(conn);
		
		close(conn);
		return plist5;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank6(){
		Connection conn = getConnection();
		ArrayList<Product> plist6 = new ProductDao().selectProductCategoryTotalRank6(conn);
		
		close(conn);
		return plist6;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank7(){
		Connection conn = getConnection();
		ArrayList<Product> plist7 = new ProductDao().selectProductCategoryTotalRank7(conn);
		
		close(conn);
		return plist7;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank8(){
		Connection conn = getConnection();
		ArrayList<Product> plist8 = new ProductDao().selectProductCategoryTotalRank8(conn);
		
		close(conn);
		return plist8;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank9(){
		Connection conn = getConnection();
		ArrayList<Product> plist9 = new ProductDao().selectProductCategoryTotalRank9(conn);
		
		close(conn);
		return plist9;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank10(){
		Connection conn = getConnection();
		ArrayList<Product> plist10 = new ProductDao().selectProductCategoryTotalRank10(conn);
		
		close(conn);
		return plist10;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank11(){
		Connection conn = getConnection();
		ArrayList<Product> plist11 = new ProductDao().selectProductCategoryTotalRank11(conn);
		
		close(conn);
		return plist11;
	}
	
	public ArrayList<Product> selectProductCategoryTotalRank12(){
		Connection conn = getConnection();
		ArrayList<Product> plist12 = new ProductDao().selectProductCategoryTotalRank12(conn);
		
		close(conn);
		return plist12;
	}
	
	public ArrayList<Product> selectExpectedMovieList(String ctype){
		Connection conn = getConnection();
		ArrayList<Product> mlist = new ProductDao().selectExpectedMovieList(conn, ctype);
		
		close(conn);
		return mlist;
	}
	
	public ArrayList<Product> selectTotalMovieList(String ctype){
		Connection conn = getConnection();
		ArrayList<Product> mtlist = new ProductDao().selectTotalMovieList(conn, ctype);
		
		close(conn);
		return mtlist;
	}
	public ArrayList<Product> selectExpectedMovieRomanceList(String ctype){
		Connection conn = getConnection();
		ArrayList<Product> rlist = new ProductDao().selectExpectedMovieRomanceList(conn, ctype);
		
		close(conn);
		return rlist;
	}
	
	public ArrayList<Product> selectTotalMovieRomanceList(String ctype){
		Connection conn = getConnection();
		ArrayList<Product> rtlist = new ProductDao().selectTotalMovieRomanceList(conn, ctype);
		
		close(conn);
		return rtlist;
	}
	
	public ProductLike selectLike(int userNo, int productNo) {
		
		Connection conn = getConnection();
		
		ProductLike pl = new ProductDao().selectLike(conn, userNo, productNo);
		
		close(conn);
		
		return pl;
		
	}
	
	public int insertLike(int userNo, int productNo) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().insertLike(conn, userNo, productNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteLike(int userNo, int productNo) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().deleteLike(conn, userNo, productNo);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int selectSeat(int productNo, String screeningDate, String time) {
		
		Connection conn = getConnection();
		
		int seatCount = new ProductDao().selectSeat(conn, productNo, screeningDate, time);
		
		close(conn);
		
		return seatCount;
		
	}
	public ArrayList<Editor> selectProductEditor(int productNo){
		Connection conn = getConnection();
		ArrayList<Editor> llist = new ProductDao().selectProductEditor(conn, productNo);
		
		close(conn);
		return llist;
	}
	
	public ArrayList<Product> selectProductRank(){
		Connection conn = getConnection();
		ArrayList<Product> prclist = new ProductDao().selectProductRank(conn);
		
		close(conn);
		return prclist;
	}
	
	public ArrayList<Product> selectLocationProduct(String ctype){
		Connection conn = getConnection();
		ArrayList<Product> lolist = new ProductDao().selectLocationProduct(conn, ctype);
		
		close(conn);
		return lolist;
	}


}
