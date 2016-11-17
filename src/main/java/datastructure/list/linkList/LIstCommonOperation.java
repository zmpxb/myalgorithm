package datastructure.list.linkList;

import leetcode.list.ListNode;

/**
 * Created by xiaozl on 2016/10/15.
 */
public class ListCommonOperation {


    public static int size(ListNode head){
        if (head == null){
            return 0;
        }
        ListNode current = head;
        int size = 0;
        while (current != null){
            size ++;
            current = current.next;
        }
        return size;
    }

}
