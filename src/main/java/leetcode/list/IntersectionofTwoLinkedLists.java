package leetcode.list;

import java.util.List;

/**
 * Intersection of Two Linked Lists
 * 求两条链表有一个交点
 * A:          a1 → a2
                        ↘
                           c1 → c2 → c3
                        ↗
   B:     b1 → b2 → b3
 * Created by xiaozl on 2016/10/15.
 */
public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode A = head;
        head.next = node2;
        ListNode B = node1;
        node1.next = node2;
        IntersectionofTwoLinkedLists obj = new IntersectionofTwoLinkedLists();

        ListNode in = obj.getIntersectionNode(A,B);
        System.out.println("xiao");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode headA1 = headA;
        ListNode tailA = headA;
        while (tailA.next != null){
            tailA = tailA.next;
        }
        tailA.next = headA;
        ListNode intersectionNode = detectCycle(headB);
        tailA.next = null;
        return intersectionNode;
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode  fast = head;
        ListNode  slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = head;
                while(slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
   

}
