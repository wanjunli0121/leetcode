/*
Given n, how many structurally unique BST's
(binary search trees) that store values 1...n?
For example,
Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

package a0096_UniqueBinarySearchTrees;

public class Solution {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Using j as root,
                // dp[j - 1] is the number of left subtrees,
                // dp[i - j] is the number of right subtrees.
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
