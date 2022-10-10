/*
Given inorder and postorder traversal of a tree,
construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
*/

package a0106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(postorder.length - 1, 0, inorder.length - 1, postorder, inMap);
    }

    private TreeNode buildTree(int postEnd, int inStart, int inEnd, int[] postorder, Map<Integer, Integer> inMap) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inMap.get(root.val);
        root.left = buildTree(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, postorder, inMap);
        root.right = buildTree(postEnd - 1, inIndex + 1, inEnd, postorder, inMap);
        return root;
    }

}
