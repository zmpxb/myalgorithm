package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/10.
 */
public class MergeSortedList {

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

        ListNode g = new ListNode(1);
        ListNode q = g;

        for (int i = 1; i <10 ; i++) {
            ListNode node = new ListNode(i);
            q.next = node;
            q = node;
        }
        q = g;
        while (q != null){
            System.out.println(q.val);
            q = q.next;
        }

        mergeTwoLists(m,g);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null && l2 != null){
            return l2;
        }
        if (l1 != null && l2 == null){
            return l1;
        }

        ListNode l3 ;
        if (l1.val > l2.val){
            l3 = l2;
            l2 = l2.next;
        } else {
            l3 = l1;
            l1 = l1.next;
        }
        ListNode p = l3 ;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                p.next = l2;
                p = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                p = l1;
                l1= l1.next;
            }
        }
        if (l1 != null){
            p.next = l1;
        } else if (l2 != null){
            p.next = l2;
        }
        return l3;
    }

    /**
     * 合并两个有序链表
     * Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * @param l1
     * @param l2
     * @return
     */
    public  ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null && l2 != null){
            return l2;
        }
        if (l1 != null && l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode p;
        p = l3;
        while (l1!=null && l2!=null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null){
            p.next = l1;
        }
        if (l2 != null){
            p.next = l2;
        }
        return l3.next;
    }

    /**
     * 合并多个链表，两两合并注意时间复杂度
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        int n = lists.length;
        while (n>1){
            int k = (n+1)/2;
            for (int i = 0; i < n/2; i++) {
                lists[i] = mergeTwoLists1(lists[i],lists[i+k]);
            }
            n = k;
        }

        return lists[0];
    }
}
