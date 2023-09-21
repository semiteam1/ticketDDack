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
 * Servlet implementation class MyPageUpdateController
 */
@WebServlet("/myPageUpdate.us")
public class MyPageUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String interestMovie = request.getParameter("interestMovie");
		String interestDisplay = request.getParameter("interestDisplay");
		String interestShow = request.getParameter("interestShow");
		
		User u = new User(userNo, userName, interestMovie, interestDisplay, interestShow, email, phone);
		
		User updateUser = new UserService().updateUser(u);
		
		if(updateUser != null) {
			
			request.getSession().setAttribute("loginMember", updateUser);
			
			request.getSession().setAttribute("alertMsg", "정보변경에 성공했습니다.");
			
		}
		else {
			request.getSession().setAttribute("alertMsg", "정보변경에 실패했습니다.");
			
		}
		
		response.sendRedirect(request.getContextPath() + "/myPage.us");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
