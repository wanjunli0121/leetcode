/*
Given a linked list and a value x,
partition it such that all nodes less than x come before
nodes greater than or equal to x.
You should preserve the original relative order of the nodes
in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

package a0086_PartitionList;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode trace = head, smallTrace = smallHead, largeTrace = largeHead;
        while (trace != null) {
            if (trace.val < x) {
                smallTrace.next = trace;
                smallTrace = smallTrace.next;
            } else {
                largeTrace.next = trace;
                largeTrace = largeTrace.next;
            }
            trace = trace.next;
        }
        smallTrace.next = largeHead.next;
        largeTrace.next = null;
        return smallHead.next;
    }

}
