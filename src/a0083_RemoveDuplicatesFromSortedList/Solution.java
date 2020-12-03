/*
Given a sorted linked list,
delete all duplicates such that each element appear only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

package a0083_RemoveDuplicatesFromSortedList;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode trace = head;
        while (trace.next != null) {
            if (trace.next.val == trace.val) {
                trace.next = trace.next.next;
            } else {
                trace = trace.next;
            }
        }
        return head;
    }

}
