package leetcode.list;

import java.util.List;

/**
 * ReverseLinkedList
 *
 * @author xiaozl
 * @date: 2016/6/12
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode m = new ListNode(0);
        ListNode p = m;

        for (int i = 1; i <10 ; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }

        reverseBetween(m,3,6);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n || head == null || head.next == null){
            return head;
        }

        ListNode tempList = new ListNode(0);
        tempList.next = head;

        ListNode prior = tempList;

        for (int i = 1; i < m ; i++) {
            prior = prior.next;
        }

        ListNode pm = prior.next;
        ListNode temp = pm.next;
        ListNode tempPrior = pm;
        ListNode tempNext = temp;
        for (int i = m; i < n ; i++) {
            temp = tempNext;
            tempNext = temp.next;
            temp.next = prior.next;
            prior.next = temp;
            tempPrior.next = tempNext;
        }
        return tempList.next;
    }
}
