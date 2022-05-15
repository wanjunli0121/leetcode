/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0.
Do it in place.
Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

package a0073_SetMatrixZeroes;

public class Solution {

    // Store states of each row in the first of that row,
    // and store states of each column in the first of that column.
    // Because the state of row0 and the state of column0 would occupy the same cell,
    // let it be the state of row0, and use another variable "col0" for column0.
    // In the first phase, use matrix elements to set states in a top-down way.
    // In the second phase, use states to set matrix elements in a bottom-up way.
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, col0 = matrix[0][0];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }

}
