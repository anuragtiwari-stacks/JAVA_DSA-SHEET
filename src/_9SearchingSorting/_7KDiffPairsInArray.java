package _9SearchingSorting;

/*
 PROBLEM: 532. K-diff Pairs in an Array

 CONCEPT: SORTING + TWO POINTERS

 GIVEN:
 - An integer array nums[]
 - An integer k

 TASK:
 Count the number of UNIQUE pairs (a, b) such that:
 |a - b| == k
 and each pair is counted only once.

 IMPORTANT POINTS:
 - Pair (a, b) is same as (b, a)
 - Duplicates in array should not create duplicate pairs
 - k >= 0

 APPROACH:
 1. Sort the array
 2. Use two pointers i and j (j > i)
 3. Calculate diff = nums[j] - nums[i]
 4. If diff == k:
      - count++
      - move both pointers
      - skip duplicates
 5. If diff < k → j++
 6. If diff > k → i++

 TIME COMPLEXITY:
 O(n log n)

 SPACE COMPLEXITY:
 O(1)
*/

import java.util.Arrays;

public class _7KDiffPairsInArray
{
    public static int findPairs(int[] nums, int k)
    {
        if (k < 0)
        {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0;
        int j = 1;
        int count = 0;

        while (i < nums.length && j < nums.length)
        {
            if (i == j)
            {
                j++;
                continue;
            }

            int diff = nums[j] - nums[i];

            if (diff == k)
            {
                count++;

                int val = nums[i];

                // skip duplicates of nums[i]
                while (i < nums.length && nums[i] == val)
                {
                    i++;
                }
            }
            else if (diff < k)
            {
                j++;
            }
            else
            {
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {3, 1, 4, 1, 5};
        int k1 = 2;

        System.out.println(findPairs(nums1, k1)); // 2
    }
}

/*
 DRY RUN:

 nums = {3, 1, 4, 1, 5}
 k = 2

 Step 1: Sort
 nums = {1, 1, 3, 4, 5}

 i = 0, j = 1
 diff = 1 - 1 = 0 < 2 → j++

 i = 0, j = 2
 diff = 3 - 1 = 2 == k → count = 1
 skip duplicates of 1 → i = 2

 i = 2, j = 2 → j++

 i = 2, j = 3
 diff = 4 - 3 = 1 < 2 → j++

 i = 2, j = 4
 diff = 5 - 3 = 2 == k → count = 2
 skip duplicates of 3 → i = 3

 LOOP ENDS

 OUTPUT:
 2
*/
