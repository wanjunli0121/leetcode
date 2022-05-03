/*
Given an integer n,
generate a square matrix filled with elements from 1 to n^2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
*/

package a0059_SpiralMatrixTwo;

public class Solution {

    public int[][] generateMatrix(int n) {
        int row1 = 0, row2 = n - 1, col1 = 0, col2 = n - 1, cur = 1;
        int[][] result = new int[n][n];
        while (row1 <= row2 && col1 <= col2) {
            for (int j = col1; j <= col2; j++) {
                result[row1][j] = cur++;
            }
            row1++;
            for (int i = row1; i <= row2; i++) {
                result[i][col2] = cur++;
            }
            col2--;
            if (row1 <= row2) {
                for (int j = col2; j >= col1; j--) {
                    result[row2][j] = cur++;
                }
                row2--;
            }
            if (col1 <= col2) {
                for (int i = row2; i >= row1; i--) {
                    result[i][col1] = cur++;
                }
                col1++;
            }
        }
        return result;
    }

}
