/*
Given a set of distinct integers, nums,
return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

package a0078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int totalNumber = 1 << nums.length;
        for (int i = 0; i < totalNumber; i++) {
            List<Integer> collection = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    collection.add(nums[j]);
                }
            }
            result.add(collection);
        }
        return result;
    }

//    Method 2:
//    https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        backtrack(list, new ArrayList<Integer>(), nums, 0);
//        return list;
//    }
//
//    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//        list.add(new ArrayList<Integer>(tempList));
//        for (int i = start; i < nums.length; i++) {
//            tempList.add(nums[i]);
//            backtrack(list, tempList, nums, i + 1);
//            tempList.remove(tempList.size() - 1);
//        }
//    }

}
