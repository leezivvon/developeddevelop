/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-05 13:13:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.hds;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import jspexp.vo.*;
import jyh.model.*;
import hds.*;
import ymw.*;

public final class res_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("ymw");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("hds");
    _jspx_imports_packages.add("jyh.model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("jspexp.vo");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<title>즉시 예약</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/index_markup/reset.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    /* ㅇㅇ */\r\n");
      out.write("    .content{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    /* 지원 */   \r\n");
      out.write("	nav.searchmenu{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		background-color: #fff;\r\n");
      out.write("		display: block\r\n");
      out.write("	}\r\n");
      out.write("	.search {\r\n");
      out.write("		padding-top:20px;\r\n");
      out.write("		display:flex;\r\n");
      out.write("		width:60%;\r\n");
      out.write("		margin:0 auto; /* 가운데정렬 */\r\n");
      out.write("		justify-content: center; /* 가운데정렬 */\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	nav.searchmenu>.search>form>input[type=text]{\r\n");
      out.write("		background-color:#E1E5F2;\r\n");
      out.write("		height:40px;\r\n");
      out.write("		border-radius:12px 0px 0px 12px;\r\n");
      out.write("		border:none;\r\n");
      out.write("		display:block;\r\n");
      out.write("		padding-left:20px;\r\n");
      out.write("		width:300px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	nav.searchmenu>.search>form>input[placeholder]{\r\n");
      out.write("		color:#4C4C47;\r\n");
      out.write("		font-size:12px;\r\n");
      out.write("		font-weight:400;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu>.search>form>button{\r\n");
      out.write("		background-color:#E1E5F2;\r\n");
      out.write("		height:40px;\r\n");
      out.write("		width:40px;\r\n");
      out.write("		border:none;\r\n");
      out.write("		display:none;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu>.search>div>button{\r\n");
      out.write("		background-color:#E1E5F2;\r\n");
      out.write("		height:40px;\r\n");
      out.write("		width:40px;\r\n");
      out.write("		border-radius:0px 12px 12px 0px;\r\n");
      out.write("		border:none;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu>.search>div>button>img{\r\n");
      out.write("		height:20px;\r\n");
      out.write("		width:20px;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu>.menu{\r\n");
      out.write("		display:flex;\r\n");
      out.write("	    justify-content:center;\r\n");
      out.write("	    gap:60px;\r\n");
      out.write("	    padding-top:20px;\r\n");
      out.write("	    padding-bottom:20px;\r\n");
      out.write("	    font-size:18px;\r\n");
      out.write("	    font-weight:800;\r\n");
      out.write("	    color:#4C4C47;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu>.menu>li:hover{\r\n");
      out.write("		color:#601986;\r\n");
      out.write("	}\r\n");
      out.write("	#choice{\r\n");
      out.write("		color:#601986;\r\n");
      out.write("		font-weight:900;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("    .myloc{\r\n");
      out.write("    	display:flex;\r\n");
      out.write("	    justify-content:center;\r\n");
      out.write("	    background-color:#E1E5F2;\r\n");
      out.write("	    width:100%;\r\n");
      out.write("	    height:25px;\r\n");
      out.write("    }\r\n");
      out.write("    .myloc>input[type=\"text\"]{\r\n");
      out.write("	    background-color:#E1E5F2;\r\n");
      out.write("	    border:none;\r\n");
      out.write("	    margin:0px auto;\r\n");
      out.write("	    width:70%;\r\n");
      out.write("    }\r\n");
      out.write("    .myloc>input[placeholder]{\r\n");
      out.write("		color:#4C4C47;\r\n");
      out.write("		font-size:12px;\r\n");
      out.write("		font-weight:400;\r\n");
      out.write("		text-align:center;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	.storeInfo2{\r\n");
      out.write("		display:flex;\r\n");
      out.write("		padding:20px;\r\n");
      out.write("		flex-wrap:wrap;\r\n");
      out.write("		justify-content:space-between;\r\n");
      out.write("	}\r\n");
      out.write("	.storeInfo2>.storeInfoDiv2{\r\n");
      out.write("		width:200px;\r\n");
      out.write("		padding-bottom:20px;\r\n");
      out.write("	}\r\n");
      out.write("	.storeInfo2>.storeInfoDiv2>.storeImage{\r\n");
      out.write("		width:100%;\r\n");
      out.write("		height:100px;\r\n");
      out.write("		border-radius:5px;\r\n");
      out.write("		border:0.5px solid #4C4C47;\r\n");
      out.write("	}\r\n");
      out.write("	.storeInfo2>.storeInfoDiv2 img{\r\n");
      out.write("		display:block;\r\n");
      out.write("		height:98.5px;\r\n");
      out.write("		margin:0 auto;\r\n");
      out.write("	}\r\n");
      out.write("	.storeInfo2>.storeInfoDiv2>.storeDetail{\r\n");
      out.write("		color:#333;\r\n");
      out.write("		padding-top:5px;\r\n");
      out.write("		padding-left:3px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 상단 고정 */\r\n");
      out.write("	header{\r\n");
      out.write("		position:sticky;\r\n");
      out.write("		top:0;\r\n");
      out.write("		z-index:999;\r\n");
      out.write("	}\r\n");
      out.write("	nav.searchmenu{\r\n");
      out.write("		position:sticky;\r\n");
      out.write("		top:46px;\r\n");
      out.write("		z-index:999;\r\n");
      out.write("		background-color:#fff;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* select */\r\n");
      out.write("	select{\r\n");
      out.write("		-webkit-appearance: none;\r\n");
      out.write(" 		-moz-appearance: none;\r\n");
      out.write("		appearance: none;\r\n");
      out.write("	}\r\n");
      out.write("	/* IE에서 화살표 제거 */\r\n");
      out.write("	select::-ms-expand{\r\n");
      out.write("		display:none;\r\n");
      out.write("	}\r\n");
      out.write("	.array{\r\n");
      out.write("		display:flex;\r\n");
      out.write("		flex-flow:row-reverse;\r\n");
      out.write("		padding-top:10px;\r\n");
      out.write("		gap:10px;\r\n");
      out.write("	}\r\n");
      out.write("	.selectBox * { box-sizing:border-box; color:#333;}\r\n");
      out.write("	.selectBox{\r\n");
      out.write("		width: 180px;\r\n");
      out.write("		height: 32px;\r\n");
      out.write("		border-radius:16px;\r\n");
      out.write("		border:2px solid #601986;\r\n");
      out.write("		background: url('../index_markup/img/select_arrow.png') no-repeat 92% 50%;\r\n");
      out.write("		background-size:12px;\r\n");
      out.write("		margin-right:10px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		padding-right: 13px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	input:focus {outline: none};\r\n");
      out.write("	select:focus {outline: none};\r\n");
      out.write("    \r\n");
      out.write("    /*\r\n");
      out.write("    솜 css\r\n");
      out.write("    */\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

     memberDTO loginUser = (memberDTO)session.getAttribute("sesID");
  
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <section>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("        \r\n");
      out.write("        	<nav class=\"searchmenu\">\r\n");
      out.write("		    	<div class=\"search\" onclick=\"location.href='/ymw/pg0001.jsp'\"> <!-- .search onclick>>link -->\r\n");
      out.write("		    		<form>\r\n");
      out.write("		    			<input type=\"text\" placeholder=\"매장이름을 검색하세요\" >\r\n");
      out.write("		    			<button type=\"button\"></button>\r\n");
      out.write("		    		</form>	\r\n");
      out.write("		    		<div>\r\n");
      out.write("		    			<button type=\"button\"><img src=\"../index_markup/img/search_icon.png\" alt=\"\"></button>\r\n");
      out.write("		    		</div>\r\n");
      out.write("		    	</div>\r\n");
      out.write("		    	<ul class=\"menu\">\r\n");
      out.write("		    		<li id=\"choice\" onclick=\"location.href='/hds/res_index.jsp'\" >즉시예약</li>\r\n");
      out.write("		    		<li onclick=\"location.href='/ljw/pg3001.jsp'\">원격줄서기</li>\r\n");
      out.write("		    		<li onclick=\"location.href='/ljw/pg3005.jsp'\">주문현황</li>\r\n");
      out.write("		    	</ul>\r\n");
      out.write("		    </nav>\r\n");
      out.write("		    \r\n");
      out.write("	    	<div class=\"myloc\">\r\n");
      out.write("	    		<input type=\"text\" placeholder=\"현재 위치를 입력하세요\"/>\r\n");
      out.write("	    	</div>\r\n");
      out.write("	    	\r\n");
      out.write("	    	<div class=\"array\">\r\n");
      out.write("	    		<select class=\"selectBox\">\r\n");
      out.write("	    			<option class=\"option\">별점 높은 순</option>\r\n");
      out.write("	    			<option class=\"option\">리뷰 많은 순</option>\r\n");
      out.write("	    			<option class=\"option\">현재 위치와 가까운 순</option>  		\r\n");
      out.write("	    		</select>\r\n");
      out.write("	    	</div>\r\n");
      out.write("	    	\r\n");
      out.write("	    	<style>\r\n");
      out.write("	    	\r\n");
      out.write("	    		.res_info_wrapper{\r\n");
      out.write("	    			display: flex;\r\n");
      out.write("	    			flex-wrap: wrap;\r\n");
      out.write("	    			justify-content: space-evenly;\r\n");
      out.write("	    		}\r\n");
      out.write("	    	\r\n");
      out.write("	    		.res_info_box{\r\n");
      out.write("	    			width:200px;\r\n");
      out.write("	    			margin: 20px 0;\r\n");
      out.write("	    			padding-top: 20px;\r\n");
      out.write("	    			border: 1px solid #601986;\r\n");
      out.write("	    			border-radius: 10px;\r\n");
      out.write("	    		}\r\n");
      out.write("	    		\r\n");
      out.write("	    		.img_box{\r\n");
      out.write("	    			background-color: red;\r\n");
      out.write("	    			margin: auto;\r\n");
      out.write("	    			width: 120px;\r\n");
      out.write("				    height: 120px;\r\n");
      out.write("	    		}\r\n");
      out.write("	    		\r\n");
      out.write("	    		.text_box{\r\n");
      out.write("	    			margin: 20px 0;\r\n");
      out.write("			    	padding-left: 20px;\r\n");
      out.write("			    	font-family: inherit;\r\n");
      out.write("	    		}\r\n");
      out.write("	    		\r\n");
      out.write("	    		.info_title{\r\n");
      out.write("	    			font-size: 20px;\r\n");
      out.write("	    			font-weight: 600;\r\n");
      out.write("	    			cursor: pointer;\r\n");
      out.write("	    		}\r\n");
      out.write("	    	\r\n");
      out.write("	    	</style>\r\n");
      out.write("	    	\r\n");
      out.write("	    	<div class=\"res_info_wrapper\">\r\n");
      out.write("	    		<div class=\"res_info_box\">\r\n");
      out.write("	    			<div class=\"img_box\">\r\n");
      out.write("	    				<img alt=\"\" src=\"../index_markup/img/yeondon_img.png\">\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    			<div class=\"text_box\">\r\n");
      out.write("	    				<ul>\r\n");
      out.write("	    					<li class=\"info_title\" onclick=\"location.href='pg_1001.jsp?resnum=123-45-67890'\">연돈</li>\r\n");
      out.write("	    					<li>☆ 5.0</li>\r\n");
      out.write("	    					<li>일식</li>\r\n");
      out.write("	    					<li>용오로 84</li>\r\n");
      out.write("	    				</ul>\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    		</div>\r\n");
      out.write("	    		<div class=\"res_info_box\">\r\n");
      out.write("	    			<div class=\"img_box\">\r\n");
      out.write("	    				<img alt=\"\" src=\"../index_markup/img/dowon_img.png\">\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    			<div class=\"text_box\">\r\n");
      out.write("	    				<ul>\r\n");
      out.write("	    					<li class=\"info_title\" onclick=\"location.href='pg_1001.jsp?resnum=123-45-67894'\">도원</li>\r\n");
      out.write("	    					<li>☆ 4.8</li>\r\n");
      out.write("	    					<li>중식</li>\r\n");
      out.write("	    					<li>토금북로 30</li>\r\n");
      out.write("	    				</ul>\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    		</div>\r\n");
      out.write("	    		<div class=\"res_info_box\">\r\n");
      out.write("	    			<div class=\"img_box\">\r\n");
      out.write("	    				<img alt=\"\" src=\"../index_markup/img/heajang_img.png\">\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    			<div class=\"text_box\">\r\n");
      out.write("	    				<ul>\r\n");
      out.write("	    					<li class=\"info_title\" onclick=\"location.href='pg_1001.jsp?resnum=123-45-67893'\">은희네 해장국</li>\r\n");
      out.write("	    					<li>☆ 3.2</li>\r\n");
      out.write("	    					<li>한식</li>\r\n");
      out.write("	    					<li>토금북로 32</li>\r\n");
      out.write("	    				</ul>\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    		</div>\r\n");
      out.write("	    		<div class=\"res_info_box\">\r\n");
      out.write("	    			<div class=\"img_box\">\r\n");
      out.write("	    				<img alt=\"\" src=\"../index_markup/img/dong_img.png\">\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    			<div class=\"text_box\">\r\n");
      out.write("	    				<ul>\r\n");
      out.write("	    					<li class=\"info_title\" onclick=\"location.href='pg_1001.jsp?resnum=123-45-67891'\">동화가든</li>\r\n");
      out.write("	    					<li>☆ 5.0</li>\r\n");
      out.write("	    					<li>한식</li>\r\n");
      out.write("	    					<li>토금북로 22</li>\r\n");
      out.write("	    				</ul>\r\n");
      out.write("	    			</div>\r\n");
      out.write("	    		</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	    	</div>\r\n");
      out.write("        	\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    \r\n");
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
      out.write("\r\n");
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
      // /hds/res_index.jsp(11,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /hds/res_index.jsp(198,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sesID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("       <header class=\"head1\">\r\n");
          out.write("           <h1 class=\"logo\"><a href=\"/ljw/pg0000.jsp\"><img src=\"/index_markup/img/main_logo.png\" alt=\"\"></a></h1>\r\n");
          out.write("            <nav class=\"gnb\">\r\n");
          out.write("               <ul>\r\n");
          out.write("                   <li><a href=\"/jyh/views/login.jsp\">로그인</a></li>\r\n");
          out.write("                   <li><a href=\"/jyh/views/insertMember.jsp\">회원가입</a></li>\r\n");
          out.write("               </ul>\r\n");
          out.write("            </nav>\r\n");
          out.write("       </header>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /hds/res_index.jsp(209,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sesID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("       <header class=\"head2\">\r\n");
          out.write("        <h1 class=\"logo\"><a href=\"/ljw/pg0000.jsp\"><img src=\"/index_markup/img/main_logo.png\" alt=\"\"></a></h1>\r\n");
          out.write("         <nav class=\"gnb\">\r\n");
          out.write("            <ul>\r\n");
          out.write("                <li><a href=\"/myInfoController\"><img src=\"/index_markup/img/myPageImg.png\" alt=\"\"></a></li>\r\n");
          out.write("            </ul>\r\n");
          out.write("         </nav>\r\n");
          out.write("    </header>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}
