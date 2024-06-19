/*
Sort a linked list using insertion sort.
*/

package a0147_InsertionSortList;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode pre = result;
            while (pre.next != null && head.val > pre.next.val) {
                pre = pre.next;
            }
            ListNode nextNode = head.next;
            head.next = pre.next;
            pre.next = head;
            head = nextNode;
        }
        return result.next;
    }

}
