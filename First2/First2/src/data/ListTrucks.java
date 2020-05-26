package data;


import java.util.LinkedList;
import java.util.List;

import data.Customer;;

public class ListTrucks{
	private ListTrucks() {
		
	}
	private static List<Trucks> TrucksList;
	public static List<Trucks> getInstance(){
		if(TrucksList==null)
		{
			TrucksList=new LinkedList<Trucks>();
		}
		return TrucksList;
	}
}
