/*
Given a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/

package a0199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // BFS:
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            result.add(queue.peek().val);
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }

//    Method 2: DFS
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        rightSideView(root, result, 0);
//        return result;
//    }
//
//    private void rightSideView(TreeNode node, List<Integer> list, int level) {
//    	if (node == null) {
//    		return;
//    	}
//    	if (list.size() == level) {
//        	list.add(node.val);
//    	}
//    	rightSideView(node.right, list, level + 1);
//    	rightSideView(node.left, list, level + 1);
//    }

}
