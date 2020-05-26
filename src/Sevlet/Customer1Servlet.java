package Sevlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Customer;
import data.ListCustomer;
import data.ListTrucks;
import data.Maxdistance;
import data.Trucks;

public class Customer1Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		final int size;
		final String[] N;//����
		
		//��ȡ�ͻ���Ϣ
		String name=request.getParameter("Cname2");
		//����ȡ�ļ�����Ϣת��Ϊdouble��
		double number = Double.parseDouble(request.getParameter("Cnumber2"));
		//ʵ����һ��customer�����ҽ�֮��ӽ�list
		Customer customer = new Customer(name, number);
		
		List<Customer> CustomerList = ListCustomer.getInstance();
	
		//��ȡ�����������ҳ����������
		double max=0;
		List<Trucks> TruckList = ListTrucks.getInstance();
		Iterator<Trucks> iterator = TruckList.iterator();
		while (iterator.hasNext()) {
			Trucks trucks = iterator.next();
			if( max<trucks.getLoad()){
				max=trucks.getLoad();
			}
			
		}
		
			
		
//�жϿͻ���Ϣ�Ƿ�ϸ�
		if ( number<=max) {
			CustomerList.add(customer);
//			System.out.println("�����ɹ��������");
			response.sendRedirect("success4.jsp");
			return;
		}else {
			response.sendRedirect("fail2.jsp");
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
