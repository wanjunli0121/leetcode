/*
Given a singly linked list, determine if it is a palindrome.
Follow up:
Could you do it in O(n) time and O(1) space?
*/

package a0234_PalindromeLinkedList;

public class Solution {

    // Reverse the first half and compare to the second half.
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode previous = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            head.next = previous;
            previous = head;
            head = slow;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (previous.val != slow.val) {
                return false;
            }
            previous = previous.next;
            slow = slow.next;
        }
        return true;
    }

//	Method 2:
//	public boolean isPalindrome(ListNode head) {
//      ListNode fast = head, slow = head;
//      while (fast != null && fast.next != null) {
//          fast = fast.next.next;
//          slow = slow.next;
//      }
//      if (fast != null) {
//          slow = slow.next;
//      }
//    	slow = reverseList(slow);
//    	while (slow != null) {
//    		if (head.val != slow.val) {
//    			return false;
//    		}
//    		head = head.next;
//    		slow = slow.next;
//    	}
//    	return true;
//  }
//
//  private ListNode reverseList(ListNode head) {
//      ListNode previous = null;
//      while (head != null) {
//        	ListNode nextNode = head.next;
//        	head.next = previous;
//        	previous = head;
//        	head = nextNode;
//      }
//      return previous;
//  }

}
