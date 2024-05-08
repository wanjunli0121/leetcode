/*
Given an integer array nums of unique elements,
return all possible subsets (the power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
*/

package a0078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

//    Method 2:
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        int totalNumber = 1 << nums.length;
//        for (int i = 0; i < totalNumber; i++) {
//            List<Integer> collection = new ArrayList<>();
//            for (int j = 0; j < nums.length; j++) {
//                if ((i & (1 << j)) != 0) {
//                    collection.add(nums[j]);
//                }
//            }
//            result.add(collection);
//        }
//        return result;
//    }

}
