
package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Review;

/**
 * Servlet implementation class MyReviewWriteController
 */
@WebServlet("/reviewWriteForm.us")
public class MyReviewWriteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewWriteFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bookedNo = Integer.parseInt(request.getParameter("bno"));

		Book b = new UserService().selectTicketDetail(bookedNo);
		
		request.setAttribute("b", b);
	
		request.getRequestDispatcher("views/user/myReviewWrite.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
