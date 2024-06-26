/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,
Consider the following matrix:
[
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
Given target = 3, return true.
*/

package a0074_SearchA2DMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int targetRow = lo - 1;
        if (targetRow < 0) {
            return false;
        }
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

}
