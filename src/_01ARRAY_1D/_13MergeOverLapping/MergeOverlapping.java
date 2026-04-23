/*
Given an array of intervals arr[], where each interval is represented as [start, end],
merge all overlapping intervals and return an array of mutually exclusive intervals (no overlaps).
*/

package _01ARRAY_1D._13MergeOverLapping;

public class MergeOverlapping
{
    public static void mergeIntervals(int[][] arr)
    {
        int n = arr.length;

        // Step 1: Sort intervals by start time (manual bubble sort)
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j][0] > arr[j + 1][0])
                {
                    // Swap intervals
                    int tempStart = arr[j][0];
                    arr[j][0] = arr[j + 1][0];
                    arr[j + 1][0] = tempStart;

                    int tempEnd = arr[j][1];
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][1] = tempEnd;
                }
            }
        }

        // Step 2: Merge intervals
        int index = 0; // index of last merged interval

        for (int i = 1; i < n; i++)
        {
            // If intervals[index] overlaps with intervals[i]
            if (arr[i][0] <= arr[index][1])
            {
                // Merge
                arr[index][1] = Math.max(arr[index][1], arr[i][1]);
            }
            else
            {
                index++;
                arr[index][0] = arr[i][0];
                arr[index][1] = arr[i][1];
            }
        }

        // Print merged intervals
        System.out.println("Merged Intervals:");
        for (int i = 0; i <= index; i++)
        {
            System.out.println("[" + arr[i][0] + ", " + arr[i][1] + "]");
        }
    }

    public static void main(String[] args)
    {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};

        mergeIntervals(arr);
    }
}
