/*
Given a binary tree, return the postorder traversal of its nodes' values.
For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
Note: Recursive solution is trivial, could you do it iteratively?
*/

package a0145_BinaryTreePostorderTraversal;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                result.addFirst(cur.val);
                cur = cur.right;
            }
            cur = stack.pop().left;
        }
        return result;
    }

//    Method 2: Recursive
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        postorderTraversal(root, result);
//        return result;
//    }
//
//    private void postorderTraversal(TreeNode node, List<Integer> list) {
//        if (node == null) {
//            return;
//        }
//        // left -> right -> add
//        postorderTraversal(node.left, list);
//        postorderTraversal(node.right, list);
//        list.add(node.val);
//    }

}
