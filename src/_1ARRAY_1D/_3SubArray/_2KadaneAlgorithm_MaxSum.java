/*
Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

package _1ARRAY_1D._3SubArray;
public class _2KadaneAlgorithm_MaxSum
{
    public static int maxSubArray(int[] arr)
    {
        int maxSum = arr[0];
        int currentSum = 0;

        for (int x : arr)
        {
            currentSum = currentSum + x;

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }

            if (currentSum < 0)
            {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(nums1)); // Output: 6
        System.out.println(maxSubArray(nums2)); // Output: 1
        System.out.println(maxSubArray(nums3)); // Output: 23
    }
}

/*
Explanation of Kadane’s Algorithm:

Iterate through the array
Keep track of current subarray sum (currentSum)
Reset currentSum to zero if it becomes negative (because negative sums reduce the overall max sum)
Track the maximum sum found so far (maxSum)
*/


/*
| Index | Current Element | currentSum (after adding element) | maxSum (so far) | Explanation                     |
| ----- | --------------- | --------------------------------- | --------------- | ------------------------------- |
| 0     | -2              | 0 + (-2) = -2                     | -2              | currentSum = -2 < 0, reset to 0 |
| 1     | 1               | 0 + 1 = 1                         | 1               | maxSum updated (1 > -2)         |
| 2     | -3              | 1 + (-3) = -2                     | 1               | currentSum < 0, reset to 0      |
| 3     | 4               | 0 + 4 = 4                         | 4               | maxSum updated (4 > 1)          |
| 4     | -1              | 4 + (-1) = 3                      | 4               | maxSum stays 4                  |
| 5     | 2               | 3 + 2 = 5                         | 5               | maxSum updated (5 > 4)          |
| 6     | 1               | 5 + 1 = 6                         | 6               | maxSum updated (6 > 5)          |
| 7     | -5              | 6 + (-5) = 1                      | 6               | maxSum stays 6                  |
| 8     | 4               | 1 + 4 = 5                         | 6               | maxSum stays 6                  |
*/