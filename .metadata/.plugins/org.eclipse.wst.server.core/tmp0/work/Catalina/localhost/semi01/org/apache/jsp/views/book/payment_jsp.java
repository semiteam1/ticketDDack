/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-09-08 00:07:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.semi01.user.model.vo.Book;

public final class payment_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.semi01.user.model.vo.Book");
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
      out.write('\n');

	String contextPath = request.getContextPath();

	String userName = (String)request.getAttribute("userName");
	
	String price = (String)request.getAttribute("price");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>티켓딱대</title>\n");
      out.write("<!-- Latest compiled and minified CSS -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("<!-- jQuery library -->\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Popper JS -->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- Latest compiled JavaScript -->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<style>\n");
      out.write("	div {\n");
      out.write("		/* border: 1px solid red; */\n");
      out.write("	}\n");
      out.write("	.outer {\n");
      out.write("		height: 900px;\n");
      out.write("	}\n");
      out.write("	.outer>div {\n");
      out.write("		width: 100%;\n");
      out.write("	}\n");
      out.write("	#logo {\n");
      out.write("		height: 12%;\n");
      out.write("	}\n");
      out.write("	#pay-info {\n");
      out.write("		line-height: 2;\n");
      out.write("	}\n");
      out.write("	h3 {\n");
      out.write("		margin-left: 15px;\n");
      out.write("	}\n");
      out.write("	th {\n");
      out.write("		width: 150px;\n");
      out.write("	}\n");
      out.write("    #pageClose {\n");
      out.write("        width: 100%;\n");
      out.write("    }\n");
      out.write("	#pageClose>a {\n");
      out.write("		margin: 10px;\n");
      out.write("        display: block;\n");
      out.write("        height: 35px;\n");
      out.write("        padding: 0 12px;\n");
      out.write("        line-height: 32px;\n");
      out.write("        border-radius: 3px;\n");
      out.write("        border: 1px solid #bbb;\n");
      out.write("        box-sizing: border-box;\n");
      out.write("        background-color: #f9f9f9;\n");
      out.write("        text-decoration: none;\n");
      out.write("        text-align: center;\n");
      out.write("        font-size: 13px;\n");
      out.write("        color: #202020;\n");
      out.write("		width: 60px;\n");
      out.write("	}\n");
      out.write("	#pageClose>a:hover {\n");
      out.write("		cursor: pointer;\n");
      out.write("		opacity: 0.7;\n");
      out.write("	}\n");
      out.write("	th, td {\n");
      out.write("		border: 1px solid #cecece;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<div class=\"outer\" align=\"center\">\n");
      out.write("	\n");
      out.write("		<div id=\"logo\" align=\"center\">\n");
      out.write("			<img width=\"200\" height=\"100\" src=\"resource/logo/logo.png\">\n");
      out.write("		</div>\n");
      out.write("			\n");
      out.write("        <div id=\"pay-info\">\n");
      out.write("            <h3>계좌이체</h3>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>주문자</th>\n");
      out.write("                    <td>");
      out.print( userName );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>결제 금액</th>\n");
      out.write("                    <td>");
      out.print( price );
      out.write("원</td>\n");
      out.write("                </tr>\n");
      out.write("				<tr>\n");
      out.write("					<th>입금하실 계좌번호</th>\n");
      out.write("					<td>신한, 110-456-789043 / (주)티켓딱대</td>\n");
      out.write("				</tr>\n");
      out.write("            </table>\n");
      out.write("            <p align=\"center\">※미결제 상태로 24시간을 초과하면 예매가 자동 취소 되오니 유의해 주시기 바랍니다.※</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("     	<div id=\"pageClose\" align=\"center\">\n");
      out.write("       		<a href=\"");
      out.print( contextPath );
      out.write("/myTicket.us?cpage=1\">확인</a>\n");
      out.write("     	</div>\n");
      out.write("\n");
      out.write("	</div>\n");
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