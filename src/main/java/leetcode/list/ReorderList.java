package leetcode.list;

/**
 * Created by xiaozl on 2016/10/12.
 */
public class ReorderList {

    public static void main(String[] args) {
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
//        node7.next = node8;
        ReorderList z = new ReorderList();
        z.reorderList(node1);
    }

    /**
     *  Reorder List
     *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

     You must do this in-place without altering the nodes' values.

     For example,
     Given {1,2,3,4}, reorder it to {1,4,2,3}.
     * @param head
     */
    public  void reorderList(ListNode head) {
        if (head == null
                || head.next ==null){
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null
                && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        fast = reverse(fast);
        slow.next = null;
        mergerTowList(head,fast);
    }

    /**
     * 依次合并两个表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergerTowList(ListNode l1,ListNode l2){
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
        l3.next = l1;
        ListNode currentL1Next = l1.next;
        ListNode currentL2Next = l2.next;
        // flag使得合并可以交替进行
        int flag = 1;
        while (l2 != null){
            if (flag%2 != 0){
                l1.next = l2;
                l1 = currentL1Next;
                if (currentL1Next != null){
                    currentL1Next = currentL1Next.next;
                }
            } else {
                l2.next = l1;
                l2 = currentL2Next;
                if (currentL2Next != null){
                    currentL2Next = currentL2Next.next;
                }
            }
            flag++;
        }
        return l3.next;
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

}
