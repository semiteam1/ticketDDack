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
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class MyReviewWriteController
 */
@WebServlet("/reviewWrite.us")
public class MyReviewWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String bookedNo = request.getParameter("bookedNo");
		String reviewContent = request.getParameter("reviewContent");
		String userNo = request.getParameter("userNo");
		
		Review r = new Review(bookedNo, reviewContent, userNo);
		
		int result = new UserService().insertReview(r);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "리뷰작성에 성공했습니다.");
			
			session.setAttribute("userNo", userNo);
		}
		else {
			session.setAttribute("alertMsg", "리뷰작성에 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/myTicket.us?cpage=1");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
