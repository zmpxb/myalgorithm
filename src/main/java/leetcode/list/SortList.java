package leetcode.list;

import java.util.List;

/**
 * Created by xiaozl on 2016/6/22.
 */
public class SortList {

    public static void main(String[] args) {
        ListNode m = new ListNode(11);
        ListNode p = m;

        for (int i = 10; i>0 ; i--) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        insertionSortList(m);

        System.out.println("xiao");
    }

    /**
     * 排序两个链表时间复杂度为nlogn.
     * 用归并排序
     * @param head
     * @return
     */
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

    /**
     * 使用插入排序，排序链表中的元素
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode countNode = head;
        while (countNode!=null){
            count++;
            countNode = countNode.next;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = head;
        ListNode now = head.next;

        int del = 3;
        int ist = 2;

        for (int i = 1; i < count; i++) {
            while (now.val > pre.val && pre != now){
                pre =  pre.next;
                ist++;
            }
            if (pre == now){
                pre = newHead.next;
                now = now.next;
                del++;
                ist = 2;
            } else {
                now = now.next;
                ListNode deleteNode = delete(del,newHead);
                insert(ist,deleteNode,newHead);
                ist = 2;
                del++;
                pre = newHead.next;
            }
        }
        return newHead.next;
    }


    public static ListNode insert(int index, ListNode newNode,ListNode head) {
        // 将要插入的值封装成一个节点。
        ListNode p = head;
        ListNode pre = null;
        if (index == 1){
            newNode.next = head;
            return newNode;
        }
        for (int i = 1; i < index; i++) {
            pre = p;
            p = p.next;
        }
        newNode.next = p;
        pre.next = newNode;
        // 表尾插入元素时特殊处理
        return head;
    }

    public static ListNode delete(int index,ListNode head) {
        ListNode curNode = head;
        ListNode preNode = null;
        for (int i = 1; i < index; i++) {
            preNode = curNode;
            curNode = curNode.next;
        }
        preNode.next = curNode.next;
        return curNode;
    }

}
