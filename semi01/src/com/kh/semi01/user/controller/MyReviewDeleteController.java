package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.user.model.service.UserService;

/**
 * Servlet implementation class MyReviewDeleteController
 */
@WebServlet("/deleteReview.us")
public class MyReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		int result = new UserService().deleteReview(reviewNo);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "리뷰 삭제에 성공했습니다.");
			
		}
		else {
			session.setAttribute("alertMsg", "리뷰 삭제에 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/myReview.us?cpage=1");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
