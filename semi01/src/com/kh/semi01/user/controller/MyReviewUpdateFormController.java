package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Review;

/**
 * Servlet implementation class MyReviewUpdateController
 */
@WebServlet("/updateReviewForm.us")
public class MyReviewUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		Review r = new UserService().selectReview(reviewNo);
		
		request.setAttribute("r", r);
		
		request.getRequestDispatcher("views/user/myReviewUpdateForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
