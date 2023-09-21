package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		User loginMember = new UserService().loginMember(userId, userPwd);
		
		System.out.println(loginMember);
		
		HttpSession session = request.getSession();
		
		if(loginMember == null) {

			session.setAttribute("alertMsg", "아이디 비밀번호를 잘못입력했습니다. 다시 확인해주세요.");
			response.sendRedirect(request.getContextPath()+"/login.ur");
		}
		else {
			session.setAttribute("loginMember", loginMember);
			session.setAttribute("alertMsg", loginMember.getUserName() + " 님 환영합니다!!");
			response.sendRedirect(request.getContextPath());
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
