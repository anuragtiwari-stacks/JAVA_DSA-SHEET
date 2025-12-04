/*
MO's Algorithm (Query Square Root Decomposition) |
Let us consider the following problem to understand MO's Algorithm.
We are given an array and a set of query ranges,
we are required to find the sum of every query range.

Example:

Input:  arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        query[] = [0, 4], [1, 3] [2, 4]
Output: Sum of arr[] elements in range [0, 4] is 8
        Sum of arr[] elements in range [1, 3] is 4
        Sum of arr[] elements in range [2, 4] is 6
*/
package _1ARRAY_1D._20MO_Algorithm;

public class RangeSumQueries
{
    public static int querySum(int[] arr, int L, int R)
    {
        int sum = 0;
        for (int i = L; i <= R; i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 1, 2, 1, 3, 4, 5, 2, 8};

        int[][] queries = {{0, 4}, {1, 3}, {2, 4}};

        for (int i = 0; i < queries.length; i++)
        {
            int L = queries[i][0];
            int R = queries[i][1];
            int result = querySum(arr, L, R);
            System.out.println("Sum of arr[] elements in range [" + L + ", " + R + "] is " + result);
        }
    }
}
