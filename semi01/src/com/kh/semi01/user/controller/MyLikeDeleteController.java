package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.product.model.service.ProductService;
import com.kh.semi01.user.model.service.UserService;

/**
 * Servlet implementation class MyLikeDeleteController
 */
@WebServlet("/deleteMyLike.us")
public class MyLikeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLikeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		int result = new ProductService().deleteLike(userNo, productNo);
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			session.setAttribute("alertMsg", "좋아요 내역을 삭제했습니다.");
		}
		else {
			session.setAttribute("alertMsg", "좋아요 내역 삭제에 실패했습니다.");
		}
		
		response.sendRedirect(request.getContextPath() + "/myLike.us?cpage=1");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
