/*
Given an array arr[] of n integers where arr[i] represents the number of chocolates in the ith packet,
and m students, distribute the packets such that:

Each student gets exactly one packet.

The difference between the maximum and minimum chocolates in the packets given to the students is minimized.

Examples:
Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3
Output: 2
Explanation: Distributing packets {3, 2, 4} gives a minimum difference 4 - 2 = 2.

Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 5
Output: 7
Explanation: Distributing packets {3, 2, 4, 9, 7} gives minimum difference 9 - 2 = 7.
*/

package _01ARRAY_1D._5ChocolateDistribution;

import java.util.Arrays;

public class ChocolateDistributionProblem
{
    public static int findMinDiff(int[] arr, int m)
    {
        int n = arr.length;

        if (m == 0 || n == 0)
        {
            return 0;
        }

        if (m > n)
        {
            return -1; // Not enough packets for all students
        }

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n - m; i++)
        {
            int diff = arr[i + m - 1] - arr[i];

            if (diff < minDiff)
            {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args)
    {
        int[] arr1 = {7, 3, 2, 4, 9, 12, 56};
        int m1 = 3;
        System.out.println(findMinDiff(arr1, m1)); // Output: 2

        int[] arr2 = {7, 3, 2, 4, 9, 12, 56};
        int m2 = 5;
        System.out.println(findMinDiff(arr2, m2)); // Output: 7
    }
}

/*
Logic Explanation:
Sort the array first.

This arranges packets in increasing order of chocolates.
When packets are sorted, the packets with the closest number of chocolates will be next to each other.

We want to pick m packets such that the difference between the largest and smallest packet
in the chosen group is minimized.

After sorting, the problem reduces to finding a window (subarray) of size m with the
smallest difference between the last and first elements.

We slide this window of size m from the start to the end of the sorted array:

Calculate the difference between the last and first element in the window.

Keep track of the minimum difference found.

Return the minimum difference.
*/

/*
Example to visualize:

arr = {7, 3, 2, 4, 9, 12, 56}, m = 3
After sorting: {2, 3, 4, 7, 9, 12, 56}

Check windows of size 3:
| Window      | Difference = max - min |
| ----------- | ---------------------- |
| {2, 3, 4}   | 4 - 2 = 2              |
| {3, 4, 7}   | 7 - 3 = 4              |
| {4, 7, 9}   | 9 - 4 = 5              |
| {7, 9, 12}  | 12 - 7 = 5             |
| {9, 12, 56} | 56 - 9 = 47            |

Minimum difference = 2 → answer
*/


/*
int[] arr = {7, 3, 2, 4, 9, 12, 56};
int m = 3;

arr = {2, 3, 4, 7, 9, 12, 56};

n = arr.length = 7
minDiff = Integer.MAX_VALUE
m = 3

for (int i = 0; i <= n - m; i++) → i = 0 to 4

| i | Group Selected (arr\[i] to arr\[i+m-1]) | arr\[i] | arr\[i+m-1] | diff            | minDiff Before | Condition  | minDiff After |
| - | --------------------------------------- | ------- | ----------- | --------------- | -------------- | ---------- | ------------- |
| 0 | {2, 3, 4}                               | 2       | 4           | 4 - 2 = **2**   | ∞              | 2 < ∞ → ✅  | **2**         |
| 1 | {3, 4, 7}                               | 3       | 7           | 7 - 3 = **4**   | 2              | 4 < 2 → ❌  | 2             |
| 2 | {4, 7, 9}                               | 4       | 9           | 9 - 4 = **5**   | 2              | 5 < 2 → ❌  | 2             |
| 3 | {7, 9, 12}                              | 7       | 12          | 12 - 7 = **5**  | 2              | 5 < 2 → ❌  | 2             |
| 4 | {9, 12, 56}                             | 9       | 56          | 56 - 9 = **47** | 2              | 47 < 2 → ❌ | 2             |
*/