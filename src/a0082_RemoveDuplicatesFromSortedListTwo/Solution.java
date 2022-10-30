/*
Given a sorted linked list,
delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

package a0082_RemoveDuplicatesFromSortedListTwo;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode slow = result, fast = head;
        while (fast != null) {
            while (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }
            if (fast == slow.next) {
                slow = slow.next;
            } else {
                slow.next = fast.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return result.next;
    }

}
