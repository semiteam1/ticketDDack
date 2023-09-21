package com.kh.semi01.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Grade;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class MyTicketDetailCotroller
 */
@WebServlet("/ticketDetail.us")
public class MyTicketDetailCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTicketDetailCotroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int bookedNo = Integer.parseInt(request.getParameter("bno"));
		int userNo = ((User)(request.getSession().getAttribute("loginMember"))).getUserNo();
		
		UserService us = new UserService();
		
		Book b = us.selectTicketDetail(bookedNo);
		
		Grade g = us.selectGradeInfo(userNo);
		
		if(b == null || g == null) {
			request.getSession().setAttribute("alertMsg", "상세조회에 실패했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myTicket.us?cpage=" + currentPage);
		}
		else {
			request.setAttribute("bookedNo", bookedNo);
			request.setAttribute("b", b);
			request.setAttribute("g", g);
			
			request.getRequestDispatcher("views/user/myTicketDetail.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
