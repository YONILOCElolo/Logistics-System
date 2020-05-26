package data;

public class finPath {
	public int i;
	public String way;
	public double weigth;
	public double car;

	public finPath(int i, String way, double weigth,double car) {
		this.i = i;
		this.way = way;
		this.weigth = weigth;
		this.car=car;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public double getWeigth() {
		return weigth;
	}

	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	public double getCar() {
		return car;
	}

	public void setCar(double car) {
		this.car = car;
	}
	
}
