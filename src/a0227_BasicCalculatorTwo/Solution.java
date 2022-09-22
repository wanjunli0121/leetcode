/*
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers,
+, -, *, / operators and empty spaces.
The integer division should truncate toward zero.
You may assume that the given expression is always valid.
Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

package a0227_BasicCalculatorTwo;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(cur);
                } else if (sign == '-') {
                    stack.push(-cur);
                } else if (sign == '*') {
                    stack.push(stack.pop() * cur);
                } else {
                    stack.push(stack.pop() / cur);
                }
                sign = c;
                cur = 0;
            }
        }
        int result = 0;
        for (int n: stack) {
            result += n;
        }
        return result;
    }

}
