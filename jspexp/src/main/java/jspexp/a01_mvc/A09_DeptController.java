package jspexp.a01_mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.vo.Dept;

/**
 * Servlet implementation class A09_DeptController
 */
@WebServlet(name = "deptList.do", urlPatterns = { "/deptList.do" })
public class A09_DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private A10_DeptService service;
    
    public A09_DeptController() {
    	service = new A10_DeptService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		Dept sch = new Dept(dname, loc);
		
		//view단 파일 이름인가..
		request.setAttribute("deptList", service.deptList(sch)); //service단이랑 연결인듯..
		
		String page="WEB-INF\\a01_mvc\\a08_deptList.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
