package _2ARRAY_2D;

public class _11WaveformTraversal_Row
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };

        System.out.println("Waveform traversal of the matrix by rows:");

        for (int row = 0; row < matrix.length; row++)
        {
            if (row % 2 == 0)
            {
                // Even row: print left to right
                for (int col = 0; col < matrix[row].length; col++)
                {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            else
            {
                // Odd row: print right to left
                for (int col = matrix[row].length - 1; col >= 0; col--)
                {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
    }
}
