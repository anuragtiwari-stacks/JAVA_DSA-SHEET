/*
Given an arr[] containing n integers and a positive integer k,
he problem is to find the longest subarray's length with the sum of the elements divisible by k.

Examples:
Input: arr[] = [2, 7, 6, 1, 4, 5], k = 3
Output: 4
Explanation: The subarray [7, 6, 1, 4] has sum = 18, which is divisible by 3.

Input: arr[] = [-2, 2, -5, 12, -11, -1, 7], k = 3
Output: 5
Explanation: The subarray [2, -5, 12, -11, -1], has sum = -3, which is divisible by 3.
*/
package _1ARRAY_1D._18SumProblems;
public class _2LongestSubarraySumDivisible
{
    public static int longestSubarray(int[] arr, int k)
    {
        int maxLen = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            int sum = 0;
            for (int j = i; j < n; j++)
            {
                sum = sum + arr[j];

                if (sum % k == 0)
                {
                    int len = j - i + 1;
                    if (len > maxLen)
                    {
                        maxLen = len;
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;

        System.out.println(longestSubarray(arr, k)); // Output: 4
    }
}
