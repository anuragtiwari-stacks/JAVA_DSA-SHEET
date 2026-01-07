package _2ARRAY_2D;

public class  _6MulOfTwoMatrice
{
    public static void main(String[] args)
    {
        // Initialize two matrices
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        // Check if multiplication is possible:
        // Columns of matrix1 must be equal to rows of matrix2
        if (matrix1[0].length != matrix2.length)
        {
            System.out.println("Matrix multiplication not possible due to incompatible dimensions.");
            return;
        }

        // Initialize result matrix with dimensions: rows of matrix1 x columns of matrix2
        int[][] product = new int[matrix1.length][matrix2[0].length];

        // Multiply matrices
        for (int i = 0; i < matrix1.length; i++)           // For each row of matrix1
        {
            for (int j = 0; j < matrix2[0].length; j++)    // For each column of matrix2
            {
                product[i][j] = 0;
                for (int k = 0; k < matrix1[0].length; k++) // Sum over columns of matrix1 / rows of matrix2
                {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        // Print the product matrix
        System.out.println("Product of the two matrices:");
        for (int i = 0; i < product.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < product[i].length; j++)
            {
                System.out.print(product[i][j]);
                if (j < product[i].length - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
