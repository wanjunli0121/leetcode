/*
Given an array of n positive integers and a positive integer s,
find the minimal length of a subarray of which the sum ≥ s.
If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
*/

package a0209_MinimumSizeSubarraySum;

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, result = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                result = result == 0 ? right - left : Math.min(result, right - left);
                sum -= nums[left++];
            }
        }
        return result;
    }

}
