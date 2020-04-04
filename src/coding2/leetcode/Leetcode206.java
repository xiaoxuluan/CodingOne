package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/23 13:39
 * @Version 1.0
 */
public class Leetcode206 {

    //1-->2-->3-->null;
    //null<--1<--2<--3;

    public static ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            ListNode nextTemp = current.next;
            current.next = pre;
            pre = current;
            current = nextTemp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.val=1;
        head.next = new ListNode(2);
        head.next.val=2;
        head.next.next = new ListNode(3);
        head.next.next.val=3;

        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }

        System.out.println();
        reverseListNode(head);

        System.out.println(head.next.val);

    }

}
