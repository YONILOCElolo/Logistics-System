package data;

import javax.management.modelmbean.ModelMBean;

public class Trucks {
	private String model ;
	private double load;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	public String toString() {
		return "�������ͣ�"+model+",    ����������"+load+"t";
	}
	public Trucks(String model, double load) {
		super();
		this.model = model;
		this.load = load;
	}
	

}
