package data;

public class Path {
	public double save_distance;//��Լ���
	public String head; //���
	public String tail;  //�յ�
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
