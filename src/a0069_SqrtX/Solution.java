/*
Implement int sqrt(int x).
Compute and return the square root of x,
where x is guaranteed to be a non-negative integer.
Since the return type is an integer,
the decimal digits are truncated and only the integer part of the result is returned.
*/

package a0069_SqrtX;

public class Solution {

    public int mySqrt(int x) {
        int lo = 1, hi = x;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

}
