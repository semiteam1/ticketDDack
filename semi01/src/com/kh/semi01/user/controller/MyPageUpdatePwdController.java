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
 * Servlet implementation class MyPageUpdatePwdController
 */
@WebServlet("/updatePwd.us")
public class MyPageUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String updatePwd = request.getParameter("updatePwd");
		
		int result = new UserService().updatePwd(userNo, updatePwd);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "비밀번호 변경에 성공했습니다.");
			session.removeAttribute("loginMember");
			
			response.sendRedirect(request.getContextPath());
		}
		else {
			session.setAttribute("alertMsg", "비밀번호 변경에 실패했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/myPage.us");
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
