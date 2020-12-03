/*
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
*/

package a0021_MergeTwoSortedLists;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode trace = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                trace.next = l1;
                l1 = l1.next;
            } else {
                trace.next = l2;
                l2 = l2.next;
            }
            trace = trace.next;
        }
        if (l1 == null) {
            trace.next = l2;
        } else {
            trace.next = l1;
        }
        return result.next;
    }

//	Method 2:
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//		if (l1 == null) {
//			return l2;
//		}
//		if (l2 == null) {
//			return l1;
//		}
//		if (l1.val <= l2.val) {
//			l1.next = mergeTwoLists(l1.next, l2);
//			return l1;
//		} else {
//			l2.next = mergeTwoLists(l2.next, l1);
//			return l2;
//		}
//	}

}
