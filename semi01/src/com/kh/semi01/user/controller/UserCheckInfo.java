package com.kh.semi01.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi01.user.model.service.UserService;
import com.kh.semi01.user.model.vo.User;

/**
 * Servlet implementation class UserCheckInfo
 */
// 찾은 아이디 보여주고 비번 바꿔주는 컨트롤러
@WebServlet("/userCheck.ur")
public class UserCheckInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCheckInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int type = Integer.parseInt(request.getParameter("type"));
		System.out.println("아이디나 비번찾기 사이트 돌입 : "+type);
		request.setAttribute("type", type);

		if(type == 1) { // 비번, 생년, 이메일 // 아이디찾기
			String chPwd = request.getParameter("fine_pwd"); // 이름으로 바뀜
			String chBday = request.getParameter("fine_bday");
			String chEmail = request.getParameter("fine_email");
			
			System.out.println("1번 : 이메일로 아이디찾기");
			System.out.println("chPwd : "+chPwd);
			System.out.println("chBday : "+chBday);
			System.out.println("chEmail : "+chEmail);
			
			User u = new UserService().findIdWithEmail(chPwd,chBday,chEmail);
			System.out.println("u : "+u);
			if(u == null) { // 일치하는 정보 없음 // 아이디 찾기 실패
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "일치하는 정보가 없습니다.");
				if(type == 1 || type==2) {
					response.sendRedirect(request.getContextPath() + "/findId.ur");
				}else if(type == 3 || type==4) {
					response.sendRedirect(request.getContextPath() + "/findPwd.ur");
				}
			}else { // 일치하는 정보 있음 // 아이디 찾기 성공
				request.setAttribute("u", u);
				request.getRequestDispatcher("views/user/UserInfoCheckForm.jsp").forward(request, response);
			}
			
		}else if (type == 2) {// 비번, 생년, 핸드폰 // 아이디찾기
			String chPwd = request.getParameter("fine_pwd");
			String chBday = request.getParameter("fine_bday");
			String chPhone = request.getParameter("fine_phone");
			System.out.println("2번 : 핸드폰으로 아이디 찾기");
			System.out.println("chPwd : "+chPwd);
			System.out.println("chBday : "+chBday);
			System.out.println("chPhone : "+chPhone);
			
			User u = new UserService().findIdWithPhone(chPwd,chBday,chPhone);
			System.out.println("u : "+u);
			if(u == null) { // 일치하는 정보 없음 // 아이디 찾기 실패
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "일치하는 정보가 없습니다.");
				if(type == 1 || type==2) {
					response.sendRedirect(request.getContextPath() + "/findId.ur");
				}else if(type == 3 || type==4) {
					response.sendRedirect(request.getContextPath() + "/findPwd.ur");
				}
			}else { // 일치하는 정보 있음 // 아이디 찾기 성공
				request.setAttribute("u", u);
				request.getRequestDispatcher("views/user/UserInfoCheckForm.jsp").forward(request, response);
			}
			
		}else if (type == 3) {// 아디, 생년, 이메일 // 비번찾기
			String chId = request.getParameter("fine_id");
			String chBday = request.getParameter("fine_bday");
			String chEmail = request.getParameter("fine_email");
			
			System.out.println("3번 : 이메일로 비번찾기");
			System.out.println("chId : "+chId);
			System.out.println("chBday : "+chBday);
			System.out.println("chEmail : "+chEmail);
			
			User u = new UserService().findPwdWithEmail(chId,chBday,chEmail);
			System.out.println("u : "+u);
			
			if(u == null) { // 일치하는 정보 없음 // 아이디 찾기 실패
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "일치하는 정보가 없습니다.");
				if(type == 1 || type==2) {
					response.sendRedirect(request.getContextPath() + "/findId.ur");
				}else if(type == 3 || type==4) {
					response.sendRedirect(request.getContextPath() + "/findPwd.ur");
				}
			}else { // 일치하는 정보 있음 // 아이디 찾기 성공
				request.setAttribute("u", u);
				request.getRequestDispatcher("views/user/UserInfoCheckForm.jsp").forward(request, response);
			}
			
		}else if (type == 4) { // 아디, 생년, 전번 // 비번찾기
			String chId = request.getParameter("fine_id");
			String chBday = request.getParameter("fine_bday");
			String chPhone = request.getParameter("fine_phone");
			
			System.out.println("4번 : 전번으로 비번찾기");
			System.out.println("chId"+chId);
			System.out.println("chBday"+chBday);
			System.out.println("chPhone"+chPhone);
			
			User u = new UserService().findPwdWithPhone(chId,chBday,chPhone);
			System.out.println("u : "+u);
			if(u == null) { // 일치하는 정보 없음 // 아이디 찾기 실패
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "일치하는 정보가 없습니다.");
				if(type == 1 || type==2) {
					response.sendRedirect(request.getContextPath() + "/findId.ur");
				}else if(type == 3 || type==4) {
					response.sendRedirect(request.getContextPath() + "/findPwd.ur");
				}
			}else { // 일치하는 정보 있음 // 아이디 찾기 성공
				request.setAttribute("u", u);
				request.getRequestDispatcher("views/user/UserInfoCheckForm.jsp").forward(request, response);
			}
			
			
		}else { // 잘못된경우
			System.out.println("아이디 & 비번 찾기 오류! 난 타입 1~4만 form에 넣음");
		}
		
		
		
		
		
		
		
//		request.getRequestDispatcher("views/user/UserInfoCheckForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
