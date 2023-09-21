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
import com.kh.semi01.product.model.vo.ProductIMG;

/**
 * Servlet implementation class ProductTotalRankController
 */
@WebServlet("/trank.pr")
public class ProductTotalRankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductTotalRankController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Product> plist = new ProductService().selectProductTotalRank();
		ArrayList<ProductIMG> ilist = new ProductService().selectProductTotalRankIMG();
		
		ArrayList<Product> plist1 = new ProductService().selectProductCategoryTotalRank1();
		ArrayList<Product> plist2 = new ProductService().selectProductCategoryTotalRank2();
		ArrayList<Product> plist3 = new ProductService().selectProductCategoryTotalRank3();
		ArrayList<Product> plist4 = new ProductService().selectProductCategoryTotalRank4();
		ArrayList<Product> plist5 = new ProductService().selectProductCategoryTotalRank5();
		ArrayList<Product> plist6 = new ProductService().selectProductCategoryTotalRank6();
		ArrayList<Product> plist7 = new ProductService().selectProductCategoryTotalRank7();
		ArrayList<Product> plist8 = new ProductService().selectProductCategoryTotalRank8();
		ArrayList<Product> plist9 = new ProductService().selectProductCategoryTotalRank9();
		ArrayList<Product> plist10 = new ProductService().selectProductCategoryTotalRank10();
		ArrayList<Product> plist11 = new ProductService().selectProductCategoryTotalRank11();
		ArrayList<Product> plist12 = new ProductService().selectProductCategoryTotalRank12();
		
		request.setAttribute("plist", plist); // 전체 상품 중 좋아요 상위 5개
		request.setAttribute("ilist", ilist); // 전체 상품 중 좋아요 상위 5개 (이미지 경로)
		
		request.setAttribute("plist1", plist1);
		request.setAttribute("plist2", plist2);
		request.setAttribute("plist3", plist3);
		request.setAttribute("plist4", plist4);
		request.setAttribute("plist5", plist5);
		request.setAttribute("plist6", plist6);
		request.setAttribute("plist7", plist7);
		request.setAttribute("plist8", plist8);
		request.setAttribute("plist9", plist9);
		request.setAttribute("plist10", plist10);
		request.setAttribute("plist11", plist11);
		request.setAttribute("plist12", plist12);

		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
