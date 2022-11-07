/*
Reverse a singly linked list.
*/

package a0206_ReverseLinkedList;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }
        return previous;
    }

}
