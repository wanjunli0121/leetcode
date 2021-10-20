/*
Given a sorted array of integers,
find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

package a0034_FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        // Find the left boundary.
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (lo >= nums.length || nums[lo] != target) {
            return result;
        }
        result[0] = lo++;
        // Find the right boundary.
        hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        result[1] = lo - 1;
        return result;
    }

}
