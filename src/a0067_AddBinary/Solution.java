/*
Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".
*/

package a0067_AddBinary;

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0 || sum == 1) {
            sum += (i >= 0 ? a.charAt(i--) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j--) - '0' : 0);
            sb.insert(0, sum % 2);
            sum /= 2;
        }
        return sb.toString();
    }

}
