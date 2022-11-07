/*
Sort a linked list using insertion sort.
*/

package a0147_InsertionSortList;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (head != null) {
            while (pre.next != null && head.val > pre.next.val) {
                pre = pre.next;
            }
            ListNode t = head;
            head = head.next;
            t.next = pre.next;
            pre.next = t;
            pre = result;
        }
        return result.next;
    }

}
