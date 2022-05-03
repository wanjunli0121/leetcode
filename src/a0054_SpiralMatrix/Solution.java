/*
Given a matrix of m x n elements (m rows, n columns),
return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

package a0054_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return result;
        }
        int n = matrix[0].length;
        int row1 = 0, row2 = m - 1, col1 = 0, col2 = n - 1;
        while (row1 <= row2 && col1 <= col2) {
            for (int j = col1; j <= col2; j++) {
                result.add(matrix[row1][j]);
            }
            row1++;
            for (int i = row1; i <= row2; i++) {
                result.add(matrix[i][col2]);
            }
            col2--;
            if (row1 <= row2) {
                for (int j = col2; j >= col1; j--) {
                    result.add(matrix[row2][j]);
                }
                row2--;
            }
            if (col1 <= col2) {
                for (int i = row2; i >= row1; i--) {
                    result.add(matrix[i][col1]);
                }
                col1++;
            }
        }
        return result;
    }

}
