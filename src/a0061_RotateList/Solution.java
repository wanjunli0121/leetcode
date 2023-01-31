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
        ListNode fast = head, slow = head;
        int size = 1;
        while (fast.next != null) {
            fast = fast.next;
            size++;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        for (int i = 0; i < size - k - 1; i++) {
            slow = slow.next;
        }
        ListNode nextNode = slow.next;
        slow.next = null;
        fast.next = head;
        return nextNode;
    }

}
