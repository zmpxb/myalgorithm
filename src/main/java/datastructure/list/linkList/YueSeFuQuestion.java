package datastructure.list.linkList;

import leetcode.list.ListNode;

import java.util.List;

/**
 * Created by xiaozl on 2016/10/13.
 */
public class YueSeFuQuestion {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode current = null;
        ListNode pre = node1;
        for (int i = 1; i <= 41; i++) {
            current = new ListNode(i);
            pre.next = current;
            pre = current;
        }
        current.next = node1.next;
        ListNode head = node1.next;
        current = node1.next;
        int count = 1;
        while (current!=null && listSize(head) >= 3){

            if (count%3 == 0){
                System.out.println(current.val);
                current = current.next;
                head = delEleInCycleList(head,current.val);
                count=0;
            } else {
                current = current.next;
                count++;
            }
            if (listSize(head) < 3){
                break;
            }
        }

        System.out.println("xiao");
    }

    public static int listSize(ListNode head){
        if (head == null){
            return 0;
        }
        ListNode current = head;
        if (head.next == head){
            return 1;
        }
        int count = 0;
        while (current != head){
            count++;
            current = current.next;
        }
        return count;
    }

    public static ListNode delEleInCycleList(ListNode head,int elem){
        if (head == null){
            return head;
        }
        ListNode header = new ListNode(0);
        ListNode pre = header;
        ListNode current = head;
        if (head.next == head
                && head.val == elem){
            return null;
        }
        boolean flag = false;
        while (current != null){
            if (current.val != elem){
                pre = current;
                current = current.next;
            } else {
                flag = true;
                pre.next = current.next;
                break;
            }
        }
        if (!flag){
            return head;
        }
        return head;
    }


}
