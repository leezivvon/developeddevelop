/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-05 09:16:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hds;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ymw.*;
import jyh.model.*;
import hds.*;
import hjw.*;
import ljw.*;

public final class pg_005f1007_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/ZzimGgong/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1671429261036L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/ZzimGgong/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("ymw");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("hjw");
    _jspx_imports_packages.add("hds");
    _jspx_imports_packages.add("ljw");
    _jspx_imports_packages.add("jyh.model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
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
      out.write("    \r\n");
      out.write("\r\n");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>예약 신청 내역(가게)</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/index_markup/reset.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	    .content{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        padding: 50px 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content h3{\r\n");
      out.write("        font-weight: 600;\r\n");
      out.write("        font-size: 30px;\r\n");
      out.write("        line-height: 18px;\r\n");
      out.write("        color: #601986;\r\n");
      out.write("        line-height: 30px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("        padding-bottom: 50px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content p{\r\n");
      out.write("        color: #601986;\r\n");
      out.write("        font-weight: 400;\r\n");
      out.write("        font-size: 16px;\r\n");
      out.write("        line-height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .info_wrap{\r\n");
      out.write("	    line-height: 30px;\r\n");
      out.write("	    color: #601986;\r\n");
      out.write("	    width: 480px;\r\n");
      out.write("	    margin: auto;\r\n");
      out.write("	    padding-left: 20px;\r\n");
      out.write("}\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .info_wrap img{\r\n");
      out.write("        padding-right: 14px;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .info_wrap li{\r\n");
      out.write("    	color: #333;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    .info_wrap h2{\r\n");
      out.write("    	font-size: 20px;\r\n");
      out.write("    	line-height: 30px;\r\n");
      out.write("    }\r\n");
      out.write("	\r\n");
      out.write("	.content button {\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("	    border-radius: 5px;\r\n");
      out.write("	    border: none;\r\n");
      out.write("	    color: #fff;\r\n");
      out.write("	    background-color: #601986;\r\n");
      out.write("	    font-size: 15px;\r\n");
      out.write("	    font-weight: 600;\r\n");
      out.write("	    display: block;\r\n");
      out.write("	    margin: 10px auto 50px;\r\n");
      out.write("	    cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("}\r\n");
      out.write("	\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      hds.reservation_Dao dao = null;
      dao = (hds.reservation_Dao) _jspx_page_context.getAttribute("dao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dao == null){
        dao = new hds.reservation_Dao();
        _jspx_page_context.setAttribute("dao", dao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

	String user_email = "";
	String resNum = "123-45-67890";

      out.write(" \r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("      <header>\r\n");
      out.write("         <h1 class=\"logo\"><img src=\"/index_markup/img/main_logo.png\" alt=\"\"></h1>\r\n");
      out.write("         <nav class=\"gnb\">\r\n");
      out.write("            <ul>\r\n");
      out.write("               <li><a href=\"#\"><img src=\"/index_markup/img/myPageImg.png\" alt=\"\"></a></li>\r\n");
      out.write("               <li><button onclick=\"logout()\">종료</button></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("         </nav>\r\n");
      out.write("      </header>\r\n");
      out.write("    <section>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <h3>예약 내역 확인하기</h3>\r\n");

for(Reservation r : dao.showResList(user_email, resNum)) {
	String state="";
	if(r.getReserve_state()==1){
		state="신청 완료된 ";
	}

      out.write("\r\n");
      out.write("            <div class=\"info_wrap\">\r\n");
      out.write("            	<div class=\"res_info_box\">\r\n");
      out.write("	            	<h2>");
      out.print(r.getNickName() );
      out.write("님 예약 정보</h2>\r\n");
      out.write("	            	<ul>\r\n");
      out.write("	            		<li>예약인원 : ");
      out.print(r.getReserve_apply_person() );
      out.write("명</li>\r\n");
      out.write("	            		<li>방문일시 : ");
      out.print(r.getReserve_start_time() );
      out.write("</li>\r\n");
      out.write("	            	</ul>\r\n");
      out.write("            	</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <button onclick=\"location.href='pg_1003.jsp?user_email=");
      out.print(r.getUser_email());
      out.write("&reserve_start_time=");
      out.print(r.getReserve_start_time());
      out.write("&nickName=");
      out.print( r.getNickName());
      out.write("&phoneNum=");
      out.print(r.getPhoneNum());
      out.write("'\">\r\n");
      out.write("	            ");
      out.print(r.getNickName() );
      out.write("님의 예약 승인/거절\r\n");
      out.write("            </button>\r\n");
} 
      out.write("\r\n");
      out.write("        </div>\r\n");
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
      out.write("<script>\r\n");
      out.write("/*\r\n");
      out.write("\r\n");
      out.write(" */\r\n");
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

  private boolean _jspx_meth_fmt_005frequestEncoding_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:requestEncoding
    org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag _jspx_th_fmt_005frequestEncoding_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag) _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag.class);
    boolean _jspx_th_fmt_005frequestEncoding_005f0_reused = false;
    try {
      _jspx_th_fmt_005frequestEncoding_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005frequestEncoding_005f0.setParent(null);
      // /hds/pg_1007.jsp(11,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("UTF-8");
      int _jspx_eval_fmt_005frequestEncoding_005f0 = _jspx_th_fmt_005frequestEncoding_005f0.doStartTag();
      if (_jspx_th_fmt_005frequestEncoding_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005frequestEncoding_005f0);
      _jspx_th_fmt_005frequestEncoding_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005frequestEncoding_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005frequestEncoding_005f0_reused);
    }
    return false;
  }
}
