package Sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tag2Servlet
 */
public class Tag2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.getRequestDispatcher("Tab.jsp?id=tag2").forward(request, response);
		// request.setCharacterEncoding("utf-8");
		String P1 = request.getParameter("page1");
		String P2 = request.getParameter("page2");
		String P2_fail = request.getParameter("page2_fail");
		String P2_cfail = request.getParameter("page2_cfail");
		String P2_dfail = request.getParameter("page2_dfail");
		String P2_refail = request.getParameter("page2_refail");
		String P3 = request.getParameter("page3");
		String P4 = request.getParameter("dpage");
//		System.out.println(P1.equals("点击继续"));
		if (P1 != null) {
			if (P1.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Trucks.jsp");
			}
		}

		if (P2 != null) {
			if (P2.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Trucks.jsp");
			} else if (P2.equals("结束")) {
//				if(str1.equals("结束")) {
					response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/choice.jsp");
				}
		}
		if (P2_fail != null) {
			if (P2_fail.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Trucks.jsp");
			}
		}
		
		if (P2_cfail != null) {
			if (P2_cfail.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Customer.jsp");
			}
		}
		if (P2_dfail != null) {
			if (P2_dfail.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Customer.jsp");
			}
		}
		
		if (P2_refail != null) {
			if (P2_refail.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Customer.jsp");
			}
		}

		if (P3 != null) {
			if (P3.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/Customer.jsp");
			} else if (P3.equals("结束添加")) {
//			if(str1.equals("结束")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/DealData.jsp");
			}
		}
		
		if (P4 != null) {
			if (P4.equals("点击继续")) {
				response.sendRedirect("http://localhost:" + request.getServerPort()+"/First/information.jsp");
			} 
		}
	}

}
