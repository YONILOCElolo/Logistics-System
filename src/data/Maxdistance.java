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
		//���õ����ַ���ת��Ϊdouble�͸�ȫ�ֱ���Maxdistance��ֵ
		Maxdistance=Double.valueOf(str);
		return 1;
	}


}
