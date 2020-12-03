/*
Given a binary tree,
return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

package a0102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // BFS:
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> cur = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                cur.add(node.val);
            }
            result.add(cur);
        }
        return result;
    }

// 	  Method 2: DFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        levelOrder(result, root, 0);
//        return result;
//    }
//
//    private void levelOrder(List<List<Integer>> list, TreeNode root, int level) {
//    	if (root == null) {
//    		return;
//    	}
//    	if (list.size() == level) {
//    		list.add(new ArrayList<Integer>());
//    	}
//    	list.get(level).add(root.val);
//    	levelOrder(list, root.left, level + 1);
//    	levelOrder(list, root.right, level + 1);
//    }

}
