package _2ARRAY_2D;

public class _3Transpose
{
    public static void main(String[] args)
    {
        // Original 2D array (3 rows, 2 columns)
        int[][] original = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        // Create a new array for transpose (2 rows, 3 columns)
        int[][] transpose = new int[original[0].length][original.length];

        // Traverse the original array to compute transpose
        for (int i = 0; i < original.length; i++)         // Loop through rows
        {
            for (int j = 0; j < original[i].length; j++)  // Loop through columns
            {
                transpose[j][i] = original[i][j];         // Swap row and column indices
            }
        }

        // Print the transposed array
        System.out.println("Transposed 2D array:");
        for (int i = 0; i < transpose.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < transpose[i].length; j++)
            {
                System.out.print(transpose[i][j]);
                if (j < transpose[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println(" }");
        }
    }
}
