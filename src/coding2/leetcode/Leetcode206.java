package coding2.leetcode;

/**
 * @Author: alenlyx
 * @Date: 2019/9/23 13:39
 * @Version 1.0
 */
public class Leetcode206 {

    public ListNode reverseListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
