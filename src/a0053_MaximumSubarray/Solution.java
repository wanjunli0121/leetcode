/*
Find the contiguous subarray within an array (containing at least one number)
which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach,
which is more subtle.
*/

package a0053_MaximumSubarray;

public class Solution {

    public int maxSubArray(int[] nums) {
        int sum = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], cur + nums[i]);
            sum = Math.max(sum, cur);
        }
        return sum;
    }

}
