/*
Sort a linked list in O(n log n) time
using constant space complexity.
*/

package a0148_SortList;

public class Solution {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode sorted1 = sortList(head);
        ListNode sorted2 = sortList(head2);
        return merge(sorted1, sorted2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode result = new ListNode(0);
        ListNode trace = result;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                trace.next = n1;
                n1 = n1.next;
            } else {
                trace.next = n2;
                n2 = n2.next;
            }
            trace = trace.next;
        }
        if (n1 == null) {
            trace.next = n2;
        } else {
            trace.next = n1;
        }
        return result.next;
    }

}
