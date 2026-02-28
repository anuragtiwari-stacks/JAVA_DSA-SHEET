package _02ARRAY_2D;

public class _5SumOfTwoMatrices
{
    public static void main(String[] args)
    {
        // Initialize two matrices of the same size (3x3)
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Matrix to store the sum of matrix1 and matrix2
        int[][] sumMatrix = new int[matrix1.length][matrix1[0].length];

        // Add corresponding elements of matrix1 and matrix2
        for (int i = 0; i < matrix1.length; i++)          // Loop through rows
        {
            for (int j = 0; j < matrix1[i].length; j++)   // Loop through columns
            {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Print the resulting sum matrix
        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < sumMatrix.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < sumMatrix[i].length; j++)
            {
                System.out.print(sumMatrix[i][j]);
                if (j < sumMatrix[i].length - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
