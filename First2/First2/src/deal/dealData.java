package deal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import data.Customer;
import data.ListCustomer;
import data.ListTrucks;
import data.ListfinPath;
import data.Maxdistance;
import data.Path;
import data.Route;
//import data.Trucks;
import data.Trucks;
import data.finPath;

import java.util.LinkedList;

public class dealData {
	static double[] Right;// ������
	static double[] Left;// ������
	static double[][] minPath;// ���·�߾���
	static double[] demand;
	public static double Routecount = 0;// ��ʻ��·��
	public static int length;
	/*
	 * ��ȡ����������������֮����
	 */
	static double[] MaxLoad;
	static int carLength;

	/**
	 * �����·����ʱ�������жϳ����Ƿ��أ����ز�������
	 */
	public static double GetDrucks(double Demand) {
		List<Trucks> TruckList = ListTrucks.getInstance();// ȡ����������
		carLength = TruckList.size();// ��������
		MaxLoad = new double[carLength];// ��ȡ���������������
		Iterator<Trucks> iterator = TruckList.iterator();
		// double[] car=new double[2];
		int i = 0;
		while (iterator.hasNext()) {
			Trucks trucks = iterator.next();
			MaxLoad[i] = trucks.getLoad();// ��������
			i++;
		}

		Arrays.sort(MaxLoad);// ����������������������
		for (int j = 0; j < MaxLoad.length; j++) {
			if (Demand <= MaxLoad[j]) {
				return MaxLoad[j];// �����ӵ�·������������֮ǰ����������Ȼδ���أ�����true
			}
		}
		return -1;// �����Ӹÿͻ���֮�󣬽����ؼ�����false
	}

	/**
	 * ��ȡ���·��
	 */

	public static double[][] DealDistance() {
		// �������·�߾���
		List<Customer> CustomerList = ListCustomer.getInstance();
		length = CustomerList.size();// ��������
		// length = CustomerList.size();
//		System.out.println("һ����" + length + "���ͻ�");
		double[] Right = new double[length];
		double[] Left = new double[length];
		double[][] minPath = new double[length + 1][length + 1];
		Iterator<Customer> iterator = CustomerList.iterator();

		int i = 0;
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			Right[i] = customer.getRlocation();
			Left[i] = customer.getLlocation();

			i++;
		} // �õ����Һ�����
		double temp = 0;
		for (int j = 1; j <= length; j++) {
			temp = Right[j - 1] * Right[j - 1] + Left[j - 1] * Left[j - 1];
			minPath[0][j] = Math.sqrt(temp);
		} // �õ�ÿ����������ԭ��֮��ľ���
		for (i = 1; i <= length; i++) {

			for (int j = i + 1; j <= length; j++) {
				temp = (Right[i - 1] - Right[j - 1]) * (Right[i - 1] - Right[j - 1])
						+ (Left[i - 1] - Left[j - 1]) * (Left[i - 1] - Left[j - 1]);
				minPath[i][j] = Math.sqrt(temp);
			}
		}
		for (i = 0; i <= length; i++) {

			for (int j = 0; j <= i; j++) {
				minPath[i][j] = minPath[j][i];
			}
		}

		/*
		 * ���ϲ���Ϊ�õ���̾����֤ �±ߵ�forѭ��������������鿴����̾������
		 */

//		for (i = 0; i <= length; i++) {
//			for (int j = 0; j <= length; j++) {
//				System.out.print(minPath[i][j] + "    ");
//			}
//			System.out.println();
//		}
		return minPath;
	}

	/*
	 * 
	 * Ѱ�����յ�·��
	 * 
	 *///
	static ArrayList<Route> route_result = new ArrayList<Route>();// ����һ����̬Route���͵�����
	static double[][] minPth;// ����һ��double���͵����飬���ڽ�����С·�̾���
	static List<Path> save_distance;// ���ڽ����������

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Route> dealPath() {
		List<Customer> CustomerList = ListCustomer.getInstance();// �õ��ͷ�����
		int length = CustomerList.size();// �õ��ͻ�����ĳ���
		minPth = new double[length + 1][length + 1];// ׼��������С����

		minPth = DealDistance(); // �����С����
		save_distance = dealData.process(length, minPth); // ��ý�Լ·��

		// ������Ǹõ��Ƿ���ӹ�
		ArrayList<String> isAdd = new ArrayList<String>();// װ����ӹ��Ŀͻ���
		double MaxDistance = Maxdistance.Maxdistance;// ��ȡ������ʻ����f
		if (save_distance != null) {// ����������û�пͻ���Ͳ�ִ��
			for (Path p : save_distance) {// ������Լ����
				if (minPth[p.head1][0] == 0 && minPth[0][p.tail1] == 0)
					continue;// ���ִ�е��Խ��ߵ�Ԫ�أ��ǲ����ϵ�
				if (!isAdd.contains(p.head) && !isAdd.contains(p.tail)) {// ���жϽ�Լ����֮���Ԫ���Ƿ���㡢�յ㶼û����ӵ�·��
					double t = minPth[0][p.head1] + minPth[p.head1][p.tail1] + minPth[0][p.tail1];// ����ֲ�����������㵽P�㡢��㵽�յ㡢�յ㵽P��·��֮�ͣ�����������ж�
					double w = GetDrucks(
							CustomerList.get(p.head1 - 1).getQuantity() + CustomerList.get(p.tail1 - 1).getQuantity());// ����ֲ�����������㡢�յ��������֮��
					if (MaxDistance >= t) {// �ж�·���Ƿ񳬹�����·��
						if (w != -1) {// ����ֲ��������ж��������Ƿ���
							Route loader = new Route();// ������ϵ����������㣬�����¶���һ��·��
							loader.route = new ArrayList();
							loader.residual_load = 0;// ������
							loader.Total_route = 0;
							loader.car = 0;
							isAdd.add(p.head);// ����㡢�յ���ӵ�������
							isAdd.add(p.tail);
							loader.route.add(p.head);// ����㡢�յ���ӵ�·����
							loader.route.add(p.tail);
							loader.car = w;
							loader.residual_load = CustomerList.get(p.head1 - 1).getQuantity()
									+ CustomerList.get(p.tail1 - 1).getQuantity();// ����������
							loader.Total_route = minPth[0][p.head1] + minPth[p.head1][p.tail1];// �������
							route_result.add(loader);// ��·�����뵽���������
						} else
							continue;// ������ؾ�����
					} else
						continue;// ����������;��������
				} else if (!isAdd.contains(p.head) && isAdd.contains(p.tail)) {// �����㲻�ڣ��յ��ѱ����
					int i = find(p.tail);// ���ڲ����յ㱻������Ǹ�·��֮��
					int j = finds(p.tail);// ���ڲ����յ㱻��ӵ�����·���еľ����ĸ��ڵ�
					if (i != -1) {// ����ҵ�����
						if (MaxDistance >= (route_result.get(i).Total_route + minPth[p.head1][p.tail1]
								+ minPth[0][p.tail1])) {// �ж���Ӹ�·�����Ƿ񳬹����;���
							double w = GetDrucks(
									route_result.get(i).residual_load + CustomerList.get(p.head1 - 1).getQuantity());
							if (w != -1) {// �жϸÿͻ������֮���Ƿ���
								route_result.get(i).route.add(j, p.head);// ���head,��tailǰ
								isAdd.add(p.head);// �������ӵ�������
								route_result.get(i).car = w;// ����ѡ�õ�������������
								route_result.get(i).residual_load += CustomerList.get(p.head1 - 1).getQuantity();// ����������
								route_result.get(i).Total_route += minPth[p.head1][p.tail1];// �������
							} else
								continue;// ������ؾ�����

						} else
							continue;// ����������;��������
					} else {
						System.out.println("δ�ҵ�ָ������");// ���û���ҵ�����
					}
				} else if (isAdd.contains(p.head) && !isAdd.contains(p.tail)) {
					int i = find(p.head);// ���ڲ�����㱻������Ǹ�·��֮��
					int j = finds(p.head);// ���ڲ�����㱻��ӵ�����·���еľ����ĸ��ڵ�
					int a = 0;
					int sizes = route_result.get(i).route.size();
					if (route_result.get(i).route.get(sizes - 1).toString() == p.head) {
						for (int k = 0; k < CustomerList.size(); k++) {
							if (p.tail == CustomerList.get(k).getName()) {
								a = k;
							}
						}
					} else {
						for (int k = 0; k < CustomerList.size(); k++) {
							if (route_result.get(i).route.get(sizes - 1).toString() == CustomerList.get(k).getName()) {
								a = k;
							}
						}
					}
					if (i != -1) {// ����ҵ�����
						if (MaxDistance >= (route_result.get(i).Total_route + minPth[p.head1][p.tail1]
								+ minPth[0][a + 1])) {// �ж���Ӹ�·�����Ƿ񳬹����;���
							double w = GetDrucks(
									route_result.get(i).residual_load + CustomerList.get(p.tail1 - 1).getQuantity());
							if (w != -1) {// �жϸÿͻ������֮���Ƿ���
								route_result.get(i).route.add(j + 1, p.tail);// ���tail��head֮��
								isAdd.add(p.tail);// �������ӵ�������
								route_result.get(i).car = w;// ����ѡ�õ�������������
								route_result.get(i).residual_load += CustomerList.get(p.tail1 - 1).getQuantity();// ����������
								route_result.get(i).Total_route += minPth[p.head1][p.tail1];// �������
							} else
								continue;// ������ؾ�����
						} else
							continue;// ����������;��������
					} else {
						System.out.println("δ�ҵ�ָ������");// ���û���ҵ�����
					}

				}
			}
			for (int j = 0; j < CustomerList.size(); j++) {// ����Լ��֤���������֮�󣬶��ڻ�û����ӵ�·���еĿͻ��㣬������ӡ�
				int flag = -1;
				if (!isAdd.contains(CustomerList.get(j).getName())) {
					flag = j;
				}

				if (flag != -1) {
					Route loRoute = new Route();
					loRoute.route = new ArrayList();
					loRoute.route.add(CustomerList.get(flag).getName());
					loRoute.residual_load = CustomerList.get(flag).getQuantity();
					if (GetDrucks(loRoute.residual_load) != -1) {
						loRoute.car = GetDrucks(loRoute.residual_load);
					}
					loRoute.Total_route = minPth[0][flag + 1];
					route_result.add(loRoute);
				}
			}
			for (int i = 0; i < route_result.size(); i++) {
				ArrayList temp = route_result.get(i).route;// �õ�·������
				for (int j = 0; j < CustomerList.size(); j++) {
					if (temp.get(temp.size() - 1).toString() == CustomerList.get(j).getName()) {// �ҵ��յ�·�߿ͻ�
						route_result.get(i).Total_route += minPth[0][j + 1];// �����յ㵽P��ľ��룬�õ������
					}
				}

			}
		}
		return route_result;// ���ؽ������
	}

	/* ������·��route_result���е����� */
	@SuppressWarnings("rawtypes")
	public static int find(String object) {
		for (int i = 0; i < route_result.size(); i++) {
			ArrayList temp = route_result.get(i).route;
			for (int j = 0; j < temp.size(); j++) {

				if (temp.get(j).toString() == object) {

					return i;
				}
			}
		}
		return -1;

	}/* ���ؾ���·���У�����ڵ� */

	public static int finds(String object) {
		for (int i = 0; i < route_result.size(); i++) {
			ArrayList temp = route_result.get(i).route;
			for (int j = 0; j < temp.size(); j++) {

				if (temp.get(j).toString() == object) {

					return j;
				}
			}
		}
		return -1;

	}

	/*
	 * 
	 * ����·������ʾ
	 */
	@SuppressWarnings("rawtypes")
	public static void FinPath() {
		// GetDrucks();
		ArrayList<Route> route_result = dealPath();
		int n = 0;
		List<Customer> CustomerList = ListCustomer.getInstance();

		for (Route rute : route_result) {

			ArrayList routes = rute.route;

			n++;
			String way = "P0-";
			for (int i = 0; i < routes.size(); i++) {
				String name = routes.get(i).toString();
				way = way + name + "-";

			}
			way = way + "P0";
			finPath finPath = new finPath(n, way, rute.Total_route,rute.car);
			List<finPath> finPathList = ListfinPath.getInstance();
			finPathList.add(finPath);
			Routecount += rute.Total_route;

		}
//		System.out.println();
//		System.out.println("����ʻ��̣�" + Routecount + "����");

	}

	public static List<Path> process(int length, double[][] minPth) {
		List<Customer> CustomerList = ListCustomer.getInstance();
		double[][] save_distance = new double[length][length];// length��ʾĿǰ���͵�ĸ���
		List<Path> Save_distance = new ArrayList<Path>();// �����Լ��̣������ݱ�������PathΪ�������͵�ArrayList��
		for (int i = 0; i < length; i++) {// ��Լ��̾����������̾����������͵�P��
			for (int j = i; j < length - 1; j++) {
				save_distance[i][j] = minPth[0][i + 1] + minPth[0][j + 2] - minPth[i + 1][j + 2];
				// System.out.println(save_distance[i][j]);
				save_distance[j][i] = save_distance[i][j];// ��Լ��̾����ԶԽ��߶ԳƵ�ֵ������ͬ
				if (save_distance[i][j] == 0)
					continue;// ����Լ��������0ʱ���Ͳ������
				Path path = new Path(CustomerList.get(i).getName(), CustomerList.get(j + 1).getName(), i + 1, j + 2,
						save_distance[i][j]);// �˴���i,j��ʾ���͵�ı���

				Save_distance.add(path);

				// ����·�ߴ���������
			}
		}
		// �жϽ�Լ��̾����Ƿ���ȷ
//		System.out.println("��Լ��̾���");
//		for (int i = 0; i < length - 1; i++) {
//			for (int j = 0; j < length - 1; j++) {
//				System.out.print(save_distance[i][j] + ",");
//			}
//			System.out.println();
//		}
//		System.out.println();// ���Խ���
		int len = Save_distance.size();// �ܹ������·�߸���
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				Path m = Save_distance.get(j);
				Path n = Save_distance.get(j + 1);
				if (m.save_distance < n.save_distance) {
					Path temp = m;
					Save_distance.set(j, n);
					Save_distance.set(j + 1, temp);
				}
			}
		}
//		System.out.println("�������");// �����Ľ�Լ��̾���
//		for (int i = 0; i < Save_distance.size(); i++) {
//			System.out.print("\t" + Save_distance.get(i).head);
//			System.out.print("\t" + Save_distance.get(i).tail);
//			System.out.println("\t" + Save_distance.get(i).save_distance);
//		}
		return Save_distance;
	}

}
