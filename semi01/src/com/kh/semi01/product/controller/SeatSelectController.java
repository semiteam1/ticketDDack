package com.kh.semi01.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.product.model.service.ProductService;

/**
 * Servlet implementation class DaySeatSelectController
 */
@WebServlet("/selectSeat.pr")
public class SeatSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String screeningDate = request.getParameter("screeningDate");
		String time = request.getParameter("time");
		
		System.out.println("좌석 조회용");
		
		System.out.println("상품번호 : " + productNo);
		System.out.println("관람날짜 : " + screeningDate);
		System.out.println("관람시간 : " + time);
		
		int seatCount = new ProductService().selectSeat(productNo, screeningDate, time);
		
		System.out.println("좌석 수 : " + seatCount);
		
		response.getWriter().print(seatCount);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
