/*
Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
Note:
Each element in the result must be unique.
The result can be in any order.
*/

package a0349_IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num: set) {
            result[k++] = num;
        }
        return result;
    }

//	Method 3:
//	public int[] intersection(int[] nums1, int[] nums2) {
//		HashSet<Integer> resultSet = new HashSet<Integer>();
//		Arrays.sort(nums2);
//		for (int i = 0; i < nums1.length; i++) {
//			if (binarySearch(nums2, nums1[i])) {
//				resultSet.add(nums1[i]);
//			}
//		}
//		int[] results = new int[resultSet.size()];
//		int k = 0;
//		for (int element: resultSet) {
//			results[k++] = element;
//		}
//		return results;
//	}
//
//	private boolean binarySearch(int[] nums, int target) {
//		int lo = 0, hi = nums.length - 1;
//		while (lo <= hi) {
//			int mid = (lo + hi) / 2;
//			if (target == nums[mid]) {
//				return true;
//			} else if (target < nums[mid]) {
//				hi = mid - 1;
//			} else {
//				lo = mid + 1;
//			}
//		}
//		return false;
//	}

//	  Method 2:
//    public int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> set1 = new HashSet<Integer>();
//        HashSet<Integer> set2 = new HashSet<Integer>();
//        for (int i = 0; i < nums1.length; i++) {
//        	set1.add(nums1[i]);
//        }
//        for (int j = 0; j < nums2.length; j++) {
//        	if (set1.contains(nums2[j])) {
//        		set2.add(nums2[j]);
//        	}
//        }
//        int[] results = new int[set2.size()];
//        int k = 0;
//        for (int element: set2) {
//        	results[k++] = element;
//        }
//        return results;
//    }

}
