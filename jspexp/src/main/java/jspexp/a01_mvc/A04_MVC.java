package jspexp.a01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.vo.Dept;
import jspexp.vo.Emp;

/**
 * Servlet implementation class A04_MVC
 */
@WebServlet(name = "mvcEmp", urlPatterns = { "/mvcEmp" })
public class A04_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기는 controller단
		// 1. 요청처리
		
		// 2. model
		request.setAttribute("emp", new Emp("이지동", 250.0, 7006));
		
		// 3. view
		String page="WEB-INF\\a01_mvc\\a04_view.jsp"; 
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
