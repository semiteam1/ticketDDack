package com.kh.semi01.manager.model.service;

import static com.kh.semi01.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi01.manager.model.dao.RegistDao;
import com.kh.semi01.manager.model.vo.Select;

public class RegistService {

	public ArrayList<Select> getMovieSelectBoxList() {
		Connection conn = getConnection();
		
		ArrayList<Select> sel = new RegistDao().getMovieSelectBoxList(conn);
		
		close(conn);
		
		return sel;
	}
	
	public ArrayList<Select> getDisplaySelectBoxList(){
		Connection conn = getConnection();
		
		ArrayList<Select> sel = new RegistDao().getDisplaySelectBoxList(conn);
		
		close(conn);
		
		return sel;
	}
	
	public ArrayList<Select> getShowSelectBoxList(){
		Connection conn = getConnection();
		
		ArrayList<Select> sel = new RegistDao().getShowSelectBoxList(conn);
		
		close(conn);
		
		return sel;
	}
}
