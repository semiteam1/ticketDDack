package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Review;

/**
 * Servlet implementation class MyReviewUpdateController
 */
@WebServlet("/updateReview.us")
public class MyReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String reviewContent = request.getParameter("reviewContent");
		
		Review r = new UserService().updateReview(reviewNo, reviewContent);
		
		HttpSession session = request.getSession();
		
		if(r == null) {
			session.setAttribute("alertMsg", "리뷰 수정에 실패했습니다.");
		}
		else {
			session.setAttribute("alertMsg", "리뷰 수정에 성공했습니다.");
			
			session.setAttribute("r", r);
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
