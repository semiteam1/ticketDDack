package com.kh.semi01.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.qna.model.service.QnaService;
import com.kh.semi01.qna.model.vo.Qna;

/**
 * Servlet implementation class AnswerInsertController
 */
@WebServlet("/insert.ao")
public class AnswerInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int qnaNo=Integer.parseInt(request.getParameter("qnano"));
		String answerContent = request.getParameter("content");
		
		HttpSession session=request.getSession();
		
		Qna a = new Qna();
		a.setQnaNo(qnaNo);
		a.setQnaReply(answerContent);
		
		int result = new QnaService().insertAnswer(a);
		
		if(result>0) {
			session.setAttribute("alerMsg", "성공적으로 Q&A를 작성하였습니다.");
			response.sendRedirect(request.getContextPath()+ "/list.qo");
		}else {
			request.setAttribute("errorMsg", "Q&A등록에 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
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
