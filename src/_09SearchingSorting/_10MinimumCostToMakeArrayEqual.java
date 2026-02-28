package _09SearchingSorting;

/*
 PROBLEM: Minimum Cost to Make Array Equal (LeetCode 2448)

 CONCEPT: BRUTE FORCE (TRY ALL POSSIBLE TARGET VALUES)

 GIVEN:
 - nums[]  → array of values
 - cost[]  → cost to change nums[i] by 1 unit

 TASK:
 Make all elements of nums[] equal to some value x
 such that total cost is minimum.

 COST FORMULA:
 Total Cost = Σ |nums[i] - x| * cost[i]

 BRUTE FORCE IDEA:
 - Try making all elements equal to each nums[i]
 - Calculate total cost for that target
 - Return minimum cost among all possibilities

 WHY IT WORKS:
 Optimal target must be one of the values present in nums[]

 TIME COMPLEXITY:
 O(n^2)

 SPACE COMPLEXITY:
 O(1)
*/

public class _10MinimumCostToMakeArrayEqual
{
    public static long minCost(int[] nums, int[] cost)
    {
        long minCost = Long.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
        {
            long currentCost = 0;
            int target = nums[i];

            for (int j = 0; j < nums.length; j++)
            {
                currentCost += (long)Math.abs(nums[j] - target) * cost[j];
            }

            minCost = Math.min(minCost, currentCost);
        }

        return minCost;
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

 Try target = 1:
 cost = |1-1|*2 + |3-1|*3 + |5-1|*1 + |2-1|*14
      = 0 + 6 + 4 + 14
      = 24

 Try target = 3:
 cost = |1-3|*2 + |3-3|*3 + |5-3|*1 + |2-3|*14
      = 4 + 0 + 2 + 14
      = 20

 Try target = 5:
 cost = 8 + 6 + 0 + 42
      = 56

 Try target = 2:
 cost = 2 + 3 + 3 + 0
      = 8  ← MINIMUM

 OUTPUT:
 8
*/
