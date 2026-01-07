package _1ARRAY_1D._1MinMaxArray;

public class _1Pairwise
{
    public static void main(String[] args)
    {
        // Input array
        int[] arr = {100, 11, 445, 1, 330, 3000};

        // Get length of the array
        int n = arr.length;

        // Variables to store min and max values
        int min, max;

        // Variable for loop index
        int i;

        // If number of elements is even
        if (n % 2 == 0)
        {
            // Compare first two elements
            if (arr[0] > arr[1])
            {
                max = arr[0]; // Larger becomes max
                min = arr[1]; // Smaller becomes min
            }
            else
            {
                max = arr[1];
                min = arr[0];
            }

            // Start loop from index 2
            i = 2;
        }
        else
        {
            // If number of elements is odd, initialize both min and max to first element
            max = arr[0];
            min = arr[0];

            // Start loop from index 1
            i = 1;
        }

        // Process elements in pairs
        while (i < n - 1)
        {
            int localMin, localMax;

            // Compare elements in the current pair
            if (arr[i] > arr[i + 1])
            {
                localMax = arr[i];     // larger in pair
                localMin = arr[i + 1]; // smaller in pair
            }
            else
            {
                localMax = arr[i + 1];
                localMin = arr[i];
            }

            // Compare with overall max
            if (localMax > max)
            {
                max = localMax;
            }

            // Compare with overall min
            if (localMin < min)
            {
                min = localMin;
            }

            // Move to next pair
            i = i + 2;
        }

        // Print results
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}

/*
We separate the even and odd cases in this algorithm to initialize min and max correctly and to ensure
that all remaining elements are processed in pairs — which is the key to minimizing the number of comparisons.

| Case     | What we do                    | Why we do it          |
| -------- | ----------------------------- | --------------------- |
| Even `n` | Compare first 2 for min/max   | Then pair up the rest |
| Odd `n`  | Set first as min/max directly | Then pair up the rest |
*/


/*
Summary of Optimizations:
Naive method: 2(n - 1) comparisons

This method:
Initial 1 comparison (or 0 if n is odd)

Then 3 comparisons per 2 elements → 1.5 comparisons per element
Total comparisons ≈ 1.5n - 2 (best known for this problem)
*/