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
        // the upper bound of mid * mid <= x
        if (x == 1) {
            return 1;
        }
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (x / mid >= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }

}
