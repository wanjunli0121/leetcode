/*
Given a string S, find the longest palindromic substring in S.
You may assume that the maximum length of S is 1000,
and there exists one unique longest palindromic substring.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example:
Input: "cbbd"
Output: "bb"
*/

package a0005_LongestPalindromicSubstring;

public class Solution {

    public String longestPalindrome(String s) {
        // pos[0] is start index, pos[1] is end index.
        int[] pos = new int[2];
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i, pos); // odd length
            extendPalindrome(s, i, i + 1, pos); // even length
        }
        return s.substring(pos[0], pos[1] + 1);
    }

    private void extendPalindrome(String s, int start, int end, int[] pos) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        // (end - 1) - (start + 1) + 1 = end - start - 1, the length of current string.
        if (end - start - 1 > pos[1] - pos[0] + 1) {
            pos[0] = start + 1;
            pos[1] = end - 1;
        }
    }

}
