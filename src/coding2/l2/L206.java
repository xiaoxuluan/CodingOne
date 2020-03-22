package coding2.l2;


/**
 * @Author: luanyanxu
 * @Date: 2020/3/21 16:36
 * @Version 1.0
 */
public class L206 {

    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next=new ListNode(1);
        head.next.val = 1;
        head.next.next = new ListNode(2);
        head.next.next.val=2;
        head.next.next.next = null;

        while (head!= null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
