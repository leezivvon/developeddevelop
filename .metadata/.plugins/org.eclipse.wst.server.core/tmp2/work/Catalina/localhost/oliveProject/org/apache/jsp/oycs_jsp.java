/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-02-01 12:17:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class oycs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1671429261036L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/oliveProject/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/C:/a01_javaexp/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/oliveProject/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
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
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("     \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    ");
      if (_jspx_meth_fmt_005frequestEncoding_005f1(_jspx_page_context))
        return;
      out.write("     \r\n");
      out.write("    <title>????????????</title>\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("    <meta content=\"Free HTML Templates\" name=\"keywords\">\r\n");
      out.write("    <meta content=\"Free HTML Templates\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link href=\"img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Google Web Fonts -->\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\"> \r\n");
      out.write("\r\n");
      out.write("    <!-- Font Awesome -->\r\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Libraries Stylesheet -->\r\n");
      out.write("    <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <!-- Topbar Start -->\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"row align-items-center py-3 px-xl-5\">\r\n");
      out.write("            <div class=\"col-lg-4 d-none d-lg-block\">\r\n");
      out.write("                <a href=\"oyMain.jsp\" class=\"text-decoration-none\">\r\n");
      out.write("                  ???<img style=\"width:80%\" src=\"img/main.png\">\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-5 col-8 text-left\">\r\n");
      out.write("                <form action=\"\">\r\n");
      out.write("                    <div class=\"input-group\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search for products\">\r\n");
      out.write("                        <div class=\"input-group-append\">\r\n");
      out.write("                            <span class=\"input-group-text bg-transparent text-primary\">\r\n");
      out.write("                                <i class=\"fa fa-search\"></i>\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-left:150px;\" class=\"col-lg-4 col-4\">\r\n");
      out.write("               <a class=\"text-dark\" href=\"oyJoin.jsp\">????????????</a>\r\n");
      out.write("               <span class=\"text-muted px-2\">|</span>\r\n");
      out.write("               <a class=\"text-dark\" href=\"oyLogin.jsp\">?????????</a>\r\n");
      out.write("               <span class=\"text-muted px-2\">|</span>\r\n");
      out.write("               <a class=\"text-dark\" href=\"oyCs.jsp\">????????????</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Topbar End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Navbar Start -->\r\n");
      out.write("    <div style=\"margin-top:30px\" class=\"container-fluid\">\r\n");
      out.write("        <div class=\"row border-top px-xl-5\">\r\n");
      out.write("            <div class=\"col-lg-3 d-none d-lg-block\">\r\n");
      out.write("                <a class=\"btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100\" data-toggle=\"collapse\" href=\"#navbar-vertical\" style=\"height: 65px; margin-top: -1px; padding: 0 30px;\">\r\n");
      out.write("                    <h6 class=\"m-0\"><b>????????????</b></h6>\r\n");
      out.write("                    <i class=\"fa fa-angle-down text-dark\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <nav class=\"collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light\" id=\"navbar-vertical\" style=\"width: calc(100% - 30px); z-index: 1;\">\r\n");
      out.write("                    <div class=\"navbar-nav w-100 overflow-hidden\" style=\"height: 410px\">\r\n");
      out.write("                        <div class=\"nav-item dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-link\" data-toggle=\"dropdown\">??????????????? <i class=\"fa fa-angle-down float-right mt-1\"></i></a>\r\n");
      out.write("                            <div class=\"dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0\">\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">????????????</a>\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">????????????</a>\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">?????????</a>\r\n");
      out.write("                                <a href=\"#\" class=\"dropdown-item\">?????????</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-item nav-link\">??????????????????</a>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-item nav-link\">????????????/??????</a>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-item nav-link\">????????????</a>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-item nav-link\">????????????</a>\r\n");
      out.write("                        <a href=\"#\" class=\"nav-item nav-link\">??????/?????????</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("                <div class=\"col-lg-9\">\r\n");
      out.write("                <nav class=\"navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0\">\r\n");
      out.write("                    <a href=\"#\" class=\"text-decoration-none d-block d-lg-none\">\r\n");
      out.write("                        <h1 class=\"m-0 display-5 font-weight-semi-bold\"><span class=\"text-primary font-weight-bold border px-3 mr-1\">E</span>Shopper</h1>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#navbarCollapse\">\r\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\r\n");
      out.write("                        <div class=\"navbar-nav mr-auto py-0\">\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>??????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>??????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>??????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>???????????????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>?????????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>??????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>???????????????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>?????????/??????</b></a>\r\n");
      out.write("                            <a href=\"#\" class=\"nav-item nav-link\"><b>?????????</b></a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("     </div>\r\n");
      out.write("    <!-- Navbar End -->\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#container{\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("#csTitle{\r\n");
      out.write("	width: 100%;\r\n");
      out.write("    background: #faeee1;\r\n");
      out.write("    height: 100px;\r\n");
      out.write("    display: inline-flex;\r\n");
      out.write("}\r\n");
      out.write("#csTitle h1{\r\n");
      out.write("	\r\n");
      out.write("}\r\n");
      out.write("#csTitle span{\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#csbody{\r\n");
      out.write("	padding:0 15px 0 15px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("   <!-- Board Start -->\r\n");
      out.write("  <div id=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <div id=\"csTitle\">\r\n");
      out.write("    	<h1>????????????</h1>\r\n");
      out.write("    	<span>????????? ??????????????????</span>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("  <div id=csbody>\r\n");
      out.write("    <div id=\"cslist\">\r\n");
      out.write("    	<ul>\r\n");
      out.write("    		<li id=\"faq\">FAQ??????</li>\r\n");
      out.write("    		<li id=\"oneone\">1:1??????</li>\r\n");
      out.write("    		<li id=\"announce\">????????????</li>\r\n");
      out.write("    	</ul>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"ancList\">\r\n");
      out.write("    	<ul>\r\n");
      out.write("    		<li id=\"ancL01\">??????</li>\r\n");
      out.write("    		<li id=\"ancL02\">??????</li>\r\n");
      out.write("    		<li id=\"ancL03\">??????</li>\r\n");
      out.write("    		<li id=\"ancL04\">?????????</li>\r\n");
      out.write("    	</ul>\r\n");
      out.write("    </div>   \r\n");
      out.write("    \r\n");
      out.write("    <div class=\"wrap divs\">\r\n");
      out.write("    	<div>\r\n");
      out.write("    		<p class=\"articlesHeader\">\r\n");
      out.write("    			<span>??????</span>\r\n");
      out.write("    			<span>??????</span>\r\n");
      out.write("    			<span>??????/??????????????????</span>\r\n");
      out.write("    		</p>\r\n");
      out.write("    	</div>\r\n");
      out.write("    	\r\n");
      out.write("    	<div>\r\n");
      out.write("    		<p class=\"article\">\r\n");
      out.write("    			<span class=\"no\">3</span>\r\n");
      out.write("    			<span class=\"icon\">??????</span>\r\n");
      out.write("    			<span class=\"title\">???????????? ????????? ???????????? ?????? ??????????????????</span>\r\n");
      out.write("    			<span class=\"date\">2023.01.30</span>\r\n");
      out.write("    		</p>\r\n");
      out.write("    	</div>\r\n");
      out.write("    	<div>\r\n");
      out.write("    		<p class=\"article\">\r\n");
      out.write("    			<span class=\"no\">2</span>\r\n");
      out.write("    			<span class=\"icon\">?????????</span>\r\n");
      out.write("    			<span class=\"title\">[??????-??????]????????? ????????? ??????</span>\r\n");
      out.write("    			<span class=\"date\">2022.12.25</span>\r\n");
      out.write("    		</p>\r\n");
      out.write("    	</div>\r\n");
      out.write("    	<div>\r\n");
      out.write("    		<p class=\"article\">\r\n");
      out.write("    			<span class=\"no\">1</span>\r\n");
      out.write("    			<span class=\"icon\">??????</span>\r\n");
      out.write("    			<span class=\"title\">[??????]???????????? ???????????? ?????? ?????? </span>\r\n");
      out.write("    			<span class=\"date\">2022.12.22</span>\r\n");
      out.write("    		</p>\r\n");
      out.write("    	</div>\r\n");
      out.write("    	\r\n");
      out.write("    	<div>??????????????? ???</div>\r\n");
      out.write("    	</div>\r\n");
      out.write("   \r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("   <!-- Board End -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Footer Start -->\r\n");
      out.write("    <div class=\"container-fluid bg-secondary text-dark mt-5 pt-5\">\r\n");
      out.write("        <div class=\"row px-xl-5 pt-5\">\r\n");
      out.write("            <div class=\"col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5\">\r\n");
      out.write("                <a href=\"#\" class=\"text-decoration-none\">\r\n");
      out.write("                    <h1 class=\"mb-4 display-5 font-weight-semi-bold\">\r\n");
      out.write("                    <img src=\"img/foot_logo.png\"></h1>\r\n");
      out.write("                </a>\r\n");
      out.write("          \r\n");
      out.write("                <p class=\"mb-2\">????????????</p>\r\n");
      out.write("                <p class=\"mb-2\">????????????????????????</p>\r\n");
      out.write("                <p class=\"mb-2\">???????????? ????????????</p>\r\n");
      out.write("                <h1 class=\"mb-4 display-5 font-weight-semi-bold\">\r\n");
      out.write("                <p class=\"mb-4\">\r\n");
      out.write("                    <span class=\"text-primary font-weight-bold border px-3 mr-1\">1522-0882</span></p></h1>\r\n");
      out.write("                <p class=\"mb-2\">?????? ????????????</p>\r\n");
      out.write("                <h1 class=\"mb-4 display-5 font-weight-semi-bold\">\r\n");
      out.write("                <p class=\"mb-4\">\r\n");
      out.write("                    <span class=\"text-primary font-weight-bold border px-3 mr-1\">1577-4887</span></p></h1>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-lg-8 col-md-12\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                        <h5 class=\"font-weight-bold text-dark mb-4\">???????????? ??????<br>[??????09:00-18:00]</h5>\r\n");
      out.write("                        <div class=\"d-flex flex-column justify-content-start\">\r\n");
      out.write("                            <a class=\"text-dark mb-2\" href=\"#\">?????? ??? ????????????<br> 1:1??????????????? ??????????????????</a>\r\n");
      out.write("                            <a class=\"text-dark mb-2\" href=\"#\">????????? ???????????? ?????? ?????????????????????.</a>\r\n");
      out.write("                            <button class=\"footbtn\">1:1????????????</button>\r\n");
      out.write("                           <button class=\"footbtn\">???????????? ??????</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                        <h5 class=\"font-weight-bold text-dark mb-4\"></h5>\r\n");
      out.write("                        <div class=\"d-flex flex-column justify-content-start\">\r\n");
      out.write("                            <a class=\"text-dark mb-2\" href=\"#\"></a>\r\n");
      out.write("                            <a class=\"text-dark mb-2\" href=\"#\"></a>\r\n");
      out.write("   \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-4 mb-5\">\r\n");
      out.write("                        <h5 class=\"font-weight-bold text-dark mb-4\">???????????? ????????????</h5>\r\n");
      out.write("                      <img src=\"img/qr.png\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"row border-top border-light mx-xl-5 py-4\">\r\n");
      out.write("            <div class=\"col-md-6 px-xl-0\">\r\n");
      out.write("                <p class=\"mb-md-0 text-center text-md-left text-dark\">\r\n");
      out.write("                    &copy; <a class=\"text-dark font-weight-semi-bold\" href=\"#\">????????????????????? ????????????</a>. \r\n");
      out.write("???????????? : ????????? | ????????????????????? : 809-81-01574\r\n");
      out.write("?????? : (04323) ??????????????? ????????? ???????????? 372, 24???\r\n");
      out.write("(?????????, KDB??????)\r\n");
      out.write("?????????????????? : CJ ?????????????????????\r\n");
      out.write("??????????????????????????? : 2019-????????????-1428\r\n");
      out.write("                </p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-6 px-xl-0 text-center text-md-right\">\r\n");
      out.write("                <img class=\"img-fluid\" src=\"img/payments.png\" alt=\"\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Footer End -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Back to Top -->\r\n");
      out.write("    <a href=\"#\" class=\"btn btn-primary back-to-top\"><i class=\"fa fa-angle-double-up\"></i></a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- JavaScript Libraries -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\r\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Contact Javascript File -->\r\n");
      out.write("    <script src=\"mail/jqBootstrapValidation.min.js\"></script>\r\n");
      out.write("    <script src=\"mail/contact.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Template Javascript -->\r\n");
      out.write("    <script src=\"js/main.js\"></script>\r\n");
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

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /oycs.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /oycs.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/oycs.jsp(7,0) '${pageContext.request.contextPath }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
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
      // /oycs.jsp(8,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("utf-8");
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

  private boolean _jspx_meth_fmt_005frequestEncoding_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:requestEncoding
    org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag _jspx_th_fmt_005frequestEncoding_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag) _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag.class);
    boolean _jspx_th_fmt_005frequestEncoding_005f1_reused = false;
    try {
      _jspx_th_fmt_005frequestEncoding_005f1.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005frequestEncoding_005f1.setParent(null);
      // /oycs.jsp(14,4) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f1.setValue("utf-8");
      int _jspx_eval_fmt_005frequestEncoding_005f1 = _jspx_th_fmt_005frequestEncoding_005f1.doStartTag();
      if (_jspx_th_fmt_005frequestEncoding_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005frequestEncoding_005f1);
      _jspx_th_fmt_005frequestEncoding_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005frequestEncoding_005f1, _jsp_getInstanceManager(), _jspx_th_fmt_005frequestEncoding_005f1_reused);
    }
    return false;
  }
}
