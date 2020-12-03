/*
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.
Note: Do not modify the linked list.
Follow up:
Can you solve it without using extra space?
*/

package a0142_LinkedListCycleTwo;

public class Solution {

    // When slow enters the loop after k steps, fast is k steps into the loop.
    // Fast and slow are loop_size - k steps away from each other.
    // Fast and slow meet after loop_size - k steps.
    // Now slow is k steps from the front of the loop.
    // It takes k steps for trace to enter the loop from the head.
    // After k steps, slow and trace will meet at the front of the loop.
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode trace = head;
                while (trace != slow) {
                    trace = trace.next;
                    slow = slow.next;
                }
                return trace;
            }
        }
        return null;
    }

}
