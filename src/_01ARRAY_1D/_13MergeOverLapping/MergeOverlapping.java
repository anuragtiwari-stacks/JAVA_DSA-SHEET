/*
LeetCode 56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals and return an array of the non-overlapping intervals
that cover all the intervals in the input.

Approach:
1. Sort the intervals based on the starting point.
2. Keep the first interval as the current interval.
3. Traverse the remaining intervals.
4. If the current interval overlaps with the next interval,
   merge them by updating the ending point.
5. Otherwise, add the current interval to the answer
   and make the next interval the current interval.
6. Finally, add the last current interval.

Time Complexity : O(n log n)
Space Complexity: O(n)
*/

package _01ARRAY_1D._13MergeOverLapping;

import java.util.*;

public class MergeOverlapping
{
    public static int[][] mergeIntervals(int[][] arr)
    {
        // Step 1 : Sort according to starting point
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2 : Store merged intervals
        List<int[]> list = new ArrayList<>();

        // Step 3 : Take first interval as current
        int[] current = arr[0];

        // Step 4 : Traverse remaining intervals
        for (int i = 1; i < arr.length; i++)
        {
            // Overlapping interval
            if (current[1] >= arr[i][0])
            {
                current[1] = Math.max(current[1], arr[i][1]);
            }
            // Non-overlapping interval
            else
            {
                list.add(current);
                current = arr[i];
            }
        }

        // Step 5 : Add last interval
        list.add(current);

        // Step 6 : Convert List<int[]> to int[][]
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args)
    {
        int[][] arr =
                {
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                };

        int[][] ans = mergeIntervals(arr);

        System.out.println("Merged Intervals:");

        for (int i = 0; i < ans.length; i++)
        {
            System.out.println("[" + ans[i][0] + ", " + ans[i][1] + "]");
        }
    }
}