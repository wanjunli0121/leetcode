/*
Given a complete binary tree, count the number of nodes.
Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level,
except possibly the last, is completely filled,
and all nodes in the last level are as far left as possible.
It can have between 1 and 2^h nodes inclusive at the last level h.
*/

package a0222_CountCompleteTreeNodes;

public class Solution {

    public int countNodes(TreeNode root) {
        int h = height(root);
        if (h == 0) {
            return 0;
        }
        if (height(root.right) == h - 1) {
            // Left subtree is full.
            return (1 << (h - 1)) + countNodes(root.right);
        } else {
            // Right subtree is full.
            return (1 << (h - 2)) + countNodes(root.left);
        }
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) + 1;
    }

}
