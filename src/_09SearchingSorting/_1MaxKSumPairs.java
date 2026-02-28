package _09SearchingSorting;

/*
 PROBLEM: 1679. Max Number of K-Sum Pairs

 CONCEPT:
 We are given an integer array nums[] and an integer k.
 We need to find the maximum number of operations such that:
 - In each operation, pick two numbers whose sum is equal to k
 - Remove both numbers from the array
 - Each element can be used only once

 APPROACH: TWO POINTERS (Greedy)

 Steps:
 1. Sort the array
 2. Use two pointers:
    - left at start
    - right at end
 3. If nums[left] + nums[right] == k
    - count++
    - move both pointers
 4. If sum < k → left++
 5. If sum > k → right--

 TIME COMPLEXITY:
 O(n log n)

 SPACE COMPLEXITY:
 O(1) extra space
*/

import java.util.Arrays;

public class _1MaxKSumPairs
{
    public static int maxOperations(int[] nums, int k)
    {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right)
        {
            int sum = nums[left] + nums[right];

            if (sum == k)
            {
                count++;
                left++;
                right--;
            }
            else if (sum < k)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4};
        int k = 5;

        System.out.println("Max Operations: " + maxOperations(nums, k));
    }
}

/*
 DRY RUN:

 nums = {1, 2, 3, 4}
 k = 5

 After Sorting:
 {1, 2, 3, 4}

 Step 1:
 left = 0 (1), right = 3 (4)
 sum = 5 → valid pair
 count = 1

 Step 2:
 left = 1 (2), right = 2 (3)
 sum = 5 → valid pair
 count = 2

 Final Answer:
 Max Operations = 2
*/
