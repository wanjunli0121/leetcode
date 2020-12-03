/*
Given an array of non-negative integers,
you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Example:
Input: [2,3,1,1,4]
Output: 2
Explanation:
The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:
You can assume that you can always reach the last index.
*/

package a0045_JumpGameTwo;

public class Solution {

    // https://leetcode.com/problems/jump-game-ii/solution/
    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        // max position one could reach starting from index <= i
        int maxPos = nums[0];
        // max number of steps one could do inside this jump
        int maxSteps = nums[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            // if to reach this point one needs one more jump
            if (maxSteps < i) {
                jumps++;
                maxSteps = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }

}
