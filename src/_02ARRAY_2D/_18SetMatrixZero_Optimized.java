package _02ARRAY_2D;

public class _18SetMatrixZero_Optimized
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        setZeroes(matrix);

        System.out.println("\nMatrix After Setting Zeroes:");
        printMatrix(matrix);
    }

    public static void setZeroes(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Step 1: Check if first row has zero
        for (int j = 0; j < n; j++)
        {
            if (matrix[0][j] == 0)
            {
                firstRowHasZero = true;
                break;
            }
        }

        // Step 2: Check if first column has zero
        for (int i = 0; i < m; i++)
        {
            if (matrix[i][0] == 0)
            {
                firstColHasZero = true;
                break;
            }
        }

        // Step 3: Use first row and column to mark zeros
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Set zero based on markers
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Zero out first row if needed
        if (firstRowHasZero)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Zero out first column if needed
        if (firstColHasZero)
        {
            for (int i = 0; i < m; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }
    }

}
