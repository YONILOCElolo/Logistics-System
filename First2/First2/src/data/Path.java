package data;

public class Path {
	public double save_distance;//节约里程
	public String head; //起点
	public String tail;  //终点
	public int head1;
	public int tail1;
	public Path(String head,String tail,int head1,int tail1,double save_distance){
		this.head = head;
		this.tail = tail;
		this.head1=head1;
		this.tail1=tail1;
		this.save_distance = save_distance;
	}
}
