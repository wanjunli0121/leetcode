/*
Given a non-empty binary tree, find the maximum path sum.
For this problem,
a path is defined as any sequence of nodes from some starting node
to any node in the tree along the parent-child connections.
The path must contain at least one node and does not need to go through the root.
Example 1:
Input: [1,2,3]
   1
  / \
 2   3
Output: 6
Example 2:
Input: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
Output: 42
*/

package a0124_BinaryTreeMaximumPathSum;

public class Solution {

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
    private int max_sum = Integer.MIN_VALUE;

    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // max sum on the left and right sub-trees of node
        int leftSum = Math.max(maxSum(node.left), 0);
        int rightSum = Math.max(maxSum(node.right), 0);

        // the price to start a new path where 'node' is a highest node
        int newPath = node.val + leftSum + rightSum;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, newPath);

        // for recursion: return the max gain if continue the same path
        return node.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max_sum;
    }

    
}
