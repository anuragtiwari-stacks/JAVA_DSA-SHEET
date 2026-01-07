package _9SearchingSorting;

/*
 PROBLEM: 55. Jump Game

 CONCEPT: GREEDY APPROACH (Maximum Reach)

 GIVEN:
 - nums[] array
 - Each element represents maximum jump length from that index
 - Start from index 0
 - Check if last index can be reached

 IDEA:
 We maintain the FARTHHEST index we can reach so far.

 STEPS:
 1. Initialize maxReach = 0
 2. Traverse array from index 0
 3. If current index > maxReach → cannot move further → return false
 4. Update maxReach = max(maxReach, i + nums[i])
 5. If maxReach >= last index → return true

 WHY GREEDY WORKS:
 At every step, we choose the option that gives us
 the maximum possible reach.

 TIME COMPLEXITY:
 O(n)

 SPACE COMPLEXITY:
 O(1)
*/

public class _5JumpGame
{
    public static boolean canJump(int[] nums)
    {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (i > maxReach)
            {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1)
            {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
    }
}

/*
 DRY RUN:

 Example 1:
 nums = {2, 3, 1, 1, 4}

 i = 0 → maxReach = max(0, 0+2) = 2
 i = 1 → maxReach = max(2, 1+3) = 4
 maxReach >= last index → TRUE

 OUTPUT: true


 Example 2:
 nums = {3, 2, 1, 0, 4}

 i = 0 → maxReach = 3
 i = 1 → maxReach = 3
 i = 2 → maxReach = 3
 i = 3 → maxReach = 3
 i = 4 → i > maxReach → FALSE

 OUTPUT: false
*/
