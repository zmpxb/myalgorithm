package leetcode.list;

import java.util.List;


/**
 * Created by xiaozl on 2016/6/9.
 */




public class LinkedListCycle {



    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        System.out.println(detectCycle(head).val);

    }

    /**
     *  Linked List Cycle
     *  Given a linked list, determine if it has a cycle in it.

         Follow up:
         Can you solve it without using extra space?
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
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

    /**
     * Linked List Cycle II
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

         Note: Do not modify the linked list.

       Follow up:
         Can you solve it without using extra space?
     计算出循环体内元素的个数，然后从表头开始，计数，表头到循环开始节点的距离最短
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = null;
        int numInCycle = 0;
        int max = 0;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            max++;
            if (slow == fast){
                tmp = fast.next;
                numInCycle++;
                while (tmp != slow){
                    numInCycle++;
                    tmp = tmp.next;
                }
                break;
            }
        }
        int count = 0;
        max = max*3;
        int min = max;
        if (numInCycle != 0){
            ListNode first = head;
            for (int i = 0; i < numInCycle; i++) {
                while (first != slow){
                    first = first.next;
                    count++;
                }
                if (count < min){
                    min = count;
                }
                count = 0;
                first = head;
                slow = slow.next;
            }
            for (int i = 0; i < min; i++) {
                first = first.next;
            }
            return first;
        }
        return null;
    }

}
