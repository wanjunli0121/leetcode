/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes,
only nodes itself may be changed.
Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

package a0143_ReorderList;

public class Solution {

    public void reorderList(ListNode head) {

        // Find the middle position.
        if (head == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        slow = slow.next;
        middle.next = null;

        // Reverse the second half.
        ListNode pre = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nextNode;
        }

        // Merge the two halves.
        ListNode trace = head;
        while (pre != null) {
            ListNode t = trace;
            trace = trace.next;
            t.next = pre;
            pre = pre.next;
            t.next.next = trace;
        }

    }

}
