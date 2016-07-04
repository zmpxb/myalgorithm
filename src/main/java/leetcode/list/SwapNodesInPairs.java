package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/20.
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode m = new ListNode(0);
        ListNode p = m;

        for (int i = 1; i <2 ; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        swapPairs(m);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = head.next.next;
        p.next = head;
        head = p;

        ListNode prior = head.next;
        ListNode tmp = head.next.next;
        ListNode tmpNext = null;
        if (tmp != null) {
            tmpNext = tmp.next;
        }
        while (tmp != null && tmpNext != null){
            tmp.next = tmp.next.next;
            tmpNext.next = tmp;
            prior.next = tmpNext;
            prior = tmp;
            tmp = tmp.next;
            if (tmp != null) {
                tmpNext = tmp.next;
            }
        }

        return head;
    }

}
