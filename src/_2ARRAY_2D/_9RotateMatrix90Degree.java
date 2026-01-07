package _2ARRAY_2D;

public class _9RotateMatrix90Degree
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Step 1: Transpose the matrix
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = i; j < matrix[i].length; j++)
            {
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row of the transposed matrix
        for (int i = 0; i < matrix.length; i++)
        {
            int start = 0;
            int end = matrix[i].length - 1;
            while (start < end)
            {
                // Swap elements in the row
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }

        // Print rotated matrix
        System.out.println("Matrix after 90 degree rotation:");
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
