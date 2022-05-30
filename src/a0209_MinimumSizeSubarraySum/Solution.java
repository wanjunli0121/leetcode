/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a subarray of which the sum ≥ s.
If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

package a0209_MinimumSizeSubarraySum;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int lo = 0, hi = 0, sum = 0, result = 0;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= target) {
                result = result == 0 ? hi - lo : Math.min(result, hi - lo);
                sum -= nums[lo++];
            }
        }
        return result;
    }

}
