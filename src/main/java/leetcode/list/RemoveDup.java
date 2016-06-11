package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/10.
 */
public class RemoveDup {

    public static void main(String[] args) {
        ListNode m = new ListNode(1);
        ListNode p = m;

        for (int i = 1; i <10 ; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        p = m;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }

        ListNode head = deleteDuplicates(m);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        while (second != null){
            if (first.val == second.val){
                first.next = second.next;
            } else {
                first = second;
            }
            second = second.next;
        }
        return head;
    }
}
