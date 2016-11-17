package leetcode.list;

import java.util.List;

/**
 * ReverseLinkedList
 *
 * @author xiaozl
 * @date: 2016/6/12
/**
 * Created by xiaozl on 2016/6/11.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
//        ListNode m = new ListNode(0);
//        ListNode p = m;
//
//        for (int i = 1; i <10 ; i++) {
//            ListNode node = new ListNode(i);
//            p.next = node;
//            p = node;
//        }
//
//        reverseBetween(m,3,6);


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
        ListNode node = reverseKGroup(head,2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }



    /**
     * 对于链表head 每k个元素内部进行一次翻转
     * 计算出链表中元素的总个数，计算出翻转的次数，让后利用reverseBetween1进行翻转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }
        ListNode pre = head;
        ListNode now = head;
        int n = 1, m = 1;
        int count = 0;
        while (now != null){
            count++;
            now = now.next;
        }
        for (int i = 1; i <= count/k; i++) {
            n = i * k;
            head = reverseBetween1(head,m,n);
            m = n + 1;
        }
        return head;
    }

    /**
     * Reverse Linked List II
     * 翻转链表中m-n之间的元素
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween1(ListNode head, int m, int n) {

        if (m == n || head == null || head.next == null){
            return head;
        }
        ListNode tempList = new ListNode(0);
        tempList.next = head;
        ListNode prior = tempList;

        for (int i = 1; i < m ; i++) {
            prior = prior.next;
        }

        ListNode nNode = tempList;
        for (int i = 0; i < n; i++) {
            nNode = nNode.next;
        }
        // 使用头插法倒叙链表
        ListNode pm = prior.next;
        ListNode pmNext = pm.next;
        prior.next = nNode.next;
        for (int i = m; i <= n ; i++) {
            pm.next = prior.next;
            prior.next = pm;
            pm = pmNext;
            if (pmNext!=null) {
                pmNext = pmNext.next;
            }
        }
        return tempList.next;
    }

}
