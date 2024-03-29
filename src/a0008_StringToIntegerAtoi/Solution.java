/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases.
Notes: It is intended for this problem to be specified vaguely
(ie, no given input specs).
You are responsible to gather all the input requirements up front.
Requirements for atoi:
The function first discards as many whitespace characters as necessary
until the first non-whitespace character is found.
Then, starting from this character,
takes an optional initial plus or minus sign
followed by as many numerical digits as possible,
and interprets them as a numerical value.
The string can contain additional characters
after those that form the integral number,
which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str
is not a valid integral number,
or if no such sequence exists
because either str is empty or it contains only whitespace characters,
no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
If the correct value is out of the range of representable values,
INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

package a0008_StringToIntegerAtoi;

public class Solution {

    public int myAtoi(String str) {
        int result = 0, i = 0, sign = 1;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return result;
        }
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > (Integer.MAX_VALUE - (str.charAt(i) - '0')) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        return sign * result;
    }

}
