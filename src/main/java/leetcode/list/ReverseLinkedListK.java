package leetcode.list;

/**
 * ReverseLinkedList
 *
 * @author xiaozl
 * @date: 2016/6/12
 */
public class ReverseLinkedListK {

    public static void main(String[] args) {
        ListNode m = new ListNode(1);
        ListNode p = m;

        for (int i = 2; i <=10 ; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }

        // reverseBetween(m,1,2);
        reverseKGroup(m,3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        if (k == 1 || head == null || head.next == null){
            return head;
        }
        ListNode tmp = head;
        while (tmp != null){
            length++;
            tmp = tmp.next;
        }
        if (k > length){
            return head;
        }

        int n = length / k;
        int m = length % k;

        for (int i = 1,j = 1; i <= n;i++) {
            head = reverseBetween(head,j,j+k-1);
            j = j + k;
        }
        return head;
    }

    public static ListNode reverseBetween(ListNode head1, int m, int n) {

        if (m == n || head1 == null || head1.next == null){
            return head1;
        }

        ListNode tempList = new ListNode(0);
        tempList.next = head1;

        ListNode prior = tempList;

        for (int i = 1; i < m ; i++) {
            prior = prior.next;
        }

        ListNode pm = prior.next;
        ListNode temp = pm.next;
        ListNode tempPrior = pm;
        ListNode tempNext = temp;
        for (int i = m; i < n ; i++) {
            temp = tempNext;
            tempNext = temp.next;
            temp.next = prior.next;
            prior.next = temp;
            tempPrior.next = tempNext;
        }
        return tempList.next;
    }
}
