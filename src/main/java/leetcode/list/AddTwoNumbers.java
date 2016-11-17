package leetcode.list;

import java.math.BigInteger;

/**
 * Created by xiaozl on 2016/10/12.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        BigInteger d3 = new BigInteger("10");
        System.out.println(d3.toString());
    }

    /**
     * 会超时
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode c1 = l1;
        ListNode c2 = l2;


        BigInteger d1 = new BigInteger("0");
        BigInteger d2 = new BigInteger("0");
        BigInteger d3 = new BigInteger("10");
        while (c1 != null){
            d1 = d1.multiply(d3).add(new BigInteger(new Integer(c1.val).toString()));
            c1 = c1.next;
        }
        while (c2 != null){
            d2 = d2.multiply(d3).add(new BigInteger(new Integer(c2.val).toString()));
            c2 = c2.next;
        }
        BigInteger sum = d1.add(d2);

        String sumStr = sum.toString();
        ListNode header = new ListNode(0);
        header.next = null;
        for (int i = 0; i < sumStr.length(); i++) {
            ListNode current = new ListNode(sumStr.charAt(i) - 48);
            current.next = header.next;
            header.next = current;
        }
        return header.next;
    }

    /**
     * 翻转链表,使用头插法
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        if (head == null
                || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode current = head;
        ListNode currentNext = current.next;
        int count = 1;
        // 对第一节点单独处理
        while (current != null){
            if (count == 1){
                current.next = null;
            } else {
                current.next = newHead.next;
            }
            newHead.next = current;
            current = currentNext;
            if (currentNext != null){
                currentNext = currentNext.next;
            }
            count++;
        }
        return newHead.next;
    }

    /**
     *  Add Two Numbers
     *  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        int carry = 0;
        ListNode newhead = new ListNode(-1);
        ListNode l3 = newhead;

        while(l1!=null || l2!=null){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode(carry%10);
            carry = carry/10;
            l3 = l3.next;
        }
        if(carry == 1)
            l3.next=new ListNode(1);
        return newhead.next;
    }

}
