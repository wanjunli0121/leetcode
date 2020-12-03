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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        pathSum(list, new ArrayList<Integer>(), root, sum);
        return list;
    }

    private void pathSum(List<List<Integer>> list, List<Integer> cur, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            list.add(new ArrayList<Integer>(cur));
        } else {
            pathSum(list, cur, root.left, sum - root.val);
            pathSum(list, cur, root.right, sum - root.val);
        }
        cur.remove(cur.size() - 1);
    }

}
