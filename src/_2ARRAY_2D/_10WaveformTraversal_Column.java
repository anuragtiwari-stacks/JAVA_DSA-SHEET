package _2ARRAY_2D;

public class _10WaveformTraversal_Column
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };

        System.out.println("Waveform traversal of the matrix:");

        for (int col = 0; col < matrix[0].length; col++)
        {
            if (col % 2 == 0)
            {
                // Even column: print top to bottom
                for (int row = 0; row < matrix.length; row++)
                {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            else
            {
                // Odd column: print bottom to top
                for (int row = matrix.length - 1; row >= 0; row--)
                {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
/*
Printing a matrix in waveform (or wave) form means traversing the matrix column-wise,
but alternating the direction of traversal in each column:

For the 1st column (index 0), print top to bottom

For the 2nd column (index 1), print bottom to top

For the 3rd column (index 2), again top to bottom

And so on.. */