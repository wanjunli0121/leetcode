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
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                result.add(cur.val);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return result;
    }

//    Method 2: Recursive
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        preorderTraversal(root, result);
//        return result;
//    }
//
//    private void preorderTraversal(TreeNode node, List<Integer> list) {
//        if (node == null) {
//            return;
//        }
//        // add -> left -> right
//        list.add(node.val);
//        preorderTraversal(node.left, list);
//        preorderTraversal(node.right, list);
//    }

}
