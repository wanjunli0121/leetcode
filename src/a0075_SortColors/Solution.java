/*
Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2
to represent the color red, white, and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's,
then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/

package a0075_SortColors;

public class Solution {

    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int i = 0;
        // From nums[0] to nums[lo - 1]: 0
        // From nums[hi + 1] to nums[nums.length - 1]: 2
        while (i <= hi) {
            if (nums[i] == 0) {
                int t = nums[lo];
                nums[lo++] = nums[i];
                nums[i++] = t;
            } else if (nums[i] == 2) {
                int t = nums[i];
                nums[i] = nums[hi];
                nums[hi--] = t;
            } else {
                i++;
            }
        }
    }

}
