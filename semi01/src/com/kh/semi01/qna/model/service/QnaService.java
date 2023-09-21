package com.kh.semi01.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import static com.kh.semi01.common.JDBCTemplate.*;

import com.kh.semi01.qna.model.dao.QnaDao;
import com.kh.semi01.qna.model.vo.Qna;

public class QnaService {
	public ArrayList<Qna> selectQnaList(){
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectQnaList(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insertQna(Qna q) {
		Connection conn =getConnection();
		
		int result=new QnaDao().insertQna(conn, q);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Qna selectQna(int qnaNo) {
		Connection conn =getConnection();
		
		Qna q = new QnaDao().selectQna(conn,qnaNo);
		
		close(conn);
		return q;
	}
	
	public int deleteQna(int qnaNo) {
		Connection conn = getConnection();
		int result = new QnaDao().deleteQna(conn, qnaNo);
		
		if(result>0) {
			commit(conn);
	
		}else {
			rollback(conn);
		}
			close(conn);
			return result;
	}
	
	public int insertAnswer(Qna a) {
		Connection conn =getConnection();
		
		int result=new QnaDao().insertAnswer(conn, a);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
