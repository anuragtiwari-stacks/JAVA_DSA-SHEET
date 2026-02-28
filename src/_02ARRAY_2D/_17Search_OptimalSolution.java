/*
✅ Problem:
You are given an m x n matrix, where:
Each row is sorted in ascending order (left to right)
Each column is sorted in ascending order (top to bottom)
Write a function that returns true if the target value exists in the matrix, and false otherwise.

Input:
matrix = [
 [1, 4, 7, 11, 15],
 [2, 5, 8, 12, 19],
 [3, 6, 9, 16, 22],
 [10,13,14,17,24],
 [18,21,23,26,30]
 ],
target = 5
Output: true

✅ Intuition:
Start from the top-right corner.
If the value is greater than target, move left.
If it's less than target, move down.
Repeat until you either find the value or go out of bounds.
*/

package _02ARRAY_2D;

public class _17Search_OptimalSolution
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        // Edge case: empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from the top-right corner
        int r = 0;
        int c = cols - 1;

        // Traverse the matrix
        while (r < rows && c >= 0)
        {
            if (matrix[r][c] == target)
            {
                return true; // Target found
            }
            else if (matrix[r][c] > target)
            {
                c--; // Move left
            }
            else
            {
                r++; // Move down
            }
        }

        return false; // Not found
    }

    // Main method to test the function
    public static void main(String[] args)
    {
        _17Search_OptimalSolution obj = new _17Search_OptimalSolution();

        int[][] matrix =
                {
                        {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                };

        int target = 5;

        boolean found = obj.searchMatrix(matrix, target);

        System.out.println("Target found: " + found);
    }
}

/*
| Step | `r` | `c` | `matrix[r][c]` | Compare with 5 | Action    |
| ---- | --- | --- | -------------- | -------------- | --------- |
| 1    | 0   | 4   | 15             | 15 > 5         | `c--` → 3 |
| 2    | 0   | 3   | 11             | 11 > 5         | `c--` → 2 |
| 3    | 0   | 2   | 7              | 7 > 5          | `c--` → 1 |
| 4    | 0   | 1   | 4              | 4 < 5          | `r++` → 1 |
| 5    | 1   | 1   | 5              | 5 == 5         | 🎯 Found! |
*/