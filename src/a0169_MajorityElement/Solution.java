/*
Given an array of size n, find the majority element.
The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty
and the majority element always exist in the array.
*/

package a0169_MajorityElement;

import java.util.Arrays;
//import java.util.HashMap;

public class Solution {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

//    Method 2:
//    public int majorityElement(int[] nums) {
//    	  int result = 0;
//        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//        	if (!count.containsKey(nums[i])) {
//        		count.put(nums[i], 1);
//        	} else {
//        		count.put(nums[i], count.get(nums[i]) + 1);
//        	}
//        	if (count.get(nums[i]) > n / 2) {
//        		result = nums[i];
//        		break;
//        	}
//        }
//        return result;
//    }

}
