/*
Given an array of non-negative integers,
you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.
For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/

package a0055_JumpGame;

public class Solution {

    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }

//    Method 2:
//    https://leetcode.com/problems/jump-game-ii/solution/
//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        // max position one could reach starting from index <= i
//        int maxPos = nums[0];
//        for (int i = 1; i < n; i++) {
//            // if one could not reach this point
//            if (maxPos < i) {
//                return false;
//            }
//            maxPos = Math.max(maxPos, nums[i] + i);
//        }
//        return true;
//    }

}
