/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2022-12-21 00:19:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.z02_005fstudy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jspexp.vo.*;
import jspexp.a14_study.*;

public final class _02_005flogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("jspexp.vo");
    _jspx_imports_packages.add("jspexp.a14_study");
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>오늘의 집</title>\r\n");
      out.write("<link href=\"/z02_study/comcom.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"page\">\r\n");
      out.write("	<!--  <div id=\"head\"></div> -->\r\n");
      out.write("	<div id=\"main\">\r\n");
      out.write("		<div class=\"inner\">\r\n");
      out.write("			<img src = \"/z02_study/img/logo.png\" width=\"155px\" height=\"65px\">\r\n");
      out.write("			<form>\r\n");
      out.write("				<input type=\"text\" name=\"id\" placeholder=\"아이디\"  onblur=\"fcid()\"/>\r\n");
      out.write("				<input type=\"password\" name=\"pass\" placeholder=\"비밀번호\"  onblur=\"fcps()\" />\r\n");
      out.write("				<input type=\"submit\" value=\"로그인\" name=\"login\" onclick=\"loginck()\">\r\n");
      out.write("			</form>\r\n");
      out.write("			<div class=\"setting\">\r\n");
      out.write("				<a href=\"03_signup.jsp\">비밀번호 재설정</a>\r\n");
      out.write("				<a href=\"03_signup.jsp\">회원가입</a>\r\n");
      out.write("			</div>\r\n");
      out.write("			<span>SNS계정으로 간편 로그인/회원가입</span>\r\n");
      out.write("			<div class=\"sns\">\r\n");
      out.write("				<a href=\"https://www.facebook.com/\"><img src = \"/z02_study/img/facebookk.png\" width=\"60\" height=\"60\"></src></a>\r\n");
      out.write("				<a href=\"https://www.kakaocorp.com/page/\"><img src = \"/z02_study/img/kakao.png\" target=\"_blank\" width=\"60\" height=\"60\"></a>\r\n");
      out.write("				<a href=\"https://www.naver.com/\"><img src =\"/z02_study/img/naverr.png\"  width=\"60\" height=\"60\"></a>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div id=\"foot\"></div>\r\n");
      out.write("	\r\n");
      out.write("	");

		String id = request.getParameter("id"); if(id==null) id="";
		String pass = request.getParameter("pass"); if(pass==null) pass="";
		
		boolean isFail = false;
		if(id!=null&pass!=null){
			A01_Login dao = new A01_Login();
			if( dao.login(id, pass) ){
				response.sendRedirect("01_main.html");
			}else{
				isFail=true; //실패
			}
		}
	
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("var idObj = document.querySelector(\"[name=id]\")\r\n");
      out.write("var passObj = document.querySelector(\"[name=pass]\")\r\n");
      out.write("\r\n");
      out.write("var isFail = ");
      out.print(isFail );
      out.write(" //로그인실패이면 true\r\n");
      out.write("function loginck(){ //function login()일때는 안됐는데 dao.login과 중복돼서 그런 듯\r\n");
      out.write("	if(isFail){\r\n");
      out.write("		alert(\"존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다\");\r\n");
      out.write("		idObj.focus();\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("//id\r\n");
      out.write("function fcid(){\r\n");
      out.write("	if(!idObj.value){\r\n");
      out.write("		idObj.style.border=\"1px solid red\";\r\n");
      out.write("		idObj.style.boxShadow= \"0 0 3px red\";\r\n");
      out.write("	}else{\r\n");
      out.write("		true;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("idObj.onkeyup=function(){\r\n");
      out.write("	if(idObj.value){\r\n");
      out.write("		idObj.style.border=\"3px solid #B4E8F8\";\r\n");
      out.write("		idObj.style.boxShadow=\"0 0 4px #B4E8F8\";\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//password\r\n");
      out.write("function fcps(){\r\n");
      out.write("	if(!passObj.value){\r\n");
      out.write("		passObj.style.border=\"1px solid red\";\r\n");
      out.write("		passObj.style.boxShadow= \"0 0 3px red\";\r\n");
      out.write("	}else{\r\n");
      out.write("		true;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("passObj.onkeyup=function(){\r\n");
      out.write("	if(passObj.value){\r\n");
      out.write("		passObj.style.border=\"3px solid #B4E8F8\";\r\n");
      out.write("		passObj.style.boxShadow=\"0 0 4px #B4E8F8\";\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
