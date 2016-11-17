package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/10/12.
 */
public class RotateList {

    public static void main(String[] args) {
       /* ListNode head = new ListNode(0);
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
        node8.next = node3;*/
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode n = rotateRight(node1,2000000000);
        System.out.println(2000000000);
    }

    /**
     * 向右移动k个元素，后面的元素重新插入表头
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null
                || head.next == null
                || k <= 0){
            return head;
        }
        // 统计链表中元素的个数
        int count = 0;
        ListNode countNode = head;
        while (countNode!=null){
            count++;
            countNode = countNode.next;
        }
        int start = 0;
        if (k%count==0){
            return head;
        }
        if (count > k){
            start = count - k + 1;
        } else {
            start = count - k%count + 1;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode currentNext = null;
        ListNode current = head;
        ListNode pre = newHead;
        for (int i = 1; i < start; i++) {
            pre = current;
            current = current.next;
        }
        currentNext = current.next;

        int tmp = 1;
        ListNode currentPre = pre;
        // 尾插法
        while (current != null){
            if (tmp == 1){
                current.next = newHead.next;
                newHead.next = current;
            } else {
                current.next = currentPre.next;
                currentPre.next = current;
            }
            currentPre = current;
            current = currentNext;
            if (currentNext!=null){
                currentNext = currentNext.next;
            }
            tmp++;
        }
        if (pre != newHead) {
            pre.next = null;
        }
        return newHead.next;
    }

}
