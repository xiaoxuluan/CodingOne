package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2020/3/26 12:32
 * @Version 1.0
 */
public class Leetcode203 {

    public ListNode removeElements(ListNode head,int val){
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode current = header;
        while (current.next != null){
            if(current.next.val ==val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return header.next;

    }
}
