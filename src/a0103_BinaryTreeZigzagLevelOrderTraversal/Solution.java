/*
Given a binary tree,
return the zigzag level order traversal of its nodes' values.
(ie, from left to right,
then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

package a0103_BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // BFS:
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> cur = new LinkedList<Integer>();
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (order) {
                    cur.add(node.val);
                } else {
                    cur.addFirst(node.val);
                }
            }
            result.add(cur);
            order = !order;
        }
        return result;
    }

//	  Method 2: DFS
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        zigzagLevelOrder(result, root, 0);
//        return result;
//    }
//
//    private void zigzagLevelOrder(List<List<Integer>> list, TreeNode root, int level) {
//    	if (root == null) {
//    		return;
//    	}
//    	if (list.size() == level) {
//    		list.add(new ArrayList<Integer>());
//    	}
//    	List<Integer> cur = list.get(level);
//    	if (level % 2 == 0) {
//    		cur.add(root.val);
//    	} else {
//    		cur.add(0, root.val);
//    	}
//    	zigzagLevelOrder(list, root.left, level + 1);
//    	zigzagLevelOrder(list, root.right, level + 1);
//    }

}
