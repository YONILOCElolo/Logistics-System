package Sevlet;

import java.io.IOException;
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

public class TrucksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取货车信息
		String model=request.getParameter("model");
		//将获取的载重量转化为double型
		double load = Double.parseDouble(request.getParameter("load"));
		Trucks truck=new Trucks(model, load);
		List<Trucks> trucksList = ListTrucks.getInstance();
		trucksList.add(truck);
		response.sendRedirect("success1.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
