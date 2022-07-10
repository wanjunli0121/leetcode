/*
Given an array of integers and an integer k,
find out whether there are two distinct indices i and j in the array
such that nums[i] = nums[j] and the difference between i and j is at most k.
*/

package a0219_ContainsDuplicateTwo;

import java.util.HashSet;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
