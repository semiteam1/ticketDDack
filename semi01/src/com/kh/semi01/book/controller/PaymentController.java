package com.kh.semi01.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.book.model.service.BookNPaymentService;
import com.kh.semi01.user.model.vo.Book;

/**
 * Servlet implementation class PaymentFinalController
 */
@WebServlet("/payment.bo")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userNo = request.getParameter("userNo");
		String productNo = request.getParameter("productNo");
		int audience = Integer.parseInt(request.getParameter("audience"));
		String payment = request.getParameter("payment");
		String card = "10";
		String screenDate = request.getParameter("screenDate");
		String screenTime = request.getParameter("screenTime");
		
		String userName = request.getParameter("userName");
		String price = request.getParameter("price");
		
		Book b = new Book(userNo, productNo, audience, payment, card, screenDate, screenTime);
		
		BookNPaymentService bpService = new BookNPaymentService();
		
		int count = bpService.decreaseCount(b);
		
		if(count > 0) {
			
			int result = bpService.insertBook(b);
			
			if(result > 0) {
				
				request.setAttribute("userName", userName);
				request.setAttribute("price", price);
				
				request.getRequestDispatcher("views/book/payment.jsp").forward(request, response);
				
			}
			else {
				request.getSession().setAttribute("alertMsg", "죄송합니다. 다시 시도해 주세요.");
				
				response.sendRedirect(request.getContextPath() + "/detail.pr?pno=" + productNo);
			}
			
		}
		else {
			
			request.getSession().setAttribute("alertMsg", "죄송합니다. 다시 시도해 주세요.");
			
			response.sendRedirect(request.getContextPath() + "/detail.pr?pno=" + productNo);
			
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
