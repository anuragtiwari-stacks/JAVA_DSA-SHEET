package _2ARRAY_2D;

public class _14Diagonal
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Diagonal traversal of the matrix:");

        // Total diagonals = rows + cols - 1
        for (int d = 0; d <= rows + cols - 2; d++)
        {
            if (d % 2 == 0)
            {
                // Even d: traverse upwards (row from max to min)
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
                // Odd d: traverse downwards (row from min to max)
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
