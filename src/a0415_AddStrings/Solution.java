/*
Given two non-negative integers num1 and num2 represented as string,
return the sum of num1 and num2.
Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library
or convert the inputs to integer directly.
*/

package a0415_AddStrings;

public class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            sum += n1 + n2;
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum != 0) {
            sb.append(sum);
        }
        return sb.reverse().toString();
    }

}
