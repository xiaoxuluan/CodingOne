package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/14 19:25
 * @Version 1.0
 */
public class Leetcode148 {
    /**
     * ��?O(n?log?n) ʱ�临�ӶȺͳ������ռ临�Ӷ��£��������������
     *
     * ʾ�� 1:
     *
     * ����: 4->2->1->3
     * ���: 1->2->3->4
     * ʾ�� 2:
     *
     * ����: -1->5->3->4->0
     * ���: -1->0->3->4->5
     *
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next,slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode result = h;
        while (left != null && right != null){
            if(left.val<right.val){
                h.next= left;
                left = left.next;
            }else {
                h.next=right;
                right = right.next;
            }
            h=h.next;
        }
        h.next = left !=null ? left:right;
        return result.next;
    }
}
