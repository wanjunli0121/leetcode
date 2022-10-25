/*
Given the root of a binary tree,
flatten the tree into a "linked list":
The "linked list" should use the same TreeNode class
where the right child pointer points to the next node in the list
and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/

package a0114_FlattenBinaryTreeToLinkedList;

public class Solution {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightNode = dfs(root.right);
        root.right = dfs(root.left);
        root.left = null;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        node.right = rightNode;
        return root;
    }

}
