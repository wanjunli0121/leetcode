/*
Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:
["1->2->5", "1->3"]
*/

package a0257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        backtrack(root, list, "");
        return list;
    }

    private void backtrack(TreeNode root, List<String> list, String s) {
        if (root == null) {
            return;
        }
        s = s + root.val;
        if (root.left == null && root.right == null) {
            list.add(s);
        } else {
            backtrack(root.left, list, s + "->");
            backtrack(root.right, list, s + "->");
        }
    }

}
