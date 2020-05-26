package data;

import java.util.Iterator;

public class Customer {
	private String name;
	private double Rlocation;
	private double Llocation;
	private double quantity;
	
	public Customer(String name, double quantity) {
		this(name, 0, 0, quantity);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRlocation() {
		return Rlocation;
	}

	public void setRlocation(double rlocation) {
		Rlocation = rlocation;
	}

	public double getLlocation() {
		return Llocation;
	}

	public void setLlocation(double llocation) {
		Llocation = llocation;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Customer(String name, double right, double left, double number) {
		super();
		this.name = name;
		Rlocation = right;
		Llocation = left;
		this.quantity = number;
	}

	public String toString() {
		return "客户名称："+name+",客户横坐标"+Rlocation+",客户纵坐标:"+Llocation;
	}
	
}

