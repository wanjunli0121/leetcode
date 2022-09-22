/*
Implement a basic calculator to evaluate a simple expression string.
The expression string may contain open ( and closing parentheses ),
the plus + or minus sign -, non-negative integers and empty spaces.
You may assume that the given expression is always valid.
Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

package a0224_BasicCalculator;

import java.util.Stack;

public class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0, sign = 1, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + c - '0';
            } else if (c == '+') {
                result += sign * cur;
                sign = 1;
                cur = 0;
            } else if (c == '-') {
                result += sign * cur;
                sign = -1;
                cur = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * cur;
                result *= stack.pop(); // stack.pop() is the sign before the parenthesis.
                result += stack.pop(); // stack.pop() now is the result calculated before the parenthesis.
                cur = 0;
            }
        }
        if (cur != 0) {
            result += sign * cur;
        }
        return result;
    }

}
