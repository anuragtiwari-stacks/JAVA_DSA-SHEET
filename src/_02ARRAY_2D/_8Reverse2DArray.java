package _02ARRAY_2D;

public class _8Reverse2DArray
{
    public static void main(String[] args)
    {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int rows = array.length;
        int cols = array[0].length;

        // SIMPLE LOGIC: Store into 1D → Reverse → Fill back
        int[] temp = new int[rows * cols];

        // Step 1: Copy elements into temp[]
        int k = 0;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                temp[k++] = array[i][j];
            }
        }

        // Step 2: Reverse temp[]
        int start = 0, end = temp.length - 1;
        while (start < end)
        {
            int t = temp[start];
            temp[start] = temp[end];
            temp[end] = t;
            start++;
            end--;
        }

        // Step 3: Put reversed values back into 2D array
        k = 0;
        int[][] reversed = new int[rows][cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                reversed[i][j] = temp[k++];
            }
        }

        // Print reversed 2D array
        System.out.println("Reversed 2D array:");
        for (int i = 0; i < rows; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < cols; j++)
            {
                System.out.print(reversed[i][j]);
                if (j < cols - 1) System.out.print(", ");
            }
            System.out.println(" }");
        }
    }
}
