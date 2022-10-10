/*
Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.
*/

package a0109_ConvertSortedListToBinarySearchTree;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode slow = node, fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(head2.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(head2.next);
        return root;
    }

}
