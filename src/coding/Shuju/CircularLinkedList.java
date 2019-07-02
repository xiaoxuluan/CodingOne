package coding.Shuju;

public class CircularLinkedList {
	
	//�����ڲ��ڵ���
	private class Node {
		private Node next = null;
		private Object value = null;
		
		public Node() {
			
		}
		public Node(Object value) {
			this.value=value;
		}
		
	}
	
	//�½�һ��null��ͷ���
	private Node head = null;
	
	//��ʼ��ͷ���
	public CircularLinkedList() {
		head = new Node(null);
		head.next=head;
		
	}
	
	//��β�����Ԫ��
	public void Addlast(Object o) {
		Node node = new Node(o);
		if(head.next==head) {
			head.next=node;
			node.next=head;
		}else {
			Node temp = head;
			while(temp.next!=head) {
				temp =temp.next;
			}
			
			temp.next = node;
			node.next = head;
		}
	}
	
	//ɾ���ڵ�
	public void deleteNode(Object deleteValue) {
		
		Node temp = head;
		while(temp.next!=head) {
			if(temp.next.value.equals(deleteValue)) {
				temp.next=temp.next.next;
			}else {
				temp = temp.next;
			}
		}
	}
	
	//����λ��Ϊindex�Ľڵ�ֵ
	public Object getIndexValue(int index) {
		if(index < 0 || index >= getSize()) {
			return null;
		}else {
			Node node = new Node();
			int count = 0;
			Node temp = head;
			while(temp.next != head) {
				if(count == index) {
					node.value = temp.next.value;
					break;
				}
				temp = temp.next;
			}
			
			return node.value;
		}
	}
	
	//����ֵΪvalue�Ľڵ�
	public int getValue(Object value) {
		int count =0;
		Node temp = head;
		while(temp.next != head) {
			if(temp.next.value.equals(value)) {
				return count;
			}
			count++;
			temp = temp.next;
		}
		return -1;
	}
	
	//��ȡѭ��������ĳ���
	public int getSize() {
		
		Node temp = head;
		int size=0;
		while(temp.next != head) {
			size++;
			temp = temp.next;
		}
		
		return size;
	}
	
	//�ж��Ƿ����ֵΪvalue�Ľڵ�
	public boolean isContain(Object value) {
		Node temp = head;
		while(temp.next != head) {
			if(temp.next.value.equals(value)) {
				return true;
			}
			temp =  temp.next;
		}
		return false;
	}
	
	public void printCircularLinkedList() {
		Node temp = head;
		while(temp.next!=head) {
			System.out.println(temp.next.value+"\t");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("----------------");
		CircularLinkedList c = new CircularLinkedList();
		c.Addlast(8);
		c.Addlast(89);
		c.Addlast(899);
		c.Addlast(8889);
		c.printCircularLinkedList();
		System.out.println(c.getSize());
		
		
	}

}
