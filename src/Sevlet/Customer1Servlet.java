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
		final String[] N;//名字
		
		//获取客户信息
		String name=request.getParameter("Cname2");
		//将获取的几种信息转化为double型
		double number = Double.parseDouble(request.getParameter("Cnumber2"));
		//实例化一个customer，并且将之添加进list
		Customer customer = new Customer(name, number);
		
		List<Customer> CustomerList = ListCustomer.getInstance();
	
		//获取卡车的链表并找出最大载重量
		double max=0;
		List<Trucks> TruckList = ListTrucks.getInstance();
		Iterator<Trucks> iterator = TruckList.iterator();
		while (iterator.hasNext()) {
			Trucks trucks = iterator.next();
			if( max<trucks.getLoad()){
				max=trucks.getLoad();
			}
			
		}
		
			
		
//判断客户信息是否合格
		if ( number<=max) {
			CustomerList.add(customer);
//			System.out.println("操作成功，请继续");
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
