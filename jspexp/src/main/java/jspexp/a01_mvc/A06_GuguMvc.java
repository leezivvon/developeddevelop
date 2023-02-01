package jspexp.a01_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A06_GuguMvc
 */
@WebServlet(name = "gugu.do", urlPatterns = { "/gugu.do" })
public class A06_GuguMvc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청값 처리
		String num01S = request.getParameter("num01");
		String num02S = request.getParameter("num02");
				
		// 2. 모델데이터 처리
		if(num01S!=null){ //초기화면과 구분
			int num01 = Integer.parseInt(num01S);
			int num02 = Integer.parseInt(num02S);
			request.setAttribute("result", num01+"X"+num02+"="+(num01*num02));
		}
		// 3. view단 호출
		String page = "WEB-INF\\a01_mvc\\a06_guguView.jsp";
		request.getRequestDispatcher(page).forward(request, response);
				
	}

}
