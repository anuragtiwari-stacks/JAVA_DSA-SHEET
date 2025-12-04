package _1ARRAY_1D._1MinMaxArray;

public class _2Naive
{
    public static void main(String[] args)
    {
        int[] arr = {100, 11, 445, 1, 330, 3000};

        int n = arr.length;

        // Initialize min and max to the first element
        int min = arr[0];
        int max = arr[0];

        // Traverse the rest of the array
        for (int i = 1; i < n; i++)
        {
            // Compare with current max
            if (arr[i] > max)
            {
                max = arr[i];
            }

            // Compare with current min
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }

        // Output results
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
