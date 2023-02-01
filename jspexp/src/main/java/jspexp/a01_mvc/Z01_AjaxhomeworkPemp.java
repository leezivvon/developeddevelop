package jspexp.a01_mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class z01_AjaxhomeworkPemp
 */
@WebServlet(name = "ajaxPemp.do", urlPatterns = { "/ajaxPemp.do" })
public class Z01_AjaxhomeworkPemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Z02_HomworkService service;
    
    public Z01_AjaxhomeworkPemp() {
        super();
        service = new Z02_HomworkService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empno = request.getParameter("empno");
		
		if(empno==null) {
			request.getRequestDispatcher("WEB-INF\\a01_mvc\\z01_ajaxHomwork.html");
		}else {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(service.getPempAjax(empno)); //데이터를 전송하는 부분
			
		}
	}

}
