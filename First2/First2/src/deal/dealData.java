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
	static double[] Right;// 横坐标
	static double[] Left;// 纵坐标
	static double[][] minPath;// 最短路线矩阵
	static double[] demand;
	public static double Routecount = 0;// 行驶总路程
	public static int length;
	/*
	 * 获取货车的载重量，将之存入
	 */
	static double[] MaxLoad;
	static int carLength;

	/**
	 * 在添加路径的时候，用于判断车辆是否超重，返回布尔类型
	 */
	public static double GetDrucks(double Demand) {
		List<Trucks> TruckList = ListTrucks.getInstance();// 取得汽车链表
		carLength = TruckList.size();// 汽车数量
		MaxLoad = new double[carLength];// 获取货车的最大载重量
		Iterator<Trucks> iterator = TruckList.iterator();
		// double[] car=new double[2];
		int i = 0;
		while (iterator.hasNext()) {
			Trucks trucks = iterator.next();
			MaxLoad[i] = trucks.getLoad();// 火车载重量
			i++;
		}

		Arrays.sort(MaxLoad);// 对汽车的载重量进行排序
		for (int j = 0; j < MaxLoad.length; j++) {
			if (Demand <= MaxLoad[j]) {
				return MaxLoad[j];// 如果添加的路径的需求量与之前的总重量依然未超重，返回true
			}
		}
		return -1;// 如果添加该客户点之后，将超重即返回false
	}

	/**
	 * 获取最短路径
	 */

	public static double[][] DealDistance() {
		// 计算最短路线矩阵
		List<Customer> CustomerList = ListCustomer.getInstance();
		length = CustomerList.size();// 配送数量
		// length = CustomerList.size();
//		System.out.println("一共有" + length + "个客户");
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
		} // 得到左右横坐标
		double temp = 0;
		for (int j = 1; j <= length; j++) {
			temp = Right[j - 1] * Right[j - 1] + Left[j - 1] * Left[j - 1];
			minPath[0][j] = Math.sqrt(temp);
		} // 得到每个点与坐标原点之间的距离
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
		 * 以上步骤为得到最短距离举证 下边的for循环可以用来检验查看该最短距离矩阵
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
	 * 寻找最终的路径
	 * 
	 *///
	static ArrayList<Route> route_result = new ArrayList<Route>();// 定义一个静态Route类型的链表
	static double[][] minPth;// 定义一个double类型的数组，用于接收最小路程矩阵
	static List<Path> save_distance;// 用于接收需求矩阵

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Route> dealPath() {
		List<Customer> CustomerList = ListCustomer.getInstance();// 得到客服链表
		int length = CustomerList.size();// 得到客户链表的长度
		minPth = new double[length + 1][length + 1];// 准备接收最小矩阵

		minPth = DealDistance(); // 获得最小矩阵
		save_distance = dealData.process(length, minPth); // 获得节约路径

		// 用来标记该点是否被添加过
		ArrayList<String> isAdd = new ArrayList<String>();// 装载添加过的客户点
		double MaxDistance = Maxdistance.Maxdistance;// 获取最大的行驶距离f
		if (save_distance != null) {// 如果需求矩阵，没有客户点就不执行
			for (Path p : save_distance) {// 遍历节约矩阵
				if (minPth[p.head1][0] == 0 && minPth[0][p.tail1] == 0)
					continue;// 如果执行到对角线的元素，是不符合的
				if (!isAdd.contains(p.head) && !isAdd.contains(p.tail)) {// 先判断节约矩阵之间的元素是否起点、终点都没有添加到路径
					double t = minPth[0][p.head1] + minPth[p.head1][p.tail1] + minPth[0][p.tail1];// 定义局部变量接收起点到P点、起点到终点、终点到P点路程之和，用于下面的判断
					double w = GetDrucks(
							CustomerList.get(p.head1 - 1).getQuantity() + CustomerList.get(p.tail1 - 1).getQuantity());// 定义局部变量接收起点、终点的需求量之和
					if (MaxDistance >= t) {// 判断路程是否超过配送路径
						if (w != -1) {// 传入局部变量，判断需求量是否超重
							Route loader = new Route();// 如果以上的条件都满足，就重新定义一条路径
							loader.route = new ArrayList();
							loader.residual_load = 0;// 载重量
							loader.Total_route = 0;
							loader.car = 0;
							isAdd.add(p.head);// 将起点、终点添加到数组中
							isAdd.add(p.tail);
							loader.route.add(p.head);// 将起点、终点添加到路径中
							loader.route.add(p.tail);
							loader.car = w;
							loader.residual_load = CustomerList.get(p.head1 - 1).getQuantity()
									+ CustomerList.get(p.tail1 - 1).getQuantity();// 更新载重量
							loader.Total_route = minPth[0][p.head1] + minPth[p.head1][p.tail1];// 更新里程
							route_result.add(loader);// 将路径加入到结果链表中
						} else
							continue;// 如果超重就跳过
					} else
						continue;// 如果超过配送距离就跳过
				} else if (!isAdd.contains(p.head) && isAdd.contains(p.tail)) {// 如果起点不在，终点已被添加
					int i = find(p.tail);// 用于查找终点被添加在那个路径之中
					int j = finds(p.tail);// 用于查找终点被添加到哪条路径中的就提哪个节点
					if (i != -1) {// 如果找到索引
						if (MaxDistance >= (route_result.get(i).Total_route + minPth[p.head1][p.tail1]
								+ minPth[0][p.tail1])) {// 判断添加该路径后，是否超过配送距离
							double w = GetDrucks(
									route_result.get(i).residual_load + CustomerList.get(p.head1 - 1).getQuantity());
							if (w != -1) {// 判断该客户点添加之后，是否超重
								route_result.get(i).route.add(j, p.head);// 添加head,到tail前
								isAdd.add(p.head);// 将起点添加到数组中
								route_result.get(i).car = w;// 更新选用的汽车载重类型
								route_result.get(i).residual_load += CustomerList.get(p.head1 - 1).getQuantity();// 更新载重量
								route_result.get(i).Total_route += minPth[p.head1][p.tail1];// 更新里程
							} else
								continue;// 如果超重就跳过

						} else
							continue;// 如果超过配送距离就跳过
					} else {
						System.out.println("未找到指定索引");// 如果没有找到索引
					}
				} else if (isAdd.contains(p.head) && !isAdd.contains(p.tail)) {
					int i = find(p.head);// 用于查找起点被添加在那个路径之中
					int j = finds(p.head);// 用于查找起点被添加到哪条路径中的就提哪个节点
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
					if (i != -1) {// 如果找到索引
						if (MaxDistance >= (route_result.get(i).Total_route + minPth[p.head1][p.tail1]
								+ minPth[0][a + 1])) {// 判断添加该路径后，是否超过配送距离
							double w = GetDrucks(
									route_result.get(i).residual_load + CustomerList.get(p.tail1 - 1).getQuantity());
							if (w != -1) {// 判断该客户点添加之后，是否超重
								route_result.get(i).route.add(j + 1, p.tail);// 添加tail到head之后
								isAdd.add(p.tail);// 将起点添加到数组中
								route_result.get(i).car = w;// 更新选用的汽车载重类型
								route_result.get(i).residual_load += CustomerList.get(p.tail1 - 1).getQuantity();// 更新载重量
								route_result.get(i).Total_route += minPth[p.head1][p.tail1];// 更新里程
							} else
								continue;// 如果超重就跳过
						} else
							continue;// 如果超过配送距离就跳过
					} else {
						System.out.println("未找到指定索引");// 如果没有找到索引
					}

				}
			}
			for (int j = 0; j < CustomerList.size(); j++) {// 当节约举证都遍历完成之后，对于还没有添加到路径中的客户点，进行添加。
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
				ArrayList temp = route_result.get(i).route;// 得到路线链表
				for (int j = 0; j < CustomerList.size(); j++) {
					if (temp.get(temp.size() - 1).toString() == CustomerList.get(j).getName()) {// 找到终点路线客户
						route_result.get(i).Total_route += minPth[0][j + 1];// 加入终点到P点的距离，得到总里程
					}
				}

			}
		}
		return route_result;// 返回结果链表
	}

	/* 返回线路在route_result当中的索引 */
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

	}/* 返回具体路线中，具体节点 */

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
	 * 最终路径的显示
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
//		System.out.println("总行驶里程：" + Routecount + "公里");

	}

	public static List<Path> process(int length, double[][] minPth) {
		List<Customer> CustomerList = ListCustomer.getInstance();
		double[][] save_distance = new double[length][length];// length表示目前配送点的个数
		List<Path> Save_distance = new ArrayList<Path>();// 计算节约里程，将数据保存在以Path为基本类型的ArrayList中
		for (int i = 0; i < length; i++) {// 节约里程矩阵相比于最短矩阵少了配送点P列
			for (int j = i; j < length - 1; j++) {
				save_distance[i][j] = minPth[0][i + 1] + minPth[0][j + 2] - minPth[i + 1][j + 2];
				// System.out.println(save_distance[i][j]);
				save_distance[j][i] = save_distance[i][j];// 节约里程矩阵以对角线对称的值必须相同
				if (save_distance[i][j] == 0)
					continue;// 当节约里程书等于0时，就不必添加
				Path path = new Path(CustomerList.get(i).getName(), CustomerList.get(j + 1).getName(), i + 1, j + 2,
						save_distance[i][j]);// 此处的i,j表示配送点的编码

				Save_distance.add(path);

				// 将此路线存入链表中
			}
		}
		// 判断节约里程矩阵是否正确
//		System.out.println("节约里程矩阵：");
//		for (int i = 0; i < length - 1; i++) {
//			for (int j = 0; j < length - 1; j++) {
//				System.out.print(save_distance[i][j] + ",");
//			}
//			System.out.println();
//		}
//		System.out.println();// 测试结束
		int len = Save_distance.size();// 总共存入的路线个数
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
//		System.out.println("需求矩阵：");// 排序后的节约里程矩阵
//		for (int i = 0; i < Save_distance.size(); i++) {
//			System.out.print("\t" + Save_distance.get(i).head);
//			System.out.print("\t" + Save_distance.get(i).tail);
//			System.out.println("\t" + Save_distance.get(i).save_distance);
//		}
		return Save_distance;
	}

}
