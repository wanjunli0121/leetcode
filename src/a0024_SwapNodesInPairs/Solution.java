/*
Given a linked list,
swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space.
You may not modify the values in the list,
only nodes itself can be changed.
*/

package a0024_SwapNodesInPairs;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

//	  Method 2:
//    public ListNode swapPairs(ListNode head) {
//    	ListNode result = new ListNode(0);
//    	result.next = head;
//    	ListNode cur = result;
//    	while (cur.next != null && cur.next.next != null) {
//    		ListNode temp = cur.next.next;
//    		cur.next.next = temp.next;
//    		temp.next = cur.next;
//    		cur.next = temp;
//    		cur = temp.next;
//    	}
//    	return result.next;
//    }

}
