/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-05 13:14:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ymw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import ymw.*;
import jyh.model.*;
import hds.*;
import hjw.*;
import ljw.*;

public final class pg0001_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("hjw");
    _jspx_imports_packages.add("hds");
    _jspx_imports_packages.add("ljw");
    _jspx_imports_packages.add("jyh.model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.release();
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
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("utf-8");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>??????</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/index_markup/reset.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    /* ?????? */\r\n");
      out.write("    .content{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 500px;\r\n");
      out.write("        padding: 0px 10px;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("    }\r\n");
      out.write("    .sch{\r\n");
      out.write("    		padding-top:20px;\r\n");
      out.write("    		display:flex;\r\n");
      out.write("    	}\r\n");
      out.write("   	.schBtn>button{\r\n");
      out.write("  		width: 40px;\r\n");
      out.write("	    height: 40px;\r\n");
      out.write("	    border: 1px solid gray;\r\n");
      out.write("	    border-radius: 6px 0px 0px 6px;\r\n");
      out.write("	    cursor:pointer;\r\n");
      out.write("   	}\r\n");
      out.write("   	.schInp{\r\n");
      out.write("   		width: 100%;\r\n");
      out.write("	    height: 40px;\r\n");
      out.write("	    margin-left: -1px;\r\n");
      out.write("	    border: 1px gray solid;\r\n");
      out.write("	    border-radius: 0px 6px 6px 0px;\r\n");
      out.write("	    background: white;\r\n");
      out.write("   	}\r\n");
      out.write("   	.schInp>input{\r\n");
      out.write("   		padding: 0px 10px;\r\n");
      out.write("	    width: 93%;\r\n");
      out.write("	    height: 100%;\r\n");
      out.write("	    border: none;\r\n");
      out.write("   	}\r\n");
      out.write("   	h3{\r\n");
      out.write("   		padding : 15px 0px;\r\n");
      out.write("   	}\r\n");
      out.write("   	.recKeyword{\r\n");
      out.write("   		display:flex;\r\n");
      out.write("   		justify-content: flex-start;\r\n");
      out.write("   		gap: 10px;\r\n");
      out.write("   	}\r\n");
      out.write("   	.recKeyword>li{\r\n");
      out.write("   		border: 2px solid #601986;\r\n");
      out.write("   		background:white;\r\n");
      out.write("   		padding: 5px;\r\n");
      out.write("   		border-radius: 10px;\r\n");
      out.write("   		cursor:pointer;\r\n");
      out.write("   	}\r\n");
      out.write("   	.popSch>li{\r\n");
      out.write("   		padding: 0px 0px 7px 25px;\r\n");
      out.write("   		cursor:pointer;\r\n");
      out.write("   	}\r\n");
      out.write("   	.schInp>button{\r\n");
      out.write("   		background-color: black;\r\n");
      out.write("	    color: white;\r\n");
      out.write("	    padding: 3px;\r\n");
      out.write("	    border-radius: 9px;\r\n");
      out.write("	    text-align: center;\r\n");
      out.write("	    cursor:pointer;\r\n");
      out.write("   	}\r\n");
      out.write("   	input[type=text]:focus{\r\n");
      out.write("   		outline:none;\r\n");
      out.write("   	}\r\n");
      out.write("   	#sch2{\r\n");
      out.write("		display: none;\r\n");
      out.write("	}\r\n");
      out.write("	.recSch>ul{\r\n");
      out.write("		display: flex;\r\n");
      out.write("	    flex-wrap: nowrap;\r\n");
      out.write("	    flex-direction: column;\r\n");
      out.write("	    gap: 20px;\r\n");
      out.write("	    padding-left: 10px;\r\n");
      out.write("	    padding-top: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	.recSch>ul li{\r\n");
      out.write("		cursor:pointer;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("	");

		memberDTO loginUser = (memberDTO)session.getAttribute("sesID");
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    ");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    <section>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("        	<div id=\"sch1\">\r\n");
      out.write("        		<div class=\"sch\">\r\n");
      out.write("	        		<div class=\"schBtn\">\r\n");
      out.write("	        			<button type=\"button\" onclick=\"schBtn()\">??????</button>\r\n");
      out.write("	        		</div>\r\n");
      out.write("	        		<div class=\"schInp\">\r\n");
      out.write("	        			<input name=\"schContent1\" type=\"text\" placeholder=\"????????? ??????????????????.\" onfocus=\"schFocus()\">\r\n");
      out.write("	        		</div>\r\n");
      out.write("	        	</div>\r\n");
      out.write("	        	<h3>?????? ?????????</h3>\r\n");
      out.write("	        	<div>\r\n");
      out.write("	        		<div>\r\n");
      out.write("	        			<ul class=\"recKeyword\">\r\n");
      out.write("	        			</ul>\r\n");
      out.write("	        		</div>\r\n");
      out.write("	        	</div>\r\n");
      out.write("	        	<h3>?????? ?????????</h3>\r\n");
      out.write("	        		<div>\r\n");
      out.write("	        			<ul class=\"popSch\">\r\n");
      out.write("		        			");
      ymw.dao.Sch schDao = null;
      schDao = (ymw.dao.Sch) _jspx_page_context.getAttribute("schDao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (schDao == null){
        schDao = new ymw.dao.Sch();
        _jspx_page_context.setAttribute("schDao", schDao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("		        			");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("	        			</ul>\r\n");
      out.write("	        		</div>\r\n");
      out.write("        	</div>\r\n");
      out.write("        	<div id=sch2>\r\n");
      out.write("        		<div class=\"sch\">\r\n");
      out.write("	        		<div class=\"schBtn\">\r\n");
      out.write("	        			<button type=\"button\" onclick=\"backBtn()\">??????</button>\r\n");
      out.write("	        		</div>\r\n");
      out.write("	        		<div class=\"schInp\">\r\n");
      out.write("	        			<input name=\"schContent2\" type=\"text\" placeholder=\"????????? ??????????????????.\">\r\n");
      out.write("	        			<button id=\"delBtn\" type=\"button\" onclick=\"delBtn()\">X</button>\r\n");
      out.write("	        		</div>\r\n");
      out.write("	        	</div>\r\n");
      out.write("	        	<h3>?????? ?????????</h3>\r\n");
      out.write("	        	");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("			    ");
      if (_jspx_meth_c_005fif_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        	</div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <footer>\r\n");
      out.write("        <nav class=\"footer_nav\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"#\">????????? ????????????</a></li>\r\n");
      out.write("                <li><a href=\"#\">???????????? ????????????</a></li>\r\n");
      out.write("                <li><a href=\"#\">?????? ??????</a></li>\r\n");
      out.write("                <li><a href=\"#\">?????? ??????</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <p class=\"jjim_info\">\r\n");
      out.write("            (???) ??????<br>\r\n");
      out.write("            ?????? : ?????????<br>\r\n");
      out.write("            ?????? : ??????????????? ????????? ??????????????? 21 2??? ????????????<br>\r\n");
      out.write("            ????????????????????? : 202212142126<br>\r\n");
      out.write("            ?????????????????? : service@jjimggong.co.kr\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	var recSchs = document.querySelectorAll(\".recSch>ul>li\")\r\n");
      out.write("	recSchs.forEach(function(recSch){\r\n");
      out.write("		recSch.onclick = function(){\r\n");
      out.write("			location.href=\"/ymw/pg0011.jsp?sch=\"+recSch.innerText+\"&appKind=??????&arrKind=???????????????\"\r\n");
      out.write("		}\r\n");
      out.write("	})\r\n");
      out.write("	var schInpOb1 = document.querySelector(\"[name=schContent1]\")\r\n");
      out.write("	var schInpOb2 = document.querySelector(\"[name=schContent2]\")\r\n");
      out.write("	var backBtnOb = document.querySelector(\"#backBtn\")\r\n");
      out.write("	var sch1 = document.querySelector(\"#sch1\")\r\n");
      out.write("	var sch2 = document.querySelector(\"#sch2\")\r\n");
      out.write("	\r\n");
      out.write("	var popSchs = document.querySelectorAll(\".popSch>li\")\r\n");
      out.write("	var recKeyword = document.querySelector(\".recKeyword\")\r\n");
      out.write("	\r\n");
      out.write("	var rKey = [\"??????\", \"?????????\", \"????????????\", \"?????????\", \"??????\", \"??????\", \"??????\", \"??????\", \"??????\", \"??????\"]\r\n");
      out.write("	var ranNums = [];\r\n");
      out.write("	for (i = 1; i <= 5; i += 1) {\r\n");
      out.write("	  var ranNum = Math.floor(Math.random() * rKey.length);\r\n");
      out.write("	  if (ranNums.indexOf(ranNum) === -1) {\r\n");
      out.write("		  ranNums.push(ranNum);\r\n");
      out.write("	  } else {\r\n");
      out.write("	    i--\r\n");
      out.write("	  }\r\n");
      out.write("	}\r\n");
      out.write("	ranNums.forEach(function(num){\r\n");
      out.write("		recKeyword.innerHTML += \"<li>\"+rKey[num]+\"</li>\"\r\n");
      out.write("	})\r\n");
      out.write("	var recKeywords = document.querySelectorAll(\".recKeyword>li\")\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	recKeywords.forEach(function(keyword){\r\n");
      out.write("		keyword.onclick = function(){\r\n");
      out.write("			location.href=\"/ymw/pg0011.jsp?sch=\"+keyword.innerText+\"&appKind=??????&arrKind=???????????????\"\r\n");
      out.write("		}\r\n");
      out.write("	})\r\n");
      out.write("	popSchs.forEach(function(pop){\r\n");
      out.write("		pop.onclick = function(){\r\n");
      out.write("			location.href=\"/ymw/pg0011.jsp?sch=\"+pop.innerText+\"&appKind=??????&arrKind=???????????????\"\r\n");
      out.write("		}\r\n");
      out.write("	})\r\n");
      out.write("	function schFocus(){\r\n");
      out.write("		schInpOb1.focus()\r\n");
      out.write("		sch1.style.display = \"none\";\r\n");
      out.write("		sch2.style.display = \"block\";\r\n");
      out.write("		schInpOb2.focus()\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	function schBtn(){\r\n");
      out.write("		schFocus()\r\n");
      out.write("	}\r\n");
      out.write("	function backBtn(){\r\n");
      out.write("		schInpOb2.value = \"\";\r\n");
      out.write("		sch1.style.display = \"block\";\r\n");
      out.write("		sch2.style.display = \"none\";\r\n");
      out.write("	}\r\n");
      out.write("	function delBtn(){\r\n");
      out.write("		schInpOb2.value = \"\"\r\n");
      out.write("		schInpOb2.focus()\r\n");
      out.write("	}\r\n");
      out.write("	schInpOb2.onkeyup = function(){\r\n");
      out.write("		if(event.keyCode==13){\r\n");
      out.write("			if(schInpOb2.value==\"\"){\r\n");
      out.write("				alert(\"???????????? ??????????????????.\")\r\n");
      out.write("				schInpOb2.focus()\r\n");
      out.write("			}\r\n");
      out.write("			else{\r\n");
      out.write("				location.href=\"./pg0011.jsp?sch=\"+schInpOb2.value+\"&appKind=??????&arrKind=???????????????\"\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
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
      // /ymw/pg0001.jsp(112,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sesID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("       <header class=\"head1\">\r\n");
          out.write("           <h1 class=\"logo\"><a href=\"/ljw/pg0000.jsp\"><img src=\"/index_markup/img/main_logo.png\" alt=\"\"></a></h1>\r\n");
          out.write("            <nav class=\"gnb\">\r\n");
          out.write("               <ul>\r\n");
          out.write("                   <li><a href=\"/jyh/views/login.jsp\">?????????</a></li>\r\n");
          out.write("                   <li><a href=\"/jyh/views/insertMember.jsp\">????????????</a></li>\r\n");
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
      // /ymw/pg0001.jsp(123,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /ymw/pg0001.jsp(155,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("pop");
      // /ymw/pg0001.jsp(155,13) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/ymw/pg0001.jsp(155,13) '${schDao.pop()}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${schDao.pop()}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("		        				<li>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pop.sch }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</li>\r\n");
            out.write("		        			");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /ymw/pg0001.jsp(172,10) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sesID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("			       <div>???????????? ?????? ???????????? ????????????.</div>\r\n");
          out.write("			    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f3_reused = false;
    try {
      _jspx_th_c_005fif_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f3.setParent(null);
      // /ymw/pg0001.jsp(175,7) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sesID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f3 = _jspx_th_c_005fif_005f3.doStartTag();
      if (_jspx_eval_c_005fif_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("			       <div class=\"recSch\">\r\n");
          out.write("			       		<ul>\r\n");
          out.write("			       			");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fif_005f3, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("			       		</ul>\r\n");
          out.write("			       </div>\r\n");
          out.write("			    ");
          int evalDoAfterBody = _jspx_th_c_005fif_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f3);
      _jspx_th_c_005fif_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f3, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f3_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f3, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f3);
      // /ymw/pg0001.jsp(178,13) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("recSch");
      // /ymw/pg0001.jsp(178,13) name = begin type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setBegin(0);
      // /ymw/pg0001.jsp(178,13) name = end type = int reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setEnd(4);
      // /ymw/pg0001.jsp(178,13) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/ymw/pg0001.jsp(178,13) '${schDao.recSch(sesID.email) }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${schDao.recSch(sesID.email) }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("			       				<li><span>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recSch }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</span></li>\r\n");
            out.write("			       			");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems_005fend_005fbegin.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
