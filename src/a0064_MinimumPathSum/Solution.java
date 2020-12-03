/*
Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/

package a0064_MinimumPathSum;

public class Solution {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

//	  Method 2:
//    public int minPathSum(int[][] grid) {
//    	int m = grid.length;
//    	int n = grid[0].length;
//    	int[][] sum = new int[m][n];
//    	sum[0][0] = grid[0][0];
//    	// First column: move down.
//    	for (int i = 1; i < m; i++) {
//    		sum[i][0] = sum[i - 1][0] + grid[i][0];
//    	}
//    	// First row: move right.
//    	for (int j = 1; j < n; j++) {
//    		sum[0][j] = sum[0][j - 1] + grid[0][j];
//    	}
//      for (int i = 1; i < m; i++) {
//     	  for (int j = 1; j < n; j++) {
//          sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
//        }
//      }
//      return sum[m - 1][n - 1];
//    }

}
