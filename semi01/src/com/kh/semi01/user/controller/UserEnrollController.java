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
 * Servlet implementation class UserEnrollController
 */
@WebServlet("/insert.ur")
public class UserEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("new_userId");
		String userPwd = request.getParameter("new_userPwd");
		String userEmail = request.getParameter("new_userEmail");
		String userName = request.getParameter("new_userName");
		String userBDay = request.getParameter("new_userBday");
		String userPhone = request.getParameter("new_userPhone");
		String interestMovie = request.getParameter("select_movie_hidden");
		String interestDisplay = request.getParameter("select_display_hidden");
		String interestShow = request.getParameter("select_show_hidden");
		
		User u = new User(userId, userPwd, userName, userBDay, interestMovie, interestDisplay, interestShow, userEmail, userPhone);
		System.out.println(u);
		int result = new UserService().insertUser(u);
		
		HttpSession session = request.getSession();
		
		if(result > 0) { // 등록성공
			session.setAttribute("alertMsg", "성공적으로 회원가입 되었습니다.");
			response.sendRedirect(request.getContextPath()+"/login.ur");
		}else {
			session.setAttribute("alertMsg", "회원가입에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/newUser.ur");
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
