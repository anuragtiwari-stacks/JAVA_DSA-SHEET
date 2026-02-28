package _02ARRAY_2D;

public class _17SearchIn2DArray
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int target = 5;
        boolean found = false;

        for (int i = 0; i < matrix.length; i++)        // rows
        {
            for (int j = 0; j < matrix[0].length; j++) // columns
            {
                if (matrix[i][j] == target)
                {
                    System.out.println("Found at (" + i + "," + j + ")");
                    found = true;
                    break;
                }
            }
        }

        if (!found)
        {
            System.out.println("Not found");
        }
    }
}

/*
✅ Example Output
If target = 5, and 5 is found in the matrix:
found = true
!found = false → So "Not found" is not printed.

If target = 99, and it’s not in the matrix:
found = false
!found = true → "Not found" is printed.
*/
