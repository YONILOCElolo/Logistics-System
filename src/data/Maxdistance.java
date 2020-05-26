package data;

public class Maxdistance {
	public static double Maxdistance=0;

	public static double getMaxdistance() {
		return Maxdistance;
	}

	public static void setMaxdistance(double maxdistance) {
		Maxdistance = maxdistance;
	}
	public static int Maxdistance(String str) {
		//将得到的字符串转化为double型给全局变量Maxdistance赋值
		Maxdistance=Double.valueOf(str);
		return 1;
	}


}
