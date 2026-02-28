package _02ARRAY_2D;

public class _13ReverseZigzagTraversal
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

        System.out.println("Reverse Zigzag / Diagonal traversal of the matrix:");

        // Total diagonals = rows + cols - 1
        for (int d = rows + cols - 2; d >= 0; d--)
        {
            if (d % 2 == 0)
            {
                // For even d, traverse downward: i from min to max where i + j = d
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
            else
            {
                // For odd d, traverse upward: i from max to min where i + j = d
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
        }
    }
}
