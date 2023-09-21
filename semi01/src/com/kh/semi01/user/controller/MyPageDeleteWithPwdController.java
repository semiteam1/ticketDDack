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
 * Servlet implementation class MyPageDeleteWithPwdController
 */
@WebServlet("/deleteUserWithPwd.us")
public class MyPageDeleteWithPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDeleteWithPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new UserService().deleteUser(userNo);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			
			session.setAttribute("alertMsg", "성공적으로 탈퇴에 성공했습니다. 그동안 이용해 주셔서 감사합니다.");
			
			session.removeAttribute("loginMember");
			
			response.sendRedirect(request.getContextPath());
			
		}
		else {
			
			session.setAttribute("alertMsg", "회원탈퇴에 실패했습니다. 다시 시도해 주세요.");
			
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
