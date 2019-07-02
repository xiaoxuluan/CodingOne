package coding.offer;

public class Fuzalianbiaofuzhi {

	// ����ṹ
	public static class ComplexListNode {
		int value;
		ComplexListNode next;
		ComplexListNode random;
	}

	// ����������
	public static ComplexListNode clone(ComplexListNode head) {
		if (head == null) {
			return null;
		}
		// ���ƽڵ�
		cloneNodes(head);
		// ���ӽڵ� ���¸��ƵĽڵ����ӵ�ԭ��������ڵ�ĺ���
		connectNodes(head);
		// �����ƵĽڵ�� �ع�����
		return reconnectNodes(head);
	}

	// ���ƽڵ�
	private static void cloneNodes(ComplexListNode head) {
		// TODO Auto-generated method stub

		while (head != null) {
			ComplexListNode tmp = new ComplexListNode();
			//value+100 Ϊ�˷������� ͷ��㸴�Ƴ���һ���µĽڵ�
			//����ֵ
			tmp.value = head.value + 100;
			//������һ��ָ��
			tmp.next = head.next;
			//ԭ���ڵ����һ��ָ���ƺ�Ľڵ�
			head.next = tmp;
			//headָ��ԭ������ĵ�2���ڵ�
			head = tmp.next;
		}

	}

	//������������ָ��
	private static void connectNodes(ComplexListNode head) {
		// TODO Auto-generated method stub
		while (head != null) {
			if (head.random != null) {
				//���ƽڵ������ָ��ָ������ֵ����һ���ڵ�
				head.next.random = head.random.next;
			}
			//headָ��ԭ������ĵڶ����ڵ�
			head = head.next.next;
		}
	}
	
	//���½⹹����
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
