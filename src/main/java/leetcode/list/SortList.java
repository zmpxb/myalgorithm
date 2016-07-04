package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/22.
 */
public class SortList {

    public static void main(String[] args) {
        ListNode m = new ListNode(0);
        ListNode p = m;

        for (int i = 10; i>0 ; i--) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        SortList.sortList(m);
        System.out.println("xiao");
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        // 快慢指针得到中间点
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 将链表拆成两部分
        fast = slow.next;
        slow.next = null;

        // 左右连边分布排序
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(fast);

        // 合并
        return MergeSortedList.mergeTwoLists(p1, p2);
    }



}
