/*
Design a stack that supports
push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

package a0155_MinStack;

public class MinStack {

    private Stack stack;
    private Stack stackForMin;

    private static class Stack {

        private Node node;

        public void push(int x) {
            if (node == null) {
                node = new Node(x);
            } else {
                node = new Node(x, node);
            }
        }

        public int pop() {
            int val = node.val;
            node = node.next;
            return val;
        }

        public int peek() {
            return node.val;
        }

        public boolean isEmpty() {
            return node == null;
        }

    }

    private static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
        }
        Node(int x, Node node) {
            val = x;
            next = node;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        stackForMin = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if (stackForMin.isEmpty() || x <= stackForMin.peek()) {
            stackForMin.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (!stackForMin.isEmpty() && x == stackForMin.peek()) {
            stackForMin.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackForMin.peek();
    }

}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */