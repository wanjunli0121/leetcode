/*
Given a 2D grid consists of 0s (land) and 1s (water).
An island is a maximal 4-directionally connected group of 0s
and a closed island is an island
totally (all left, top, right, bottom) surrounded by 1s.
Return the number of closed islands.
*/

package a1254_NumberOfClosedIslands;

public class Solution {

    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    result += oneIsland(grid, i, j);
                }
            }
        }
        return result;
    }

    private int oneIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 1;
        }
        grid[i][j] = 1;
        return oneIsland(grid, i + 1, j) & oneIsland(grid, i - 1, j) & oneIsland(grid, i, j + 1) & oneIsland(grid, i, j - 1);
    }

}
