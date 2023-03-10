/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-05 13:29:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jyh.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jyh.model.reviewDAO;
import jyh.model.reviewDTO;
import jyh.model.memberDTO;
import java.util.*;

public final class reviewList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("jyh.model.reviewDAO");
    _jspx_imports_classes.add("jyh.model.reviewDTO");
    _jspx_imports_classes.add("jyh.model.memberDTO");
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

      out.write('\r');
      out.write('\n');

	int pageSize = 3; // 한 페이지에 출력할 레코드 수
	
	memberDTO loginUser = (memberDTO)session.getAttribute("sesID");
	String email = loginUser.getEmail();
	// 페이지 링크를 클릭한 번호 / 현재 페이지
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null){ // 클릭한게 없으면 1번 페이지
		pageNum = "1";
	}
	// 연산을 하기 위한 pageNum 형변환 / 현재 페이지
	int currentPage = Integer.parseInt(pageNum);

	// 해당 페이지에서 시작할 레코드 / 마지막 레코드
	int count = 0;
	reviewDAO manage = new reviewDAO();
	count = manage.selectCount(email); // 데이터베이스에 저장된 총 갯수
	
		// getList()메서드 호출 / 해당 레코드 반환
	ArrayList<reviewDTO> list = manage.reviewView(email,currentPage);
	

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>찜꽁</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/jyh/views/reviewList.css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("    /* ㅇㅇ */\r\n");
      out.write("    .content{\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 500px;\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("    }  \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <header>\r\n");
      out.write("        <h1 class=\"logo\">\r\n");
      out.write("        <a href = \"/ljw/pg0000.jsp\"><img src=\"/index_markup/img/main_logo.png\" alt=\"\"></a>\r\n");
      out.write("        </h1>\r\n");
      out.write("         <nav class=\"gnb\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"/myInfoController\"><img src=\"/index_markup/img/myPageImg.png\" alt=\"\"></a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("         </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <section>\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <div class =\"cont_header\">   \r\n");
      out.write("           <div class = \"myPage1\" onclick = \"goMyInfo();\">\r\n");
      out.write("             <h4>내정보 관리</h4>\r\n");
      out.write("           </div>\r\n");
      out.write("           <div class = \"myPage2\">\r\n");
      out.write("             <h4>리뷰 관리</h4>\r\n");
      out.write("           </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class = \"content_form\">\r\n");
      out.write("                    <div id = \"e_form\">\r\n");
      out.write("                    <h1>작성 리뷰</h1>\r\n");
      out.write("                    \r\n");

				if (count > 0) { // 데이터베이스에 데이터가 있으면
					int number = count - (currentPage - 1) * pageSize; // 글 번호 순번 
					for (int i = 0; i < list.size(); i++) {
						reviewDTO lists = list.get(i); // 반환된 list에 담긴 참조값

      out.write("            \r\n");
      out.write("                    <div id = \"inform\" onclick = \"goResNum('");
      out.print(lists.getResnum());
      out.write("')\">\r\n");
      out.write("                    <div class = imgform>\r\n");
      out.write("                        <h1 class = \"iems\"><img src = \"/img/kakaologo.png\"></h1>\r\n");
      out.write("                        <div class =\"container\">\r\n");
      out.write("                            <h2>");
      out.print(lists.getResName());
      out.write("<span class = \"col\">★");
      out.print(lists.getStarScore());
      out.write("점</span><span>");
      out.print(lists.getReviewDate());
      out.write("</span></h2>\r\n");
      out.write("                                <div class = \"itemss\">");
      out.print(lists.getContent());
      out.write("</div>\r\n");
      out.write("                        </div> \r\n");
      out.write("                    </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

					}
				}else{
					
      out.write("\r\n");
      out.write("					<h2 align = \"center\">리뷰작성한 목록이 없습니다.</h2>\r\n");
      out.write("					");

				}
                    
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id = \"dss\">\r\n");
      out.write("                    <div class=\"pagination\">\r\n");
      out.write("                    ");
	// 페이징  처리
						if(count > 0){
							// 총 페이지의 수
							int pageCount = count / pageSize + (count%pageSize == 0 ? 0 : 1);
							// 한 페이지에 보여줄 페이지 블럭(링크) 수
							int pageBlock = 10;
							// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
							int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
							int endPage = startPage + pageBlock - 1;
							
							// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
							if(endPage > pageCount){
								endPage = pageCount;
							}
							
							if(startPage > pageBlock){ // 페이지 블록수보다 startPage가 클경우 이전 링크 생성
					
      out.write("\r\n");
      out.write("								<a href=\"reviewList.jsp?pageNum=");
      out.print(startPage - 10);
      out.write("\">[이전]</a>	\r\n");
      out.write("					");
			
							}
							
							for(int i=startPage; i <= endPage; i++){ // 페이지 블록 번호
								if(i == currentPage){ // 현재 페이지에는 링크를 설정하지 않음
					
      out.write("\r\n");
      out.write("									[");
      out.print(i );
      out.write("]\r\n");
      out.write("					");
									
								}else{ // 현재 페이지가 아닌 경우 링크 설정
					
      out.write("\r\n");
      out.write("									<a href=\"reviewList.jsp?pageNum=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a>\r\n");
      out.write("					");
	
								}
							} // for end
							
							if(endPage < pageCount){ // 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성
					
      out.write("\r\n");
      out.write("								<a href=\"reviewList.jsp?pageNum=");
      out.print(startPage + 10 );
      out.write("\">[다음]</a>\r\n");
      out.write("					");

							}
						}
					
      out.write("\r\n");
      out.write("                      </div>\r\n");
      out.write("                      <div id = \"titleButton\">\r\n");
      out.write("                        <button type=\"button\" class=\"w-btn w-btn-indigo\" onclick=\"goReviewList();\">작성한 리뷰 보기</button>\r\n");
      out.write("                        <button type=\"button\" class=\"w-btn w-btn-indigo\" onclick=\"updatefunction();\">작성 가능한 리뷰 보기</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
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
      out.write("<script type = \"text/javascript\">\r\n");
      out.write("function goReviewList(){\r\n");
      out.write("	location.href = \"/jyh/views/reviewList.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function goMyInfo(){\r\n");
      out.write("	location.href = \"/myInfoController\";\r\n");
      out.write("}\r\n");
      out.write("function goResNum(resnum){\r\n");
      out.write("	location.href = \"/ymw/pg0012.jsp?resnum=\"+resnum;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
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
