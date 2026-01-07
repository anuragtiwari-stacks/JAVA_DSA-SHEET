package _2ARRAY_2D;

public class _7ReverseEachRow
{
    public static void main(String[] args)
    {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // Loop through each row
        for (int i = 0; i < array.length; i++)
        {
            // Reverse the current row in-place
            int start = 0;
            int end = array[i].length - 1;
            while (start < end)
            {
                // Swap elements at start and end indices
                int temp = array[i][start];
                array[i][start] = array[i][end];
                array[i][end] = temp;

                start++;
                end--;
            }
        }

        // Print the resulting 2D array after reversing each row
        System.out.println("2D array after reversing each row:");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print("{ ");
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println(" }");
        }
    }
}
