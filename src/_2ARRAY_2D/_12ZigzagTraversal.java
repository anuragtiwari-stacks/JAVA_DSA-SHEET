package _2ARRAY_2D;

public class _12ZigzagTraversal
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Zigzag / Diagonal traversal of the matrix:");

        // Total diagonals = rows + cols - 1
        for (int d = 0; d <= rows + cols - 2; d++)
        {
            if (d % 2 == 0)
            {
                // For even d, traverse upward: i from max to min where i + j = d
                for (int i = rows - 1; i >= 0; i--)
                {
                    for (int j = 0; j < cols; j++)
                    {
                        if (i + j == d)
                        {
                            System.out.print(matrix[i][j] + " ");
                        }
                    }
                }
            }
            else
            {
                // For odd d, traverse downward: i from min to max where i + j = d
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < cols; j++)
                    {
                        if (i + j == d)
                        {
                            System.out.print(matrix[i][j] + " ");
                        }
                    }
                }
            }
        }
    }
}

/*
| Diagonal (d = i + j) | Elements (i, j)     | Values in matrix |
| -------------------- | ------------------- | ---------------- |
| d = 0                | (0, 0)              | 1                |
| d = 1                | (0,1), (1,0)        | 2, 4             |
| d = 2                | (0,2), (1,1), (2,0) | 3, 5, 7          |
| d = 3                | (1,2), (2,1)        | 6, 8             |
| d = 4                | (2,2)               | 9                |
*/

/*
1) d = 0 (even)
Direction: Upward
We want all (i, j) where i + j == 0

Inner nested loops:
i = 2 to 0 (descending)
j = 0 to 2 (ascending)

Check (i, j):
(2,0) → 2 + 0 = 2 ≠ 0 → skip
(2,1) → 3 ≠ 0 → skip
(2,2) → 4 ≠ 0 → skip
(1,0) → 1 ≠ 0 → skip
(1,1) → 2 ≠ 0 → skip
(1,2) → 3 ≠ 0 → skip
(0,0) → 0 + 0 = 0 ✓ print 1
(0,1) → 1 ≠ 0 → skip
(0,2) → 2 ≠ 0 → skip
Output so far: 1

2) d = 1 (odd)
Direction: Downward
All (i, j) where i + j == 1

Inner nested loops:
i = 0 to 2 (ascending)
j = 0 to 2 (ascending)

Check (i, j):
(0,0) → 0 ≠ 1 → skip
(0,1) → 1 ✓ print 2
(0,2) → 2 ≠ 1 → skip
(1,0) → 1 ✓ print 4
(1,1) → 2 ≠ 1 → skip
(1,2) → 3 ≠ 1 → skip
(2,0) → 2 ≠ 1 → skip
(2,1) → 3 ≠ 1 → skip
(2,2) → 4 ≠ 1 → skip
Output so far: 1 2 4

3) d = 2 (even)
Direction: Upward
All (i, j) where i + j == 2

Inner nested loops:
i = 2 to 0 (descending)
j = 0 to 2 (ascending)

Check (i, j):
(2,0) → 2 ✓ print 7
(2,1) → 3 ≠ 2 → skip
(2,2) → 4 ≠ 2 → skip
(1,0) → 1 ≠ 2 → skip
(1,1) → 2 ✓ print 5
(1,2) → 3 ≠ 2 → skip
(0,0) → 0 ≠ 2 → skip
(0,1) → 1 ≠ 2 → skip
(0,2) → 2 ✓ print 3
Output so far: 1 2 4 7 5 3

4) d = 3 (odd)
Direction: Downward

All (i, j) where i + j == 3

Inner nested loops:
i = 0 to 2 (ascending)
j = 0 to 2 (ascending)

Check (i, j):
(0,0) → 0 ≠ 3 → skip
(0,1) → 1 ≠ 3 → skip
(0,2) → 2 ≠ 3 → skip
(1,0) → 1 ≠ 3 → skip
(1,1) → 2 ≠ 3 → skip
(1,2) → 3 ✓ print 6
(2,0) → 2 ≠ 3 → skip
(2,1) → 3 ✓ print 8
(2,2) → 4 ≠ 3 → skip
Output so far: 1 2 4 7 5 3 6 8
*/