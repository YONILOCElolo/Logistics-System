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

//��ȡ����Ŀͻ���Ϣ
public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		final int size;
		final String[] N;//����
		final double[] L;//��
		final double[] R;//��
		
		//��ȡ�ͻ���Ϣ
		String name=request.getParameter("Cname");
		//����ȡ�ļ�����Ϣת��Ϊdouble��
		double number = Double.parseDouble(request.getParameter("Cnumber"));
		double left=Double.parseDouble(request.getParameter("Left"));
		double right=Double.parseDouble(request.getParameter("Right"));
		//ʵ����һ��customer�����ҽ�֮��ӽ�list
		Customer customer = new Customer(name, right, left, number);
		
		List<Customer> CustomerList = ListCustomer.getInstance();
		
		size = CustomerList.size();
		N = new String[size];
		L = new double[size];
		R = new double[size];
		Iterator<Customer> iterator1 = CustomerList.iterator();
		int i = 0;
		while (iterator1.hasNext()) {
			Customer cust = iterator1.next();
			N[i] = cust.getName();
			L[i] = cust.getLlocation();
			R[i] = cust.getRlocation();
			i++;
		}
		for(int j = 0; j < size; j++) {
			if( (N[j].equals(name) ) || (L[j] == left && R[j] == right) || (N[j].equals(name) && L[j] == left && R[j] == right)) {
				response.sendRedirect("Refail.jsp");
				return;
			} 
		}
				
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
		if (4*((Math.pow(right, 2)+Math.pow(left, 2)))<(Math.pow(Maxdistance.getMaxdistance(), 2))&& number<=max) {
			CustomerList.add(customer);
//			System.out.println("�����ɹ��������");
			response.sendRedirect("success.jsp");
			return;
		}else {
			response.sendRedirect("Cfail.jsp");
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
