package com.kh.semi01.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.product.model.service.ProductService;
import com.kh.semi01.product.model.vo.Product;

/**
 * Servlet implementation class MovieRomanceListController
 */
@WebServlet("/rmovie.pr")
public class MovieRomanceListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieRomanceListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ctype = request.getParameter("ctype");
		
		ArrayList<Product> rlist = new ProductService().selectExpectedMovieRomanceList(ctype); // 영화 상영예정작
		ArrayList<Product> rtlist = new ProductService().selectTotalMovieRomanceList(ctype); // 영화 전체 리스트
		
		request.setAttribute("ctype", ctype);
		request.setAttribute("rlist", rlist); // 영화 상영예정작
		request.setAttribute("rtlist", rtlist); // 영화 전체 리스트
		
		request.getRequestDispatcher("views/product/movieRomance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
