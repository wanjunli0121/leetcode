/*
Given a binary tree, return the inorder traversal of its nodes' values.
For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
Note: Recursive solution is trivial, could you do it iteratively?
*/

package a0094_BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        // left -> add -> right
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

//    Method 2
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            result.add(root.val);
//            root = root.right;
//        }
//        return result;
//    }

}
