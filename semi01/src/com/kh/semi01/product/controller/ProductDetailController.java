package com.kh.semi01.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.product.model.service.ProductService;
import com.kh.semi01.product.model.vo.Editor;
import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductIMG;
import com.kh.semi01.product.model.vo.ProductLike;
import com.kh.semi01.product.model.vo.ScreeningInfo;
import com.kh.semi01.user.model.vo.User;
import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.Review;

/**
 * Servlet implementation class ProductDetailView
 */
@WebServlet("/detail.pr")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int productNo = Integer.parseInt(request.getParameter("pno"));
		HttpSession session = request.getSession();
		
		ArrayList<Product> plist = new ProductService().selectProductTotalRank();
		ArrayList<ProductIMG> ilist = new ProductService().selectProductTotalRankIMG();
		
		int userNo = 0;
		if(session.getAttribute("loginMember") != null) {
			userNo = ((User)(session.getAttribute("loginMember"))).getUserNo();
		}
		
		ProductLike pl = new ProductService().selectLike(userNo, productNo);
		
		request.setAttribute("plist", plist); // 전체 상품 중 좋아요 상위 5개
		request.setAttribute("ilist", ilist); // 전체 상품 중 좋아요 상위 5개 (이미지 경로)
		request.setAttribute("pl", pl);
		
		
		Product p = new ProductService().selectProductDetail(productNo);
		
		if(p == null) { // 조회 실패
			
			request.setAttribute("errorMsg", "상품 상세조회에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
			
		}else { // 조회 성공시
			
			ProductIMG pi = new ProductService().selectProductIMG(productNo);
			ScreeningInfo si = new ProductService().selectScreeningInfo(productNo);
			ArrayList<Review> relist = new UserService().selectProductReview(productNo);
			ArrayList<Editor> llist = new ProductService().selectProductEditor(productNo);
			request.setAttribute("p", p);
			request.setAttribute("pi", pi);
			request.setAttribute("si", si);
			request.setAttribute("relist", relist);
			request.setAttribute("llist", llist); // 상품의 에디터 코멘트 
			request.getRequestDispatcher("views/product/productDetail.jsp").forward(request, response);
			System.out.println(productNo);
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
