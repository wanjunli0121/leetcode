/*
Find the contiguous subarray within an array
(containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

package a0152_MaximumProductSubarray;

public class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxHere = nums[0], minHere = nums[0], maxSofar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxHere = Math.max(maxHere * nums[i], nums[i]);
                minHere = Math.min(minHere * nums[i], nums[i]);
            } else {
                int t = maxHere;
                maxHere = Math.max(minHere * nums[i], nums[i]);
                minHere = Math.min(t * nums[i], nums[i]);
            }
            maxSofar = Math.max(maxHere, maxSofar);
        }
        return maxSofar;
    }

}
