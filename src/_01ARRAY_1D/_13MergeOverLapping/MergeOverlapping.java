/*
Given an array of intervals arr[], where each interval is represented as [start, end],
merge all overlapping intervals and return an array of mutually exclusive intervals (no overlaps).
*/

package _01ARRAY_1D._13MergeOverLapping;

import java.util.*;

public class MergeOverlapping
{
    public static int[][] mergeIntervals(int[][] arr)
    {
        int n = arr.length;

        // 🔹 Step 1: sort using bubble sort (function call)
        bubbleSort(arr, n);

        // 🔹 Step 2: merge
        int[][] temp = new int[n][2];
        int index = 0;

        temp[0][0] = arr[0][0];
        temp[0][1] = arr[0][1];

        for (int i = 1; i < n; i++)
        {
            if (arr[i][0] <= temp[index][1])
            {
                temp[index][1] = Math.max(temp[index][1], arr[i][1]);
            }
            else
            {
                index++;
                temp[index][0] = arr[i][0];
                temp[index][1] = arr[i][1];
            }
        }

        // 🔹 Step 3: copy to result array
        int[][] result = new int[index + 1][2];

        for (int i = 0; i <= index; i++)
        {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }

        return result;
    }

    // 🔹 Bubble Sort function
    public static void bubbleSort(int[][] arr, int n)
    {
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j][0] > arr[j + 1][0])
                {
                    int tempStart = arr[j][0];
                    arr[j][0] = arr[j + 1][0];
                    arr[j + 1][0] = tempStart;

                    int tempEnd = arr[j][1];
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][1] = tempEnd;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};

        int[][] ans = mergeIntervals(arr);

        System.out.println("Merged Intervals:");
        for (int i = 0; i < ans.length; i++)
        {
            System.out.println("[" + ans[i][0] + ", " + ans[i][1] + "]");
        }
    }
}
