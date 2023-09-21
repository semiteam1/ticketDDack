/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-07 08:47:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userFindUserPwdForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

	String contextPath = request.getContextPath();
    String alertMsg =(String)session.getAttribute("alertMsg");

      out.write("\n");
      out.write("<!--  비번 찾는 화면 -->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>티켓딱대 비밀번호 찾기</title>\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js\"></script>\n");
      out.write("    <style>\n");
      out.write("        .logo_div{\n");
      out.write("            /* border: 1px solid; */\n");
      out.write("            width: 500px;\n");
      out.write("            height: 100px;\n");
      out.write("            margin: auto;\n");
      out.write("        }\n");
      out.write("        #logo{width: 95px;height: 40px;\n");
      out.write("               margin-top: 30px;}\n");
      out.write("        .outer{\n");
      out.write("            border: 1px solid  rgba(128, 128, 128, 0.603);\n");
      out.write("            border-radius: 5px;\n");
      out.write("            width: 500px;\n");
      out.write("            height: 550px;\n");
      out.write("            margin: auto;\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/\n");
      out.write("        /* 탭메뉴 파트 시작 */\n");
      out.write("\n");
      out.write("        * {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .tab-container {\n");
      out.write("            width: 300px;\n");
      out.write("            height: 50px;\n");
      out.write("            /* border: 1px solid; */\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            margin:  auto;\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .tab-button {\n");
      out.write("            background-color: white;\n");
      out.write("            border: 1px solid rgba(211, 211, 211, 0.397);\n");
      out.write("            background-color: rgba(128, 128, 128, 0.199);\n");
      out.write("            border-bottom: 1px solid red;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            width: 50%;\n");
      out.write("            height: 100%;\n");
      out.write("            font-size: 13px;\n");
      out.write("            font-weight: 900;\n");
      out.write("            text-align: center;\n");
      out.write("            text-decoration: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            transition: background-color 0.3s, border 0.3s, color 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .tab-button:hover {\n");
      out.write("            background-color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .active.tab-button {\n");
      out.write("            border:  1px solid red;\n");
      out.write("            background-color: white;\n");
      out.write("            color: red;\n");
      out.write("            border-bottom: none;\n");
      out.write("            font-weight: bolder;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .tab-content {\n");
      out.write("            display: none;\n");
      out.write("            padding: 20px;\n");
      out.write("            /* background-color: gray; */\n");
      out.write("            margin-top: 200px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .active {\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/\n");
      out.write("        /* 리뷰파트 시작 */\n");
      out.write("        .review{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 50px;\n");
      out.write("            padding-top: 10px;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .review_btn{\n");
      out.write("            float: right;\n");
      out.write("            width: 70px;\n");
      out.write("            height: 50px;\n");
      out.write("            border-radius: 10%;\n");
      out.write("            border: 0;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .review_form{\n");
      out.write("            height: 270px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("\n");
      out.write("        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/\n");
      out.write("        /* 이메일로 찾아라 */\n");
      out.write("\n");
      out.write("        .tab-content {\n");
      out.write("            width: 300px;\n");
      out.write("            margin: auto;\n");
      out.write("            height: 250px;\n");
      out.write("            \n");
      out.write("            border-bottom: 1px solid red;\n");
      out.write("            border-left:  1px solid red;\n");
      out.write("            border-right:  1px solid red;\n");
      out.write("            border-bottom-left-radius: 10px;\n");
      out.write("            border-bottom-right-radius: 10px;\n");
      out.write("            /* display: none; */\n");
      out.write("            /* padding: 20px; */\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* 잘보여라@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/\n");
      out.write("        /* 휴대폰번호로 찾아라 */\n");
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("       \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("        .id_pwd_input{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100px;\n");
      out.write("            border: 1px solid rgba(128, 128, 128, 0.603);\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("        .id_pwd_input>div{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 50px;\n");
      out.write("        }\n");
      out.write("        #new_user{border: none; height: 19px;  width: 80%; margin-top: 16px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}\n");
      out.write("        #newMember_img{width: 20px;height: 20px; margin-top: 15px; margin-left: 13px; float: left;}\n");
      out.write("        .id_pwd_input>div{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 50px;\n");
      out.write("        }\n");
      out.write("        .id_pwd_input{\n");
      out.write("            width: 100%;\n");
      out.write("            height: 150px;\n");
      out.write("            border: 1px solid rgba(128, 128, 128, 0.603);\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("        input{\n");
      out.write("            float: left;\n");
      out.write("        }\n");
      out.write("        .line{\n");
      out.write("            border-bottom: 1px solid rgba(128, 128, 128, 0.603);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        #btn_email{\n");
      out.write("            border: none;\n");
      out.write("            background-color: red;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            width: 256px;\n");
      out.write("            height: 50px;\n");
      out.write("            margin-top: 15px;\n");
      out.write("            color: white;\n");
      out.write("            font-weight: 900;\n");
      out.write("            font-size: 15px;\n");
      out.write("        }\n");
      out.write("        #btn_email:hover{\n");
      out.write("            cursor: pointer;\n");
      out.write("            opacity: 0.7;\n");
      out.write("        }\n");
      out.write("        .find_id_pwd{\n");
      out.write("            /* border: 1px solid; */\n");
      out.write("            width: 180px;\n");
      out.write("            height: 30px;\n");
      out.write("            margin: auto;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("        .find_id_pwd div{float: left;}\n");
      out.write("        .blank{border: 1px solid gray; width: 0px;height: 60%;margin-left: 10px; margin-top: 7px; margin-right: 10px;}\n");
      out.write("        .find{margin-top: 5px; float: left;}\n");
      out.write("        .find_id_pwd a{text-decoration: none; color: gray; font-size: 14px;}\n");
      out.write("        .bener{\n");
      out.write("            /* border: 1px solid rgba(128, 128, 128, 0.603); */\n");
      out.write("            width: 300px;\n");
      out.write("            height: 120px;\n");
      out.write("            margin: auto;\n");
      out.write("            margin-top: 15px;\n");
      out.write("        }\n");
      out.write("        .bener>img{\n");
      out.write("            border: 1px solid rgba(128, 128, 128, 0.603);\n");
      out.write("            border-radius: 10px;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    ");
 if(alertMsg != null) { 
      out.write(" \n");
      out.write("		\n");
      out.write("		<script>\n");
      out.write("			alert(\"");
      out.print( alertMsg );
      out.write("\");\n");
      out.write("		</script>\n");
      out.write("		");
 session.removeAttribute("alertMsg"); 
      out.write("\n");
      out.write("		\n");
      out.write("	");
 } 
      out.write("\n");
      out.write("    <div class=\"logo_div\">\n");
      out.write("        <a href=\"");
      out.print(contextPath );
      out.write("\"><img src=\"resource/logo/logo.png\" id=\"logo\" alt=\"\"></a>\n");
      out.write("    </div>\n");
      out.write("    <form action=\"");
      out.print(contextPath);
      out.write("/userCheck.ur?type=3\"  method=\"post\">\n");
      out.write("        <div class=\"outer\">\n");
      out.write("\n");
      out.write("             <div class=\"tab-container\" >\n");
      out.write("                <button type=\"button\" class=\"tab-button\" style=\"border-top-left-radius: 10px;\" onclick=\"openTab(event, 'tab1')\">이메일로 찾기</button>\n");
      out.write("                <button type=\"button\"  class=\"tab-button\" style=\"border-top-right-radius: 10px;\" onclick=\"openTab(event, 'tab2')\">휴대폰번호로 찾기</button>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("              <div id=\"tab1\" class=\"tab-content\">\n");
      out.write("                <div class=\"id_pwd_input\" >\n");
      out.write("                    <div class=\"line\">\n");
      out.write("                        <img src=\"resource/이미지자료/로그인.png\" id=\"newMember_img\">\n");
      out.write("                            <input type=\"text\" id=\"new_user\" class=\"fine_id\" name=\"fine_id\" placeholder=\"아이디\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"line\">\n");
      out.write("                        <img src=\"resource/이미지자료/달력2.PNG\" id=\"newMember_img\">\n");
      out.write("                            <input type=\"number\" id=\"new_user\" name=\"fine_bday\" placeholder=\"생년월일\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"email_input\">\n");
      out.write("                        <img src=\"resource/이미지자료/이메일2.png\" id=\"newMember_img\">\n");
      out.write("                        <input type=\"email\" id=\"new_user\" name=\"fine_email\" placeholder=\"이메일\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"submit\" id=\"btn_email\" class=\"submit_btn\" onclick=\"check1();\">비밀번호 찾기</button>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("	</form>\n");
      out.write("	<form action=\"");
      out.print(contextPath);
      out.write("/userCheck.ur?type=4\" method=\"post\">\n");
      out.write("              <div id=\"tab2\" class=\"tab-content\">\n");
      out.write("                <div class=\"id_pwd_input\">\n");
      out.write("                    <div class=\"line\">\n");
      out.write("                        <img src=\"resource/이미지자료/로그인.png\" id=\"newMember_img\">\n");
      out.write("                            <input type=\"text\" id=\"new_user\" class=\"fine_id2\" name=\"fine_id\" placeholder=\"아이디\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"line\">\n");
      out.write("                        <img src=\"resource/이미지자료/달력2.PNG\" id=\"newMember_img\">\n");
      out.write("                            <input type=\"number\" id=\"new_user\" name=\"fine_bday\" placeholder=\"생년월일\" required>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"email_input\">\n");
      out.write("                        <img src=\"resource/이미지자료/phone.jpg\" id=\"newMember_img\">\n");
      out.write("                        <input type=\"text\" id=\"new_user\" class=\"fine_phone\" name=\"fine_phone\" placeholder=\"휴대폰번호\" required>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <button type=\"submit\" id=\"btn_email\" class=\"submit_btn\" onclick=\"check2();\">비밀번호 찾기</button>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("              </div>\n");
      out.write("                <div class=\"find_id_pwd\" >\n");
      out.write("                    <div class=\"find\"><a href=\"");
      out.print(contextPath );
      out.write("/findId.ur\">아이디 찾기</a></div>\n");
      out.write("                    <div class=\"blank\"></div>\n");
      out.write("                    <div class=\"find\"><a href=\"");
      out.print(contextPath );
      out.write("/newUser.ur\">회원가입</a></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"bener\">\n");
      out.write("                    <img src=\"resource/이미지자료/배너2.png\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    function check1() {\n");
      out.write("                        var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;\n");
      out.write("    \n");
      out.write("                        if(!idReg.test( $(\".fine_id\").val() )){ // 아이디 틀리다\n");
      out.write("                            $(\".submit_btn\").attr(\"type\",\"button\"); \n");
      out.write("                            alert(\"아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.\");\n");
      out.write("                            $(\".fine_id\").select();\n");
      out.write("                            \n");
      out.write("                        }else { // 아디맞다\n");
      out.write("                            $(\".submit_btn\").attr(\"type\",\"submit\"); \n");
      out.write("    \n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    function check2() {\n");
      out.write("                        var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;\n");
      out.write("    \n");
      out.write("                        var regPhone= /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;\n");
      out.write("    \n");
      out.write("                        if(!idReg.test( $(\".fine_id2\").val() )){ // 아이디 틀리다\n");
      out.write("                            $(\".submit_btn\").attr(\"type\",\"button\"); \n");
      out.write("                            alert(\"아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.\");\n");
      out.write("                            $(\".fine_id\").select();\n");
      out.write("                            \n");
      out.write("                        }else { // 비번맞다\n");
      out.write("                           \n");
      out.write("    \n");
      out.write("                            if (!regPhone.test( $(\".fine_phone\").val() )) { // 전번 틀리다\n");
      out.write("                                $(\".submit_btn\").attr(\"type\",\"button\"); \n");
      out.write("                                alert(\"휴대폰 번호를 확인해주세요.\");\n");
      out.write("                                $(\".fine_phone\").select();\n");
      out.write("                                \n");
      out.write("                            }else{// 전번 맞다\n");
      out.write("                                $(\".submit_btn\").attr(\"type\",\"submit\"); \n");
      out.write("                                \n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                  </script>\n");
      out.write("              <script>\n");
      out.write("              function openTab(event, tabName) {\n");
      out.write("                const tabContents = document.getElementsByClassName(\"tab-content\");\n");
      out.write("                for (const content of tabContents) {\n");
      out.write("                  content.style.display = \"none\";\n");
      out.write("                }\n");
      out.write("              \n");
      out.write("                const tabButtons = document.getElementsByClassName(\"tab-button\");\n");
      out.write("                for (const button of tabButtons) {\n");
      out.write("                  button.classList.remove(\"active\");\n");
      out.write("                }\n");
      out.write("              \n");
      out.write("                document.getElementById(tabName).style.display = \"block\";\n");
      out.write("                event.currentTarget.classList.add(\"active\");\n");
      out.write("              }\n");
      out.write("              \n");
      out.write("              document.getElementById(\"tab1\").style.display = \"block\";\n");
      out.write("              document.getElementsByClassName(\"tab-button\")[0].classList.add(\"active\");\n");
      out.write("              </script>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
