/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-05 13:11:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jyh.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>찜꽁 로그인</title>\r\n");
      out.write("<style type = \"text/css\">\r\n");
      out.write(" .content{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 500px;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<link href=\"login_css.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <a href = \"/ljw/pg0000.jsp\" class=\"logo\"><img src=\"/index_markup/img/main_logo.png\" alt=\"#\"></a>\r\n");
      out.write("    </header>\r\n");
      out.write("    <section>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <form action=\"/loginController\" method=\"POST\" onsubmit= \"return userLoginCheck()\">\r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <input id=\"username\" type=\"text\" name=\"email\" placeholder=\"이메일\">\r\n");
      out.write("                    <label for=\"username\">이메일</label>\r\n");
      out.write("                </div>\r\n");
      out.write("    \r\n");
      out.write("                <div class=\"input-box\">\r\n");
      out.write("                    <input id=\"password\" type=\"password\" name=\"pws\" placeholder=\"비밀번호\">\r\n");
      out.write("                    <label for=\"password\">비밀번호</label>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"forgot\">\r\n");
      out.write("                    <div id = \"s01\">\r\n");
      out.write("                    <input type = \"checkbox\" name = \"sVal\"> 로그인 유지하기\r\n");
      out.write("                    <a href=\"emailAuth.jsp\">비밀번호 찾기</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <input type=\"submit\" value=\"로그인\">\r\n");
      out.write("            </form>\r\n");
      out.write("            <div id = \"insert\">\r\n");
      out.write("                <input id = \"kakao\" type = \"button\" value = \"카카오톡으로 시작하기\" class = \"btnK01\" onclick = \"kakaoLogin();\"/>\r\n");
      out.write("                <div id=\"naver_id_login\"></div>\r\n");
      out.write("              <!--  <input id=\"naverIdLogin\" type = \"button\" value = \"페이스북으로 시작하기\" class = \"btnK\"/> -->  \r\n");
      out.write("                <p id = \"insert01\">회원이 아니신가요? <a href = \"/jyh/views/insertMember.jsp\">회원가입 하러가기</a></p>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <footer>\r\n");
      out.write("        <nav class=\"footer_nav\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"#\">서비스 이용약관</a></li>\r\n");
      out.write("                <li><a href=\"#\">개인정보 처리방침</a></li>\r\n");
      out.write("                <li><a href=\"#\">제휴 문의</a></li>\r\n");
      out.write("                <li><a href=\"#\">채용 공고</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <p class=\"jjim_info\">\r\n");
      out.write("            (주) 찜꽁<br>\r\n");
      out.write("            대표 : 이지원<br>\r\n");
      out.write("            주소 : 서울특별시 마포구 월드컵북로 21 2층 풍성빌딩<br>\r\n");
      out.write("            사업자등록번호 : 202212142126<br>\r\n");
      out.write("            개인정보담당 : service@jjimggong.co.kr\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script type = \"text/javascript\" src  =\"/jyh/views/login.js\"></script>\r\n");
      out.write("<!-- 카카오로그인  -->\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.js\"></script>\r\n");
      out.write("<script type = \"text/javascript\">\r\n");
      out.write("Kakao.init('03e5c6119df4ebdf957a08df6af0c7b8'); // 카카오 javascript 인증키 \r\n");
      out.write("console.log(Kakao.isInitialized()); // sdk초기화여부판단\r\n");
      out.write("</script>\r\n");
      out.write("<!-- 네이버 로그인 sdk  -->\r\n");
      out.write("<script src=\"https://developers.kakao.com/sdk/js/kakao.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js\" charset=\"utf-8\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type = \"text/javascript\"> \r\n");
      out.write("\r\n");
      out.write("// 네이버 로그인 부분 \r\n");
      out.write("var naver_id_login = new naver_id_login(\"b06toaGrqKSfcX7fTe6V\", \"http://localhost:7008/jyh/views/naverCallback.jsp\");\r\n");
      out.write("  	var state = naver_id_login.getUniqState();\r\n");
      out.write("  	naver_id_login.setButton(\"white\", 2,40);\r\n");
      out.write("  	naver_id_login.setDomain(\"http://localhost:7008/jyh/views/login.jsp\");\r\n");
      out.write("  	naver_id_login.setState(state);\r\n");
      out.write("  	naver_id_login.setPopup();\r\n");
      out.write("  	naver_id_login.init_naver_id_login();\r\n");
      out.write("  	\r\n");
      out.write("  	\r\n");
      out.write(" //부모창에 있어야함. 	\r\n");
      out.write("  	function nloginform(naverEmail){\r\n");
      out.write("  		var frm = document.createElement('form');\r\n");
      out.write("  		frm.setAttribute('method', 'post');\r\n");
      out.write("  		frm.setAttribute('action', '/makeSession');\r\n");
      out.write("  		var hiddenInput = document.createElement('input');\r\n");
      out.write("  		hiddenInput.setAttribute('type','hidden');\r\n");
      out.write("  		hiddenInput.setAttribute('name','email');\r\n");
      out.write("  		hiddenInput.setAttribute('value',naverEmail);\r\n");
      out.write("  		frm.appendChild(hiddenInput);\r\n");
      out.write("  		document.body.appendChild(frm);\r\n");
      out.write("  		frm.submit();\r\n");
      out.write("  	}\r\n");
      out.write("\r\n");
      out.write("  	function createHiddenform(naverId,email,nik){	\r\n");
      out.write("  		var fm = document.createElement('form');\r\n");
      out.write("  		fm.setAttribute('method','post');\r\n");
      out.write("  		fm.setAttribute('action','/naverController');\r\n");
      out.write("  		var hInput = document.createElement('input');\r\n");
      out.write("  		hInput.setAttribute('type','hidden');\r\n");
      out.write("  		hInput.setAttribute('name','id');\r\n");
      out.write("  		hInput.setAttribute('value',naverId);\r\n");
      out.write("  		fm.appendChild(hInput);\r\n");
      out.write("  		var hInput1 = document.createElement('input');\r\n");
      out.write("  		hInput1.setAttribute('type','hidden');\r\n");
      out.write("  		hInput1.setAttribute('name','email');\r\n");
      out.write("  		hInput1.setAttribute('value',email);\r\n");
      out.write("  		fm.appendChild(hInput1)\r\n");
      out.write("  		var hInput2 = document.createElement('input');\r\n");
      out.write("  		hInput2.setAttribute('type','hidden');\r\n");
      out.write("  		hInput2.setAttribute('name','nik');\r\n");
      out.write("  		hInput2.setAttribute('value',nik);\r\n");
      out.write("  		fm.appendChild(hInput2);\r\n");
      out.write("  		document.body.appendChild(fm);\r\n");
      out.write("  		fm.submit();\r\n");
      out.write("  	}\r\n");
      out.write("</script>\r\n");
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
