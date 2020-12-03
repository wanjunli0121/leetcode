/*
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
Here are some good questions to ask before coding.
If the integer's last digit is 0, what should the output be?
ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow?
Assume the input is a 32-bit integer,
then the reverse of 1000000003 overflows.
How should you handle such cases?
For the purpose of this problem,
assume that your function returns 0 when the reversed integer overflows.
*/

package a0007_ReverseInteger;

public class Solution {

    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            int t = sum * 10 + x % 10;
            // If overflow exists, the result will not equal previous sum.
            if ((t - x % 10) / 10 != sum) {
                return 0;
            }
            sum = t;
            x /= 10;
        }
        return sum;
    }

//	  Method 2:
//    public int reverse(int x) {
//        long sum = 0;
//        while (x != 0) {
//        	sum = sum * 10 + x % 10;
//        	x /= 10;
//        }
//        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
//        	return 0;
//        }
//        return (int)sum;
//    }

}
