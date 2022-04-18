/*
Determine if a 9x9 Sudoku board is valid.
Only the filled cells need to be validated according to the following rules:
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
The Sudoku board could be partially filled,
where empty cells are filled with the character '.'.
*/

package a0036_ValidSudoku;

import java.util.HashSet;

public class Solution {

    // Build HashSet for each row, each column and each box,
    // check if it contains duplicate.
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if ((board[i][j] != '.' && !row.add(board[i][j]))
                        || (board[j][i] != '.' && !col.add(board[j][i]))) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> box = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[3 * i + k][3 * j + l] != '.' && !box.add(board[3 * i + k][3 * j + l])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
