/*
Given a non-negative number represented as an array of digits,
plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.
*/

package a0066_PlusOne;

public class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }

}
