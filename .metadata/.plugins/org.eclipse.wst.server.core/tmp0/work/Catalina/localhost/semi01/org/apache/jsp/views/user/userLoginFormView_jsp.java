/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-07 07:13:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userLoginFormView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--  로그인 화면 -->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>티켓딱대 로그인</title>\n");
      out.write("    <style>\n");
      out.write("        .head_logo{\n");
      out.write("            /* border: 1px solid; */\n");
      out.write("            width: 458px;\n");
      out.write("            height: 70px;\n");
      out.write("            margin: auto;\n");
      out.write("            margin-top: 100px;\n");
      out.write("        }\n");
      out.write("        .logo{width: 155px;height: 100%;margin: auto;}\n");
      out.write("        .logo *{width: 100%;height: 100%;}\n");
      out.write("        .body{width: 458px;height: 300px; margin: auto; margin-top: 40px; border: 1px solid rgba(128, 128, 128, 0.603); border-radius: 8px;}\n");
      out.write("        .body_input{\n");
      out.write("            border: 1px solid rgba(128, 128, 128, 0.603);\n");
      out.write("            width: 402px;\n");
      out.write("            height: 95px;\n");
      out.write("            margin: auto;\n");
      out.write("            margin-top: 25px;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        .body_input>div{width: 100%;height: 50%;}\n");
      out.write("        .pass{border-top: 1px solid rgba(128, 128, 128, 0.603);}\n");
      out.write("        #login_img{width: 20px;height: 20px; margin-top: 13px; margin-left: 13px; float: left;}\n");
      out.write("        #userId{border: 0; height: 19px;  width: 342px; margin-top: 14px; margin-left: 5px; font-size: 18px; font-weight: 400; outline: none;}\n");
      out.write("        #userId::placeholder {\n");
      out.write("            opacity: 0.5; /* 흐리게 만들기 */\n");
      out.write("        }\n");
      out.write("        #login{\n");
      out.write("            width: 402px;\n");
      out.write("            height: 52px;\n");
      out.write("            margin-left: 28px;\n");
      out.write("            margin-top: 45px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            border: 0;\n");
      out.write("            background-color: rgba(252, 27, 27, 0.897);\n");
      out.write("            color: white;\n");
      out.write("            font-weight: 900;\n");
      out.write("            font-size: 20px;\n");
      out.write("        }\n");
      out.write("        #login:hover{\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        .find_id_pwd{\n");
      out.write("            /* border: 1px solid; */\n");
      out.write("            width: 300px;\n");
      out.write("            height: 30px;\n");
      out.write("            margin-left: 82px;\n");
      out.write("            margin-top: 20px;\n");
      out.write("        }\n");
      out.write("        .find_id_pwd div{float: left;}\n");
      out.write("        .blank{border: 1px solid gray; width: 0px;height: 60%;margin-left: 10px; margin-top: 7px; margin-right: 10px;}\n");
      out.write("        .find{margin-top: 5px; float: left;}\n");
      out.write("        .find_id_pwd a{text-decoration: none; color: gray; font-size: 14px;}\n");
      out.write("        .etc{width: 460px; height: 300px;  margin: auto; margin-top: 70px; }\n");
      out.write("        .event{width: 460px;height: 176px;}\n");
      out.write("        #event_img{width: 100%;height: 100%;}\n");
      out.write("        #event_img:hover{cursor: pointer;}\n");
      out.write("        #etc{margin-left: 10px; margin-top: 40px; font-size: 13px; color: rgba(128, 128, 128, 0.658); }\n");
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
      out.write("    <head>\n");
      out.write("        <div class=\"head_logo\">\n");
      out.write("            <div class=\"logo\"><a href=\"");
      out.print(contextPath );
      out.write("\"><img src=\"resource/logo/logo.png\" alt=\"\"></a></div>\n");
      out.write("        </div>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"");
      out.print(contextPath);
      out.write("/login.me\">\n");
      out.write("            <div class=\"body\">\n");
      out.write("                <div class=\"body_input\">\n");
      out.write("                    <div class=\"id\">\n");
      out.write("                        <img src=\"resource/이미지자료/로그인.png\" id=\"login_img\">\n");
      out.write("                        <div class=\"userId_box\">\n");
      out.write("                            <input type=\"text\" id=\"userId\" name=\"userId\" placeholder=\"아이디\" required>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"pass\">\n");
      out.write("                        <img src=\"resource/이미지자료/비밀번호.png\" id=\"login_img\">\n");
      out.write("                        <div class=\"userId_box\">\n");
      out.write("                            <input type=\"password\" id=\"userId\" name=\"userPwd\" placeholder=\"비밀번호\" required>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <button id=\"login\">로그인</button>\n");
      out.write("                <div class=\"find_id_pwd\">\n");
      out.write("                    <div class=\"find\"><a href=\"");
      out.print(contextPath );
      out.write("/findPwd.ur\">비밀번호 찾기</a></div>\n");
      out.write("                    <div class=\"blank\"></div>\n");
      out.write("                    <div class=\"find\"><a href=\"");
      out.print(contextPath );
      out.write("/findId.ur\">아이디 찾기</a></div>\n");
      out.write("                    <div class=\"blank\"></div> \n");
      out.write("                    <div class=\"find\"><a href=\"");
      out.print(contextPath );
      out.write("/newUser.ur\">회원가입</a></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <div class=\"etc\">\n");
      out.write("            <div class=\"event\">\n");
      out.write("                <img src=\"resource/이미지자료/이벤트.png\" alt=\"\" id=\"event_img\" onclick=\"hing();\">\n");
      out.write("            </div>\n");
      out.write("            <div id=\"etc\">\n");
      out.write("                이용약관 | 개인정보처리방침 | 책임의 한계와 법적고지 | 회원정보 고객센터\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function hing() {\n");
      out.write("            alert(\"힝~ 속았지? >.<\");\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
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
