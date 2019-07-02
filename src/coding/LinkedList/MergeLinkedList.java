package coding.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/*�����г�����������
1����β��ͷ��ӡ������
2����O(1)ʱ��ɾ��������
3�������е�����k�����
4����ת����
5���ϲ�������������
6����������ĸ���
6����������ĵ�һ���������
7���ж������Ƿ��л�
8���������ĳ���
9�������л�����ڽ��
10��ɾ���������ظ��ĵĽ��
*/

public class MergeLinkedList {

	// 1.1 ��β��ͷ��ӡ���� ʹ��Arrayistʵ��
	public void reversePrint(Node node) {
		ArrayList<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.data);
			node = node.next;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}

	// 1.2 ��β��ͷ��ӡ���� ʹ��Stackʵ��
	/*
	 * ��β��ͷ��ӡ������Ҳ���ǵ�һ��������һ����ӡ�����һ������һ����ӡ�����ǵ��͵ġ�����ȳ����������뵽����ʹ��һ������ջ���Ƚ����н�����η���ջ�У�
	 * Ȼ�����ջʵ�ַ�ת��ӡ��
	 */
	// ����Ƚϳ�ʱ��ʹ��ջ�ȽϺ� ³���Ժô��Ƚϸ�
	public void reversePrintByStack(Node head) {
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		Node current = head;
		while (current != null) {
			stack.push(current);
			current = current.next;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}
	}
	// 3.�����е�����k�����

	// 4.1 ��ת����I
	public Node reverseLiseNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		} else {
			Node pre = head;
			Node p = head.next;
			Node next = null;
			while (p != null) {
				next = p.next;
				p.next = pre;
				pre = p;
				p = next;
			}
			head.next = null;
			return pre;
		}

	}

	// 4.2 ��ת���� II
	/*
	 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
	 * 
	 * ˵��: 1 �� m �� n �� �����ȡ�
	 * 
	 * ʾ��:
	 * 
	 * ����: 1->2->3->4->5->NULL, m = 2, n = 4 ���: 1->4->3->2->5->NULL
	 */
	public Node reverseListNode2(Node node ,int m ,int n) {
		
		return null;
	}
	// 5.�ǵݹ�ϲ�������������
	public Node merge(Node n1, Node n2) {
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		Node currnet = new Node(-1); // ����һ����ǰ��ָ��
		Node root = currnet;
		while (n1 != null && n2 != null) {
			if (n2.data > n1.data) {
				currnet.next = n1; // ��һ�������ֵ�ŵ��ϲ����������һ��λ��
				currnet = n1;
				n1 = n1.next;
			} else {
				currnet.next = n2;
				currnet = n2;
				n2 = n2.next;
			}
		}
		if (n1 != null) {
			currnet.next = n1;
		}
		if (n2 != null) {
			currnet.next = n2;
		}

		return root.next;// ����ʱ��ʼ��һ��ֵ ���Է���root����һһ��ֵ
	}

	// ˳���ӡ����
	public void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	// ɾ���ڵ� ʱ�临�Ӷ�ΪO(N)
	public void deleteNode(int index, Node p) {
		int i = 1;
		while (i != (index - 1)) {
			p = p.next;
			i++;
		}
		(p.next) = (p.next.next);

	}

	// 7 �ж�һ�������Ƿ��л�
	public boolean hasLoop(Node head) {
		Node first = head;
		Node second = head;

		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
			if (first == second) {
				return true;
			}
		}
		return false;
	}

	/* ��Ŀ��һ�������а����������ҳ�������Ļ�����ڽ�㡣����ָoffer����56�⣩ */

	// ɾ���ظ��Ľڵ�
	/*
	 * ��Ŀ����һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬 �ظ��Ľ�㲻��������������ͷָ�롣 ��
	 * �磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5 ������ָoffer����57�⣩
	 */
	public Node deleteDuplication(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node current = head;
		if (current.data != current.next.data) {
			current.next = deleteDuplication(current.next);
			return current;

		} else {
			int val = current.data;
			while (current.data == val) {
				current = current.next;
				if (current == null)
					return null;
			}
			return deleteDuplication(current);
		}
	}

	public static void main(String[] args) {
		MergeLinkedList m = new MergeLinkedList();

		Node n11 = new Node(1);
		Node n12 = new Node(2);
		Node n13 = new Node(5);
		Node n14 = new Node(7);
		Node n15 = new Node(9);

		Node n21 = new Node(3);
		Node n22 = new Node(4);
		Node n23 = new Node(6);
		Node n24 = new Node(8);
		Node n25 = new Node(10);

		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;

		m.print(n11);

		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;

		m.print(n21);

		Node n4 = m.merge(n11, n21);
		m.print(n4);
		// m.deleteNode(8, n4);
		// m.print(m.deleteDuplication(n4));
		System.out.println(m.hasLoop(n4));
		// m.printNixu(m.merge(n11, n21));
	}

}
