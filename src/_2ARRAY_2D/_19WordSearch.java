/*
You are given an m x n grid of characters board and a string word.

Return true if word exists in the grid, and false otherwise.

The word can be constructed from letters of sequentially adjacent cells
— where adjacent cells are horizontally or vertically neighboring.

The same letter cell may not be used more than once.

Input:
board = [
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED"

Output:
True
*/

package _2ARRAY_2D;

public class _19WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        int rows = board.length;
        int cols = board[0].length;

        // Traverse each cell
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    // Start search
                    if (search(board, word, 0, i, j))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Helper method for backtracking
    public boolean search(char[][] board, String word, int index, int i, int j)
    {
        // Base case: All characters matched
        if (index == word.length())
        {
            return true;
        }

        // Out of bounds or mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                board[i][j] != word.charAt(index))
        {
            return false;
        }

        // Mark the cell as visited by changing value temporarily
        char temp = board[i][j];
        board[i][j] = '#';  // Any symbol not present in board

        // Explore in 4 directions: up, down, left, right
        boolean found = search(board, word, index + 1, i + 1, j) ||
                search(board, word, index + 1, i - 1, j) ||
                search(board, word, index + 1, i, j + 1) ||
                search(board, word, index + 1, i, j - 1);

        board[i][j] = temp; // Backtrack: restore the original character

        return found;
    }

    // To test
    public static void main(String[] args)
    {
        _19WordSearch obj = new _19WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(obj.exist(board, "ABCCED")); // true
        System.out.println(obj.exist(board, "SEE"));    // true
        System.out.println(obj.exist(board, "ABCB"));   // false
    }
}
