/*
Given a list, rotate the list to the right by k places,
where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

package a0061_RotateList;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode last = head;
        int size = 1;
        // last is the last node.
        while (last.next != null) {
            last = last.next;
            size++;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        ListNode trace = head;
        // trace becomes the last node.
        for (int i = 0; i < size - k - 1; i++) {
            trace = trace.next;
        }
        result.next = trace.next;
        last.next = head;
        trace.next = null;
        return result.next;
    }

}
