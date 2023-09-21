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
 * Servlet implementation class MyTicketDeleteController
 */
@WebServlet("/deleteTicket.us")
public class MyTicketDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTicketDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookedNo = Integer.parseInt(request.getParameter("bno"));
		
		UserService uService = new UserService();
		
		int count = uService.increaseCount(bookedNo);
		
		HttpSession session = request.getSession();
		
		if(count > 0) {
			
			int result = new UserService().deleteTicket(bookedNo);
			
			
			if(result > 0) {
				session.setAttribute("alertMsg", "예매내역을 삭제했습니다.");
			}
			else {
				session.setAttribute("alertMsg", "예매내역 삭제에 실패했습니다.");
			}
			
		}
		else {
			
			session.setAttribute("alertMsg", "죄송합니다. 다시 시도해 주세요.");
			
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
