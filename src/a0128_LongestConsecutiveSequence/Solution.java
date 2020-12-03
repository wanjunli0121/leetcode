/*
Given an unsorted array of integers,
find the length of the longest consecutive elements sequence.
Your algorithm should run in O(n) complexity.
Example:
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
Therefore its length is 4.
*/

package a0128_LongestConsecutiveSequence;

import java.util.HashSet;

public class Solution {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int val: set) {
            if (!set.contains(val - 1)) {
                int curVal = val;
                int curLen = 1;
                while (set.contains(curVal + 1)) {
                    curVal++;
                    curLen++;
                }
                result = Math.max(curLen, result);
            }
        }
        return result;
    }

}
