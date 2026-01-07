package _2ARRAY_2D;

public class _4SumElements
{
    public static void main(String[] args)
    {
        // Initialize a 2D array
        int[][] array = {
                {5, 10, 15},
                {20, 25, 30},
                {35, 40, 45}
        };

        int sum = 0;  // Variable to store sum of elements

        // Traverse through each element of the 2D array
        for (int i = 0; i < array.length; i++)          // Loop through rows
        {
            for (int j = 0; j < array[i].length; j++)   // Loop through columns in each row
            {
                sum += array[i][j];                      // Add current element to sum
            }
        }

        // Print the sum of all elements
        System.out.println("Sum of all elements in the 2D array: " + sum);
    }
}
