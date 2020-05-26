package Sevlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data.ListTrucks;

import data.Trucks;

public class TrucksServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// ��ȡ������Ϣ
		String model = request.getParameter("model");
		// ����ȡ��������ת��Ϊdouble��
		double load = Double.parseDouble(request.getParameter("load"));
		Trucks truck = new Trucks(model, load);
		List<Trucks> trucksList = ListTrucks.getInstance();
	
		
		final int size;
		final String[] M;//��܇��Ϣ
		final double[] L;//�d����
	

		size = trucksList.size();
		M = new String[size];
		L = new double[size];
	
		Iterator<Trucks> iterator1 = trucksList.iterator();
		int i = 0;
		while (iterator1.hasNext()) {
			Trucks trucks = iterator1.next();
			M[i] = trucks.getModel();
			L[i] = trucks.getLoad();
			
			i++;
		}
		for(int j = 0; j < size; j++) {
			if( (M[j].equals(model) ) ) {
				response.sendRedirect("fail.jsp");
				return;
			} 
		}
				
		
		
		
		
		
		
		
		
		
		
		
		
			trucksList.add(truck);
			response.sendRedirect("success1.jsp");
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
