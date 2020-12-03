/*
Given an unsorted array of integers,
find the length of longest increasing subsequence.
For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101],
therefore the length is 4.
Note that there may be more than one LIS combination,
it is only necessary for you to return the length.
Your algorithm should run in O(n^2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

package a0300_LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            // If nums[i] exists in dp, p is the corresponding index.
            // If nums[i] doesn't exist in dp, p is the index to insert nums[i].
            int p = binarySearch(dp, 0, len - 1, nums[i]);
            dp[p] = nums[i];
            // nums[i] is put at the end of current dp.
            if (p == len) {
                len++;
            }
        }
        return len;
    }

    private int binarySearch(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

}
