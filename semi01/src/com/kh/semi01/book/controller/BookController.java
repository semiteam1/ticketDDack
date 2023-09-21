package com.kh.semi01.book.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.book.model.vo.BookNPayment;
import com.kh.semi01.product.model.service.ProductService;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Book;
import com.kh.semi01.user.model.vo.Grade;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/book.bo")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User loginMember = (User)request.getSession().getAttribute("loginMember");
		
//		Grade g = new UserService().selectGradeInfo(loginMember.getUserNo());
		
		int productNo = Integer.parseInt(request.getParameter("pno"));
		
		Product p = new ProductService().selectProductDetail(productNo);
		
		String bookedDate = request.getParameter("bookedDate");
		
		String screenTime = request.getParameter("screenTime");
		
		int spareSeat = Integer.parseInt(request.getParameter("spareSeat"));
		
		BookNPayment bp = new BookNPayment(bookedDate, screenTime, spareSeat);
				
		System.out.println("loginMember : " + loginMember);
//		System.out.println("g : " + g);
		System.out.println("p : " + p);
		System.out.println("bp : " + bp);
		
		request.setAttribute("loginMember", loginMember);
//		request.setAttribute("g", g);
		request.setAttribute("p", p);
		request.setAttribute("bp", bp);
		
		request.getRequestDispatcher("views/book/book.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
