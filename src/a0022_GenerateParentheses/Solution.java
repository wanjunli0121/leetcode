/*
Given n pairs of parentheses,
write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
"((()))", "(()())", "(())()", "()(())", "()()()"
*/

package a0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateParenthesis(list, "", 0, 0, n);
        return list;
    }

    // open is the number of open parenthesis,
    // close is the number of close parenthesis,
    // num is the maximum number of pairs.
    private void generateParenthesis(List<String> list, String s, int open, int close, int num) {
        if (s.length() == num * 2) {
            list.add(s);
        } else {
            if (open < num) {
                generateParenthesis(list, s + "(", open + 1, close, num);
            }
            if (open > close) {
                generateParenthesis(list, s + ")", open, close + 1, num);
            }
        }
    }

}
