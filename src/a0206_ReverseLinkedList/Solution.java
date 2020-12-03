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

//	Method 2: Recursive.
//	public ListNode reverseList(ListNode head) {
//		return reverseList(head, null);
//	}
//
//	private ListNode reverseList(ListNode head, ListNode previous) {
//		if (head == null) {
//			return previous;
//		}
//		ListNode nextNode = head.next;
//		head.next = previous;
//		return reverseList(nextNode, head);
//	}

}
