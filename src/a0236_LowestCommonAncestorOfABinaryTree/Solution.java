/*
Given a binary tree,
find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w
as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3.
Another example is LCA of nodes 5 and 4 is 5,
since a node can be a descendant of itself according to the LCA definition.
*/

package a0236_LowestCommonAncestorOfABinaryTree;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes == null) {
            // Both p and q are in right subtree.
            return rightRes;
        }
        if (rightRes == null) {
            // Both p and q are in left subtree.
            return leftRes;
        }
        // One in left subtree, one in right subtree.
        return root;
    }

}
