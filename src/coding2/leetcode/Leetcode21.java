package coding2.leetcode;

/**
 * @Author: luanyanxu
 * @Date: 2020/4/4 10:19
 * @Version 1.0
 */
public class Leetcode21 {

    //µÝ¹é
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }

        else if (l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

    //2.µü´ú

    public ListNode merger1(ListNode listNode1,ListNode listNode2){
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (listNode1 != null && listNode2!= null){
            if(listNode1.val < listNode2.val){
                prev.next = listNode1;
                listNode1 = listNode1.next;
            }else {
                prev.next = listNode2;
                listNode2 = listNode2.next;
            }

            prev = prev.next;
        }
        prev.next = listNode1 == null ? listNode2:listNode1;
        return prehead.next;
    }


}
