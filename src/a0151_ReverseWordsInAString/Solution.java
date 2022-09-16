/*
Given an input string,
reverse the string word by word.
Example 1:
Input: "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation:
Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: "a good   example"
Output: "example good a"
Explanation:
You need to reduce multiple spaces between two words to a single space in the reversed string.
Note:
A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces.
However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

package a0151_ReverseWordsInAString;

public class Solution {

    // 1. Reverse the whole string
    // 2. Reverse each word
    public String reverseWords(String s) {
        s = s.trim();
        char[] ca = s.toCharArray();
        reverse(ca, 0, ca.length - 1);
        int start = 0, end = 0;
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                ca[end++] = ca[i];
            } else if (ca[i - 1] != ' ') {
                reverse(ca, start, end - 1);
                ca[end++] = ' ';
                start = end;
            }
        }
        reverse(ca, start, end - 1);
        return new String(ca, 0, end);
    }

    private void reverse(char[] ca, int lo, int hi) {
        while (lo < hi) {
            char c = ca[lo];
            ca[lo++] = ca[hi];
            ca[hi--] = c;
        }
    }

}
