package coding.Shuju;

import java.util.ArrayList;

class Node{
	public Node next;
	public int data;
	public Node(int data) {
		this.data=data;
	}
}

public class SingleNode {
	
	public Node head;
	public int length=0;
	
	
	//��ӡ����
	public void printLinkList() {
		Node p = head;
		while(p!=null) {
			System.out.print(p.data+" ");
			p=p.next;
		}
		System.out.println();
		System.out.println("����ĳ�����---"+length);
	}
	
	//��ӡ����2 ��Arraylist��ӡ����
	public void print2(Node node) {
		if(node == null) {
			System.out.println("����Ϊ��");
		}
		ArrayList<Integer> a = new ArrayList<>();
		while(node != null) {
			a.add(node.data);
			node = node.next;
		}
		for (int i = 0; i < a.size()-1; i++) {
			System.err.println(a.get(i));
		}
	}
	
	//�ж������Ƿ�Ϊ��
	public Boolean isEmpty() {
		if(head==null)
			return true;
		return false;
	}
	
	
	//��ͷ������ڵ�
	public void addHeadNode(int data) {
		Node x =  new Node(data);
		if(head==null) {
			head=x;
			length++;
			return ;
			
		}
		x.next=head;
		head=x;
		length++;
	}
	
	//��β������ڵ�
	
		public void addLastNode(int data)
		{
			Node x=new Node(data);
			if(head==null)
			{
				head=x;
				length++;
				return;
			}
			Node q=head;
			while(q.next!=null)
			q=q.next;
			q.next=x;
			length++;
		}
	
	
	//ɾ���ڵ�
	public Boolean deleteNode(int index) {
		if(index<1||index>length) 
			return false;
		int i=1;
		Node p = head;
		while(i!=(index-1)) {
			p=p.next;
			i++;
		}
		(p.next)=(p.next.next);
		length--;
		return true;
	}
	
	//�޸Ľڵ�
	public Boolean updateNode(int index,int data) {
		if(index<1||index>length)
			return false;
		int i=1;
		Node p = head;
		while(i<index) {
			p=p.next;
			i++;
		}
		p.data=data;
		return true;
	}
	
	//ð������
	public void bubbleSort() {
		
		Boolean flag = false;
		Node p =head;
		Node q = null;
		for(int i=0;i<length-1;i++) {
			q=p.next;
				for(int j=i;j<length-1;j++) {
					if(p.data>q.data) {
						int temp = p.data;
						p.data=q.data;
						q.data=temp;
						flag=true;
					}
					q=q.next;
				}
				
				if(flag==false)
					break;
				flag=false;
				p=p.next;
		}
	}
	
	
	public static void main(String[] args) {
		SingleNode sn = new SingleNode();
		sn.addHeadNode(1);
		sn.addHeadNode(2);
		sn.addHeadNode(3);
		sn.addHeadNode(4);
		sn.printLinkList();
		
		SingleNode sn1 = new SingleNode();

		sn1.addLastNode(9);
		sn1.addLastNode(5);
		sn1.addLastNode(4);
		sn1.addLastNode(3);
		sn1.printLinkList();
		
		sn1.updateNode(2, 111);
		sn1.printLinkList();
		
		sn1.deleteNode(3);
		sn1.printLinkList();
		
		sn1.bubbleSort();
		sn1.printLinkList();
		

	}

}
