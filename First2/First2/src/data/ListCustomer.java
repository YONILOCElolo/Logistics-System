package data;


import java.util.LinkedList;
import java.util.List;

import data.Customer;;

public class ListCustomer{
	private ListCustomer() {
		
	}
	
	private static List<Customer> CustomerList;
	
	public static List<Customer> getInstance(){
		if(CustomerList==null)
		{
			CustomerList=new LinkedList<Customer>();
		}
		return CustomerList;
	}

}
