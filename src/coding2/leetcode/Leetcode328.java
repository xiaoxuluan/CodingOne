package coding2.leetcode;

/**
 * @author alenlyx
 */
public class Leetcode328 {

    public ListNode oddEventList(ListNode head){
        if(head == null || head.next == null || head.next.next ==null){
            return head;
        }

        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even  = new ListNode(-1);
        ListNode evenHead = even;
        while (head != null && head.next != null){
            odd.next = head;
            even.next = head.next;
            odd = odd.next;
            even = even.next;
            head = head.next.next;
        }

        if(head != null){
            odd.next = head;
            odd = odd.next;
            even.next = null;
        }

        odd.next = evenHead.next;
        return oddHead.next;
    }
}
