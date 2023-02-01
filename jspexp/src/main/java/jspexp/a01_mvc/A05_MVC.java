package jspexp.a01_mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspexp.a13_database.A02_EmpDao;
import jspexp.vo.Emp;

/**
 * Servlet implementation class A05_MVC
 */
@WebServlet(name = "mvc05", urlPatterns = { "/mvc05" })
public class A05_MVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A05_MVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 모델데이터
		A02_EmpDao dao = new A02_EmpDao();
		request.setAttribute("empList", dao.getEmpSch(new Emp("","",0,9999)));
		
		//view호출
		String page = "WEB-INF\\a01_mvc\\a05_empListView.jsp";
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

}
