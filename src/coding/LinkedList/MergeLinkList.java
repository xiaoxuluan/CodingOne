package coding.LinkedList;

import java.util.ArrayList;



public class MergeLinkList {


	private Node head;

	// 打印元素
	public void printLinkedList() {
		Node p = head;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	// 打印元素
		public void printNode(Node p) {
			while (p != null) {
				System.out.print(p.data + " ");
				p = p.next;
			}
			System.out.println();
		}

	// 在头部添加元素
	public void addLinkedHead(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
			return;
		}
		temp.next = head;
		head = temp;
	}

	// 在尾部添加元素
	public void addLinkedRaer(int data) {
		Node temp = new Node(data);
		if (head == null) {
			head = temp;
			return;
		}

		Node p = head;
		while (p.next != null)
			p = p.next;
		p.next = temp;

	}

	// 打印方案2 用Arraylist逆序打印链表
	public void print2() {
		Node node = head;
		if (node == null) {
			System.out.println("链表为空");
		}
		ArrayList<Integer> a = new ArrayList<>();
		while (node != null) {
			a.add(node.data);
			node = node.next;
		}

		for (int i = a.size() - 1; i >= 0; i--) {
			System.out.print(a.get(i) + " ");
		}
	}
	
	//非递归合并链表
	public Node Merge(Node n1,Node n2) {
		if(n1 == null) {
			System.out.println(n2);
		}
		
		if(n2==null) {
			System.out.println(n1);
		}
		
		Node  current = new Node(-1);
		Node root = current;
		while(n1!=null&&n2!=null) {
			if(n2.data>=n1.data) {
				current.next=n1;
				current = n1;
				n1 = n1.next;
			}else {
				current.next = n2;
				current =  n2;
				n2 = n2.next;
				
			}
		}
		if(n1!=null) {
			current.next= n1;
		}
		if(n2!=null) {
			current.next= n2;
		}
		
		return root;
	}

	public static void main(String[] args) {
		MergeLinkList m = new MergeLinkList();
		System.out.println("第一个链表是----------");
		m.addLinkedHead(1);
		m.addLinkedHead(3);
		m.addLinkedHead(5);
		m.addLinkedHead(7);
		m.addLinkedHead(9);
		m.printLinkedList();

		System.out.println("第二个链表是----------");
		MergeLinkList m1 = new MergeLinkList();
		m1.addLinkedHead(2);
		m1.addLinkedHead(4);
		m1.addLinkedHead(6);
		m1.addLinkedHead(8);
		m1.addLinkedHead(10);
		m1.printLinkedList();

		MergeLinkList m2 = new MergeLinkList();
		m2.addLinkedRaer(9);
		m2.addLinkedRaer(90);
		m2.addLinkedRaer(900);
		m2.addLinkedRaer(9000);
		m2.printLinkedList();

		MergeLinkList m3 = new MergeLinkList();
		m3.addLinkedRaer(91);
		m3.addLinkedRaer(901);
		m3.addLinkedRaer(9001);
		m3.addLinkedRaer(90001);
		m3.printLinkedList();

		// 合并两个链表
		
		
        Node node11=new Node(1);
        Node node12=new Node(3);
        Node node13=new Node(5);
        Node node14=new Node(7);
        Node node15=new Node(9);

        Node node21=new Node(2);
        Node node22=new Node(4);
        Node node23=new Node(6);
        Node node24=new Node(8);
        Node node25=new Node(10);

        node11.next=node12;
        node12.next=node13;
        node13.next=node14;
        node14.next=node15;

        node21.next=node22;
        node22.next=node23;
        node23.next=node24;
        node24.next=node25;
        m3.printNode(node11);
        m3.printNode(node21);
		

        Node node31 = m3.Merge(node11, node21);
        m3.printNode(node31);

		System.out.println("------------合并两个链表--------------");

		// 非递归合并

	}

}
