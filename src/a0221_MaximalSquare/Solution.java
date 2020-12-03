/*
Given a 2D binary matrix filled with 0's and 1's,
find the largest square containing all 1's and return its area.
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/

package a0221_MaximalSquare;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        char result = '0';

        // Find whether there is '1' on first row or first column.
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                result = '1';
                break;
            }
        }
        if (result == '0') {
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == '1') {
                    result = '1';
                    break;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // To get the new value of matrix[i][j].
                    // Find the smallest value of elements on the top, left and top left, then plus 1.
                    matrix[i][j] = (char)(Math.min(Math.min(matrix[i - 1][j] - '0', matrix[i][j - 1] - '0'), matrix[i - 1][j - 1] - '0') + 1 + '0');
                    if (result < matrix[i][j]) {
                        result = matrix[i][j];
                    }
                }
            }
        }
        return (result - '0') * (result - '0');
    }

//    Method 2:
//    public int maximalSquare(char[][] matrix) {
//    	int m = matrix.length;
//    	if (m == 0) {
//    		return 0;
//    	}
//    	int n = matrix[0].length;
//    	int result = 0;
//    	int[][] t = new int[m + 1][n + 1];
//    	for (int i = 1; i <= m; i++) {
//    		for (int j = 1; j <= n; j++) {
//    			if (matrix[i - 1][j - 1] == '1') {
//    				t[i][j] = Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]) + 1;
//    				result = Math.max(result, t[i][j]);
//    			}
//    		}
//    	}
//    	return result * result;
//    }

}
