/*
Given a binary tree, return the preorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
Note: Recursive solution is trivial, could you do it iteratively?
*/

package a0144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
//import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        // add -> left -> right
        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
    }

//    Method 2
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                result.add(root.val);
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop().right;
//        }
//        return result;
//    }

}
