package coding.LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/*链表中常见的面试题
1、从尾到头打印单链表
2、在O(1)时间删除链表结点
3、链表中倒数第k个结点
4、反转链表
5、合并两个有序链表
6、复杂链表的复制
6、两个链表的第一个公共结点
7、判断链表是否有环
8、求链表环的长度
9、链表中环的入口结点
10、删除链表中重复的的结点
*/

public class MergeLinkedList {

	// 1.1 从尾到头打印链表 使用Arrayist实现
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

	// 1.2 从尾到头打印链表 使用Stack实现
	/*
	 * 从尾到头打印单链表，也就是第一个结点最后一个打印，最后一个结点第一个打印，这是典型的「后进先出」。首先想到的是使用一个辅助栈，先将所有结点依次放入栈中，
	 * 然后遍历栈实现反转打印。
	 */
	// 链表比较长时，使用栈比较好 鲁棒性好处比较高
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
	// 3.链表中倒数第k个结点

	// 4.1 反转链表I
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

	// 4.2 反转链表 II
	/*
	 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
	 * 
	 * 说明: 1 ≤ m ≤ n ≤ 链表长度。
	 * 
	 * 示例:
	 * 
	 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4 输出: 1->4->3->2->5->NULL
	 */
	public Node reverseListNode2(Node node ,int m ,int n) {
		
		return null;
	}
	// 5.非递归合并两个有序链表
	public Node merge(Node n1, Node n2) {
		if (n1 == null) {
			return n2;
		}
		if (n2 == null) {
			return n1;
		}
		Node currnet = new Node(-1); // 创建一个当前的指针
		Node root = currnet;
		while (n1 != null && n2 != null) {
			if (n2.data > n1.data) {
				currnet.next = n1; // 第一个链表的值放到合并后链表的下一个位置
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

		return root.next;// 创建时初始化一个值 所以返回root的下一一个值
	}

	// 顺序打印链表
	public void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	// 删除节点 时间复杂度为O(N)
	public void deleteNode(int index, Node p) {
		int i = 1;
		while (i != (index - 1)) {
			p = p.next;
			i++;
		}
		(p.next) = (p.next.next);

	}

	// 7 判断一个链表是否有环
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

	/* 题目：一个链表中包含环，请找出该链表的环的入口结点。（剑指offer，第56题） */

	// 删除重复的节点
	/*
	 * 题目：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点， 重复的结点不保留，返回链表头指针。 例
	 * 如，链表1->2->3->3->4->4->5 处理后为 1->2->5 。（剑指offer，第57题）
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
