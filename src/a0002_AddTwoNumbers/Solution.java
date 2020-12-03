/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order
and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

package a0002_AddTwoNumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode trace = result;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            trace.next = new ListNode(sum % 10);
            trace = trace.next;
            sum /= 10;
        }
        if (sum != 0) {
            trace.next = new ListNode(sum);
        }
        return result.next;
    }

}
