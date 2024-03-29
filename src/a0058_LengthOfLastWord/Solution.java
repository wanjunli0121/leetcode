/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example, Given s = "Hello World", return 5.
*/

package a0058_LengthOfLastWord;

public class Solution {

    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        return arr[arr.length - 1].length();
    }

}
