
package _2ARRAY_2D;

public class _8Reverse2DArray
{
    public static void main(String[] args)
    {
        // Original 2D array
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int rows = array.length;
        int cols = array[0].length;

        // Create a new 2D array to hold reversed elements
        int[][] reversed = new int[rows][cols];

        // Total number of elements in 2D array
        int totalElements = rows * cols;

        // Flatten index for reversed array
        int index = 0;

        // Traverse original array in reverse order and fill reversed array in normal order
        for (int i = totalElements - 1; i >= 0; i--)
        {
            // Calculate row and column for original array in reverse order
            int r = i / cols;
            int c = i % cols;

            // Calculate row and column for reversed array in normal order
            int revR = index / cols;
            int revC = index % cols;

            reversed[revR][revC] = array[r][c];
            index++;
        }

        // Print the reversed 2D array
        System.out.println("Reversed 2D array:");
        for (int i = 0; i < reversed.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < reversed[i].length; j++)
            {
                System.out.print(reversed[i][j]);
                if (j < reversed[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println(" }");
        }
    }
}

/*
r = i / cols → integer division to find the row
c = i % cols → remainder to find the column

Example:
For i = 5:
r = 5 / 3 = 1 (row 1), c = 5 % 3 = 2 (column 2) → element array[1][2] = 6
*/