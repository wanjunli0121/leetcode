/*
Given an integer n, generate all structurally unique BST's
(binary search trees) that store values 1...n.
Example:
Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

package a0095_UniqueBinarySearchTreesTwo;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        if (lo > hi) {
            result.add(null);
            return result;
        }
        // Use i as root.
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> leftSubtrees = generateTrees(lo, i - 1);
            List<TreeNode> rightSubtrees = generateTrees(i + 1, hi);
            for (TreeNode leftNode: leftSubtrees) {
                for (TreeNode rightNode: rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
