package leetcode.list;

/**
 * Created by xiaozl on 2016/10/11.
 */
public class DeleteDuplicate {

    /**
     * 删除了所有重复出现过的元素
     * Remove Duplicates from Sorted List II
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.

     Subscribe to see which companies asked this question
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode pre = new ListNode(0);
        int dup = 1;
        pre.next = head;
        while (second != null) {
            if (first.val == second.val) {
                dup++;
                first = second;
                second = second.next;
            } else {
                if (dup > 1) {
                    if (first.val == head.val){
                        head = second;
                    }
                    pre.next = second;
                    first = second;
                    second = second.next;
                    dup = 1;
                } else {
                    pre = first;
                    first = second;
                    second = second.next;
                }
            }
        }
        if (dup > 1){
            pre.next = null;
        }
        if (head.next != null){
            if(head.val == head.next.val){
                return null;
            }
        }
        return head;
    }
}
