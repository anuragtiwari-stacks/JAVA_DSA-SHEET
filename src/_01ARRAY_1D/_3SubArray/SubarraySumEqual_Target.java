package _01ARRAY_1D._3SubArray;

public class SubarraySumEqual_Target
{
    public static int countSubarraysWithSum(int[] arr, int target)
    {
        int count = 0;

        for (int start = 0; start < arr.length; start++)
        {
            int sum = 0;

            for (int end = start; end < arr.length; end++)
            {
                sum = sum + arr[end];

                if (sum == target)
                {
                    count++;

                    // Print the subarray
                    System.out.print("Subarray: [");
                    for (int k = start; k <= end; k++)
                    {
                        System.out.print(arr[k]);
                        if (k < end)
                        {
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 1, 1 };
        int target = 3;

        int total = countSubarraysWithSum(arr, target);
        System.out.println("Total subarrays with sum " + target + ": " + total);
    }
}

/*
| `start` | `end` | Subarray         | Running `sum` | `sum == target` | `count` | Action         |
| ------- | ----- | ---------------- | ------------- | --------------- | ------- | -------------- |
| 0       | 0     | \[1]             | 1             | ❌ No            | 0       | -              |
| 0       | 1     | \[1, 2]          | 3             | ✅ Yes           | 1       | Print +1 count |
| 0       | 2     | \[1, 2, 3]       | 6             | ❌ No            | 1       | -              |
| 0       | 3     | \[1, 2, 3, 1]    | 7             | ❌ No            | 1       | -              |
| 0       | 4     | \[1, 2, 3, 1, 1] | 8             | ❌ No            | 1       | -              |
| 1       | 1     | \[2]             | 2             | ❌ No            | 1       | -              |
| 1       | 2     | \[2, 3]          | 5             | ❌ No            | 1       | -              |
| 1       | 3     | \[2, 3, 1]       | 6             | ❌ No            | 1       | -              |
| 1       | 4     | \[2, 3, 1, 1]    | 7             | ❌ No            | 1       | -              |
| 2       | 2     | \[3]             | 3             | ✅ Yes           | 2       | Print +1 count |
| 2       | 3     | \[3, 1]          | 4             | ❌ No            | 2       | -              |
| 2       | 4     | \[3, 1, 1]       | 5             | ❌ No            | 2       | -              |
| 3       | 3     | \[1]             | 1             | ❌ No            | 2       | -              |
| 3       | 4     | \[1, 1]          | 2             | ❌ No            | 2       | -              |
| 4       | 4     | \[1]             | 1             | ❌ No            | 2       | -              |
*/