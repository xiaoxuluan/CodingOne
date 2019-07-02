package coding.offer;

public class Fuzalianbiaofuzhi {

	// 链表结构
	public static class ComplexListNode {
		int value;
		ComplexListNode next;
		ComplexListNode random;
	}

	// 复杂链表复制
	public static ComplexListNode clone(ComplexListNode head) {
		if (head == null) {
			return null;
		}
		// 复制节点
		cloneNodes(head);
		// 连接节点 将新复制的节点连接到原来就链表节点的后面
		connectNodes(head);
		// 将复制的节点拆开 重构链表
		return reconnectNodes(head);
	}

	// 复制节点
	private static void cloneNodes(ComplexListNode head) {
		// TODO Auto-generated method stub

		while (head != null) {
			ComplexListNode tmp = new ComplexListNode();
			//value+100 为了方便区分 头结点复制出来一个新的节点
			//复制值
			tmp.value = head.value + 100;
			//复制下一个指针
			tmp.next = head.next;
			//原来节点的下一个指向复制后的节点
			head.next = tmp;
			//head指向原来链表的第2个节点
			head = tmp.next;
		}

	}

	//复制随机区域的指向
	private static void connectNodes(ComplexListNode head) {
		// TODO Auto-generated method stub
		while (head != null) {
			if (head.random != null) {
				//复制节点的任意指针指向任意值得下一个节点
				head.next.random = head.random.next;
			}
			//head指向原来链表的第二个节点
			head = head.next.next;
		}
	}
	
	//重新解构链表
	private static ComplexListNode reconnectNodes(ComplexListNode head) {
		// TODO Auto-generated method stub

		if (head == null) {
			return null;
		}
		ComplexListNode newhead = head.next;
		ComplexListNode pointer = newhead;
		head.next = newhead.next;
		head = head.next;

		while (head != null) {
			pointer.next = head.next;
			pointer = pointer.next;
			head.next = pointer.next;
			head = pointer.next;
		}
		return newhead;
	}

	

}
