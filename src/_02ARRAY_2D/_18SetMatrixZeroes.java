/*
💻 Problem: Set Matrix Zeroes
You are given an m x n integer matrix.
If an element is 0, set its entire row and column to 0.

You must do it in place, meaning do not use extra space for another matrix.

Input:
matrix = [
  [1, 1, 1],
  [1, 0, 1],
  [1, 1, 1]
]

Output:
[
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1]
]
*/

package _02ARRAY_2D;

public class _18SetMatrixZeroes
{
    public void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Create a copy of the original matrix
        int[][] temp = new int[rows][cols];

        // Step 2: Copy all elements
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                temp[i][j] = matrix[i][j];
            }
        }

        // Step 3: Check original matrix, and mark row and column in copy if value is 0
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    // Set row i to 0
                    for (int k = 0; k < cols; k++)
                    {
                        temp[i][k] = 0;
                    }

                    // Set column j to 0
                    for (int k = 0; k < rows; k++)
                    {
                        temp[k][j] = 0;
                    }
                }
            }
        }

        // Step 4: Copy result back to original matrix
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public static void main(String[] args)
    {
        _18SetMatrixZeroes obj = new _18SetMatrixZeroes();

        int[][] matrix =
                {
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                };

        obj.setZeroes(matrix);

        // Print updated matrix
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
