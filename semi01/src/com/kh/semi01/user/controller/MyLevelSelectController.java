package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class MyLevelSelectController
 */
@WebServlet("/myLevel.us")
public class MyLevelSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLevelSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((User)request.getSession().getAttribute("loginMember")).getUserNo();
		
		int count = new UserService().selectBookCount(userNo);
		
		request.setAttribute("count", count);
		
		String price = new UserService().selectBookPrice(userNo);
		
		request.setAttribute("price", price);
		
		request.getRequestDispatcher("views/user/myLevel.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
