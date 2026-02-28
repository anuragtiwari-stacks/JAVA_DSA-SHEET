package _09SearchingSorting;

/*
 PROBLEM: 581. Shortest Unsorted Continuous Subarray

 CONCEPT: FIND OUT-OF-ORDER BOUNDARIES

 GIVEN:
 - An integer array nums[]
 - We need to find the shortest subarray which,
   if sorted, makes the whole array sorted.

 IDEA:
 1. Traverse from LEFT to RIGHT
    - Track maximum element so far
    - If current element < max → it's out of order
      → update right boundary

 2. Traverse from RIGHT to LEFT
    - Track minimum element so far
    - If current element > min → it's out of order
      → update left boundary

 3. Length = right - left + 1

 EDGE CASE:
 If array is already sorted → return 0

 TIME COMPLEXITY:
 O(n)

 SPACE COMPLEXITY:
 O(1)
*/

public class _11ShortestUnsortedSubarray
{
    public static int findUnsortedSubarray(int[] nums)
    {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int right = -1;

        // Step 1: Find right boundary
        for (int i = 0; i < n; i++)
        {
            if (nums[i] < max)
            {
                right = i;
            }
            else
            {
                max = nums[i];
            }
        }

        int min = Integer.MAX_VALUE;
        int left = -1;

        // Step 2: Find left boundary
        for (int i = n - 1; i >= 0; i--)
        {
            if (nums[i] > min)
            {
                left = i;
            }
            else
            {
                min = nums[i];
            }
        }

        if (right == -1)
        {
            return 0;
        }

        return right - left + 1;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {2, 6, 4, 8, 10, 9, 15};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(findUnsortedSubarray(nums1)); // 5
        System.out.println(findUnsortedSubarray(nums2)); // 0
    }
}

/*
 DRY RUN:

 nums = {2, 6, 4, 8, 10, 9, 15}

 LEFT → RIGHT:
 max = 2
 6 > 2 → max = 6
 4 < 6 → right = 2
 8 > 6 → max = 8
 10 > 8 → max = 10
 9 < 10 → right = 5

 RIGHT → LEFT:
 min = 15
 9 < 15 → min = 9
 10 > 9 → left = 4
 8 < 9 → min = 8
 4 < 8 → min = 4
 6 > 4 → left = 1

 left = 1, right = 5

 Length = 5 - 1 + 1 = 5

 OUTPUT:
 5
*/
