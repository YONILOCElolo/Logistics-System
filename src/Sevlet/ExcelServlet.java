package Sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import deal.GetExcel;
import jdk.internal.dynalink.beans.StaticClass;

public class ExcelServlet extends HttpServlet {
	public static int flag=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取jsp中输入的最大距离
		request.setCharacterEncoding("utf-8");
		String a=request.getParameter("Lname");
		flag=GetExcel.getData(a);
		if(flag==1) {
			response.sendRedirect("success3.jsp");
		}else {
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
