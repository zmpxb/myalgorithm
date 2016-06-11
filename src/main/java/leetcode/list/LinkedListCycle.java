package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/9.
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode p = head.next;
        while (p != null){
            if (p == head){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

}
