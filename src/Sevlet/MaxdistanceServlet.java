package Sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//处理最大输入距离
public class MaxdistanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b=0;
		//获取jsp中输入的最大距离
		request.setCharacterEncoding("utf-8");
		String a=request.getParameter("Maxdistance");
		if(a==null) {
			response.sendRedirect("fail.jsp");
		}
		b=data.Maxdistance.Maxdistance(a);
		//判断是否操作成功
		if(b==1) {
			response.sendRedirect("success2.jsp");
		}else {
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
