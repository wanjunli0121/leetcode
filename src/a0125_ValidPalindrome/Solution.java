/*
Given a string, determine if it is a palindrome,
considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty?
This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.
*/

package a0125_ValidPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        s = sb.toString();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }

}
