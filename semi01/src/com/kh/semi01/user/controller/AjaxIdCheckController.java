package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.user.model.service.UserService;

/**
 * Servlet implementation class AjaxIdCheckController
 */
@WebServlet("/idCheck.ur")
public class AjaxIdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxIdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkId = request.getParameter("checkId");
		
		int count = new UserService().idCheck(checkId);
		
		if(count > 0) { // 이미 존재하는 아이디 있을 경우 => 사용불가능
			response.getWriter().print("NNNNN");
		}else { // 존재하는 아이디 없을 경우 => 사용가능
			response.getWriter().print("NNNNY");
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
