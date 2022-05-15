/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?
For example,
Given sorted array nums = [1,1,1,2,2,3],
Your function should return length = 5,
with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
*/

package a0080_RemoveDuplicatesFromSortedArrayTwo;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k] && count == 1) {
                nums[++k] = nums[i];
                count++;
            } else if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
                count = 1;
            }
        }
        return k + 1;
    }

}
