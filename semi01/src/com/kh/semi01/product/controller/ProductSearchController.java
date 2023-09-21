package com.kh.semi01.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.product.model.service.ProductService;
import com.kh.semi01.product.model.vo.Product;

/**
 * Servlet implementation class ProductSearch
 */
@WebServlet("/search.pr")
public class ProductSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sKeyWord = request.getParameter("sKeyWord");
		ArrayList<Product> list = new ProductService().searchProduct(sKeyWord);
		
		if(list.isEmpty()) {
			request.setAttribute("sKeyWord", sKeyWord);
			request.setAttribute("errorMsg", "에 대한 검색결과가 없습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/searchErrorMsg.jsp");
			view.forward(request, response);
			
		}else {
			request.setAttribute("list", list);
			request.setAttribute("sKeyWord", sKeyWord);
			request.getRequestDispatcher("views/product/productSearch.jsp").forward(request, response);
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
