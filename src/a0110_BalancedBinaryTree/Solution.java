/*
Given a binary tree, determine if it is height-balanced.
For this problem,
a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.
*/

package a0110_BalancedBinaryTree;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left, root.right);
    }

    private boolean isBalanced(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return right.left == null && right.right == null;
        }
        if (right == null) {
            return left.left == null && left.right == null;
        }
        if (Math.abs(height(left) - height(right)) <= 1) {
            return isBalanced(left.left, left.right) && isBalanced(right.left, right.right);
        }
        return false;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
