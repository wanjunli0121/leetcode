/*
A peak element is an element that is greater than its neighbors.
Given an input array where num[i] ≠ num[i+1],
find a peak element and return its index.
The array may contain multiple peaks,
in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -∞.
For example, in array [1, 2, 3, 1],
3 is a peak element and your function should return the index number 2.
Note:
Your solution should be in logarithmic complexity.
*/

package a0162_FindPeakElement;

public class Solution {

    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
