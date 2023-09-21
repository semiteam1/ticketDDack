package com.kh.semi01.manager.controller.regist;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi01.product.model.vo.Product;
import com.kh.semi01.product.model.vo.ProductIMG;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ManagerRegistProductController
 */
@WebServlet("/manager-regist-product.do")
public class ManagerRegistProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRegistProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");

        String savePath = request.getSession().getServletContext().getRealPath("/resource/product_upfiles/");
        int maxSize = 10 * 1024 * 1024; 

        MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8");
        Product p = new Product();
        ProductIMG img = new ProductIMG();

        String[] inputNames = {"customFile1", "customFile2", "customFile3", "customFile4", "customFile5", "customFile6"};
        int count = 0;
        for (String inputName : inputNames) {
            if (multiRequest.getFile(inputName) != null) {
                String originalFileName = multiRequest.getOriginalFileName(inputName);
                String savedFileName = multiRequest.getFilesystemName(inputName);
                count++;
                if(count == 1) {
                	img.setPosterName(savedFileName);
                }else if(count == 2) {
                	img.setDetail1Name(savedFileName);
                }else if(count == 3) {
                	img.setDetail2Name(savedFileName);
                }else if(count == 4) {
                	img.setDetail3Name(savedFileName);
                }else if(count == 5) {
                	img.setDetail4Name(savedFileName);
                }else if(count == 6) {
                	img.setDetail5Name(savedFileName);
                }
                img.setImagePath(savePath);
            }
        }
        System.out.println(img);
        
        String smallCategory = multiRequest.getParameter("salsa2");
        String title = multiRequest.getParameter("title");
        String local = multiRequest.getParameter("salsa3");
        String address = multiRequest.getParameter("place");
        int time = Integer.parseInt(multiRequest.getParameter("time"));
        
        String dateString1 = multiRequest.getParameter("date1");
        String dateString2 = multiRequest.getParameter("date2");

	     // 문자열을 날짜 객체로 변환
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     Date date1 = null;
	     Date date2 = null;
	     try {
			date1 = (Date)dateFormat.parse(dateString1);
			date2 = (Date)dateFormat.parse(dateString2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    int dayOrNight = Integer.parseInt(multiRequest.getParameter("salsa4"));
	    int possbleAge = Integer.parseInt(multiRequest.getParameter("salsa5"));
	    int price = Integer.parseInt(multiRequest.getParameter("price"));
	    int seatsNum = Integer.parseInt(multiRequest.getParameter("seatsNum"));
    }

	/**                                   
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
