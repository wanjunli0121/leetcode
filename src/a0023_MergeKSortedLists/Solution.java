/*
Merge k sorted linked lists and return it as one sorted list.
Analyze and describe its complexity.
Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

package a0023_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode result = new ListNode(0);
        ListNode trace = result;
        for (ListNode node: lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            trace.next = queue.poll();
            trace = trace.next;
            if (trace.next != null) {
                queue.add(trace.next);
            }
        }
        return result.next;
    }

}
