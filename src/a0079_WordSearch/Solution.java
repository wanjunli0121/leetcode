/*
Given a 2D board and a word,
find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.
For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

package a0079_WordSearch;

public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int row, int col, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(pos)) {
            return false;
        }
        board[row][col] = '*';
        boolean result = exist(board, word, row + 1, col, pos + 1)
                || exist(board, word, row - 1, col, pos + 1)
                || exist(board, word, row, col + 1, pos + 1)
                || exist(board, word, row, col - 1, pos + 1);
        board[row][col] = word.charAt(pos);
        return result;
    }

}
