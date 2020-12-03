/*
Implement next permutation,
which rearranges numbers into the lexicographically
next greater permutation of numbers.
If such arrangement is not possible,
it must rearrange it as the lowest possible order
(ie, sorted in ascending order).
The replacement must be in-place,
do not allocate extra memory.
Here are some examples.
Inputs are in the left-hand column
and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

package a0031_NextPermutation;

public class Solution {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // nums[i + 1] through nums[len - 1] are in reversed order.
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i < 0) {
            reverse(nums, 0, len - 1);
            return;
        }

        // nums[j] is the smallest number between nums[i + 1] and nums[len - 1]
        // which is larger than nums[i].
        int j = len - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

        // After swapping, nums[i + 1] through nums[len - 1] are in reversed order.
        reverse(nums, i + 1, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
    }

}
