package Sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��������������
public class MaxdistanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int b=0;
		//��ȡjsp�������������
		request.setCharacterEncoding("utf-8");
		String a=request.getParameter("Maxdistance");
		if(a==null) {
			response.sendRedirect("fail.jsp");
		}
		b=data.Maxdistance.Maxdistance(a);
		//�ж��Ƿ�����ɹ�
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
