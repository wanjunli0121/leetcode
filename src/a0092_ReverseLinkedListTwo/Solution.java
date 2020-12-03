/*
Reverse a linked list from position m to n.
Do it in one-pass.
Note: 1 ≤ m ≤ n ≤ length of list.
Example:
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/

package a0092_ReverseLinkedListTwo;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode node = pre.next;
        ListNode nextNode = node.next;
        for (int i = 0; i < n - m; i++) {
            node.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
            nextNode = node.next;
        }
        return result.next;
    }

}
