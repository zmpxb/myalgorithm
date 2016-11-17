package leetcode.list;

/**
 * Created by xiaozl on 2016/10/12.
 */
public class PartitionList {

    /**
     * Partition List
     * 把单链表的数据分割开，左边的数据小于x，右边的数据大于或等于x
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null
                || head.next == null){
            return head;
        }
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = l1;
        ListNode l4 = l2;

        ListNode p = head;
        while (p!=null){
            if (p.val<x){
                l1.next = p;
                l1 = l1.next;
            } else {
                l2.next = p;
                l2 = l2.next;
            }
            p = p.next;
        }
        l2.next = null;
        l1.next = l4.next;

        return l3.next;
    }

}
