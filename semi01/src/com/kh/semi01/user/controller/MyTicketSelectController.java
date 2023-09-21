package com.kh.semi01.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.common.model.vo.PageInfo;
import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Review;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class MyTicketSelectController
 */
@WebServlet("/myTicket.us")
public class MyTicketSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTicketSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = ((User)(request.getSession().getAttribute("loginMember"))).getUserNo();
		
		int ticketCount = new UserService().selectTicketCount(userNo);
		
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		int pageLimit = 5;
		
		int ticketLimit = 2;
		
		int maxPage = (int)Math.ceil((double)ticketCount / ticketLimit);
		
		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(ticketCount, currentPage, pageLimit, ticketLimit, maxPage, startPage, endPage);
		
		ArrayList<Book> list = new UserService().selectAllTicket(userNo, pi);
		
//		System.out.println(list.get(0).getTitleImg());
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/user/myTicket.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
