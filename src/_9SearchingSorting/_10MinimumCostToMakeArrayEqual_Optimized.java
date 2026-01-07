package _9SearchingSorting;

/*
 PROBLEM: Minimum Cost to Make Array Equal (LeetCode 2448)

 CONCEPT: SORT ARRAY (WITH COST) + BINARY SEARCH ON ANSWER

 IDEA:
 1. nums[] aur cost[] ka relation maintain karna zaroori hai
 2. Isliye (nums, cost) ko pair bana ke sort karte hain
 3. Minimum possible target = smallest nums value
 4. Maximum possible target = largest nums value
 5. Cost function convex hoti hai:
      f(x) = Σ |nums[i] - x| * cost[i]
 6. Convex function par binary search apply hota hai

 TIME COMPLEXITY:
 O(n log n + n log R)

 SPACE COMPLEXITY:
 O(n)
*/

import java.util.Arrays;

public class _10MinimumCostToMakeArrayEqual_Optimized
{
    // Calculate total cost for a target value
    public static long calculateCost(int[][] arr, int target)
    {
        long total = 0;

        for (int i = 0; i < arr.length; i++)
        {
            total += (long)Math.abs(arr[i][0] - target) * arr[i][1];
        }

        return total;
    }

    public static long minCost(int[] nums, int[] cost)
    {
        int n = nums.length;

        // Step 1: Make (nums, cost) pairs
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++)
        {
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        // Step 2: Sort pairs based on nums value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int low = arr[0][0];
        int high = arr[n - 1][0];

        // Step 3: Binary search on target value
        while (low < high)
        {
            int mid = low + (high - low) / 2;

            long costMid = calculateCost(arr, mid);
            long costMidPlus1 = calculateCost(arr, mid + 1);

            if (costMid <= costMidPlus1)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }

        return calculateCost(arr, low);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};

        System.out.println(minCost(nums, cost)); // 8
    }
}

/*
 DRY RUN:

 nums = {1, 3, 5, 2}
 cost = {2, 3, 1, 14}

 Step 1: Pairing
 arr = {
   {1, 2},
   {3, 3},
   {5, 1},
   {2, 14}
 }

 Step 2: Sort by nums
 arr = {
   {1, 2},
   {2, 14},
   {3, 3},
   {5, 1}
 }

 low = 1, high = 5

 mid = 3
 cost(3) = |1-3|*2 + |2-3|*14 + |3-3|*3 + |5-3|*1
         = 4 + 14 + 0 + 2
         = 20

 cost(4) = 24
 cost(3) <= cost(4) → high = 3

 mid = 2
 cost(2) = |1-2|*2 + |2-2|*14 + |3-2|*3 + |5-2|*1
         = 2 + 0 + 3 + 3
         = 8

 cost(3) = 20
 cost(2) <= cost(3) → high = 2

 low == high == 2

 OUTPUT:
 8
*/
