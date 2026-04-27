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
package _01ARRAY_1D._3SubArray;

public class _2KadaneAlgorithm_MaxSum
{
    public static int maxSubArray(int[] arr)
    {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++)
        {
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(nums1)); // 6
        System.out.println(maxSubArray(nums2)); // 1
        System.out.println(maxSubArray(nums3)); // 23
    }
}

/*
🔢 DRY RUN (nums1 = [-2,1,-3,4,-1,2,1,-5,4])

Initial:
maxSum = -2
currentSum = -2

Step-by-step:

i=1 → 1
currentSum = max(1, -2+1) = 1
maxSum = 1

i=2 → -3
currentSum = max(-3, 1-3) = -2
maxSum = 1

i=3 → 4
currentSum = max(4, -2+4) = 4
maxSum = 4

i=4 → -1
currentSum = max(-1, 4-1) = 3
maxSum = 4

i=5 → 2
currentSum = max(2, 3+2) = 5
maxSum = 5

i=6 → 1
currentSum = max(1, 5+1) = 6
maxSum = 6

i=7 → -5
currentSum = max(-5, 6-5) = 1
maxSum = 6

i=8 → 4
currentSum = max(4, 1+4) = 5
maxSum = 6

Final Answer = 6

Best Subarray = [4, -1, 2, 1]
*/
