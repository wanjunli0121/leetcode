/*
Given a binary tree and a sum,
find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

package a0113_PathSumTwo;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        pathSum(list, new ArrayList<>(), root, targetSum);
        return list;
    }

    private void pathSum(List<List<Integer>> list, List<Integer> tempList, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        tempList.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                list.add(new ArrayList<>(tempList));
            }
        } else {
            pathSum(list, tempList, root.left, targetSum - root.val);
            pathSum(list, tempList, root.right, targetSum - root.val);
        }
        tempList.remove(tempList.size() - 1);
    }

}
