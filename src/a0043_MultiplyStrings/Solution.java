/*
Given two numbers represented as strings,
return multiplication of the numbers as a string.
Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
*/

package a0043_MultiplyStrings;

public class Solution {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = pos[p2] + product;
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        int h = 0;
        while (h < m + n && pos[h] == 0) {
            h++;
        }
        if (h == m + n) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int k = h; k < m + n; k++) {
            sb.append(pos[k]);
        }
        return sb.toString();
    }

}
