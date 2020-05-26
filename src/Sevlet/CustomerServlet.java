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

//获取输入的客户信息
public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		final int size;
		final String[] N;//名字
		final double[] L;//横
		final double[] R;//纵
		
		//获取客户信息
		String name=request.getParameter("Cname");
		//将获取的几种信息转化为double型
		double number = Double.parseDouble(request.getParameter("Cnumber"));
		double left=Double.parseDouble(request.getParameter("Left"));
		double right=Double.parseDouble(request.getParameter("Right"));
		//实例化一个customer，并且将之添加进list
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
		if (4*((Math.pow(right, 2)+Math.pow(left, 2)))<(Math.pow(Maxdistance.getMaxdistance(), 2))&& number<=max) {
			CustomerList.add(customer);
//			System.out.println("操作成功，请继续");
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
