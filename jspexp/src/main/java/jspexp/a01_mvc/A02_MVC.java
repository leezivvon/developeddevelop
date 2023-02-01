package jspexp.a01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A02_MVC
 */
@WebServlet(name = "mvc02.do", urlPatterns = { "/mvc02.do" })
public class A02_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// http://localhost:7080/mvc02.do
	
	// ex) "WEB-INF\\a01_mvc\\a02_view.jsp"; 두번째 view단 입니다
	//		A02_MVC.java
	// 		mvc02.do로 설정하여 출력하세요

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// view단 호출
		String page= "WEB-INF\\a01_mvc\\a02_view.jsp";
		
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
