/*
Given the root of a binary tree,
invert the tree, and return its root.
*/

package a0226_InvertBinaryTree;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);
        return root;
    }

}
