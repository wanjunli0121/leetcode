/*
Given preorder and inorder traversal of a tree,
construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
*/

package a0105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }

    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        root.left = buildTree(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }

}
