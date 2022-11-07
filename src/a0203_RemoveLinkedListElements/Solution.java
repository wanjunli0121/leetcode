/*
Remove all elements from a linked list of integers that have value val.
Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

package a0203_RemoveLinkedListElements;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode trace = result;
        while (trace.next != null) {
            if (trace.next.val == val) {
                trace.next = trace.next.next;
            } else {
                trace = trace.next;
            }
        }
        return result.next;
    }

}
