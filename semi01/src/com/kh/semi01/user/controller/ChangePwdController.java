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
 * Servlet implementation class ChangePwdController
 */
@WebServlet("/Changepwd.ur")
public class ChangePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String fine_pwd = request.getParameter("fine_pwd");
		String userNo = request.getParameter("userNo");
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new UserService().changePwd(fine_pwd,userNo,userId,userPwd);
		
		HttpSession session = request.getSession();

		if(result > 0 ) { // 변경성공
			session.setAttribute("alertMsg", "성공적으로 비밀번호가 변경되었습니다.");
			response.sendRedirect(request.getContextPath()+"/login.ur");
			
		}else { // 변경실패
			session.setAttribute("alertMsg", "비밀번호 변경에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/findPwd.ur");
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
