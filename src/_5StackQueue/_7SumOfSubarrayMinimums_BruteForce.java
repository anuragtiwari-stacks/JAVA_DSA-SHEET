package _5StackQueue;

public class _7SumOfSubarrayMinimums_BruteForce
{
    /*
    LOGIC (Brute Force):
    -------------------
    1. Generate all possible subarrays.
    2. For each subarray, find the minimum element.
    3. Add all minimums to the sum.
    4. Return sum modulo (1e9 + 7).
    */

    public static int sumSubarrayMins(int[] arr)
    {
        int n = arr.length;

        long sum = 0;

        for (int i = 0; i < n; i++)
        {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < n; j++)
            {
                min = Math.min(min, arr[j]);
                sum = (sum + min);
            }
        }

        return (int) sum;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
}

/*
DRY RUN:
--------

arr = [3, 1, 2, 4]

i = 0:
subarray [3]        min = 3   sum = 3
subarray [3,1]      min = 1   sum = 4
subarray [3,1,2]    min = 1   sum = 5
subarray [3,1,2,4]  min = 1   sum = 6

i = 1:
subarray [1]        min = 1   sum = 7
subarray [1,2]      min = 1   sum = 8
subarray [1,2,4]    min = 1   sum = 9

i = 2:
subarray [2]        min = 2   sum = 11
subarray [2,4]      min = 2   sum = 13

i = 3:
subarray [4]        min = 4   sum = 17

FINAL ANSWER:
-------------
17
*/
