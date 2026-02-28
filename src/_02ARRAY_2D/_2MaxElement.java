package _02ARRAY_2D;

public class _2MaxElement
{
    public static void main(String[] args)
    {
        // Declare and initialize a 2D array
        int[][] array = {
                {10, 25, 30},
                {5, 75, 15},
                {40, 8, 60}
        };

        // Initialize max with the first element of the array
        int max = array[0][0];

        // Traverse the 2D array using normal nested for loop
        for (int i = 0; i < array.length; i++)         // Loop through each row
        {
            for (int j = 0; j < array[i].length; j++)  // Loop through each column in current row
            {
                if (array[i][j] > max)                 // If current element is greater than max
                {
                    max = array[i][j];                 // Update max
                }
            }
        }

        // Print the maximum element
        System.out.println("Maximum element in the 2D array: " + max);
    }
}
