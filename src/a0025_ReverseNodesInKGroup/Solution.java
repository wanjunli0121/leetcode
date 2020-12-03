/*
Given a linked list,
reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k
then left-out nodes in the end should remain as it is.
Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes,
only nodes itself may be changed.
*/

package a0025_ReverseNodesInKGroup;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode trace = head;

        // See if there are at least k nodes left in the linked list.
        while (count < k && trace != null) {
            trace = trace.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverseLinkedList(head, k);
            head.next = reverseKGroup(trace, k);
            return reversedHead;
        }
        return head;
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode previous = null;
        for (int i = k; i > 0; i--) {
            ListNode nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }
        return previous;
    }

}
