package _5StackQueue;

import java.util.Stack;

public class _10SumOfSubarrayRanges
{
    /*
    LOGIC:
    ------
    Sum of Subarray Ranges =
    (Sum of all subarray maximums)
    -
    (Sum of all subarray minimums)

    Contribution Idea:
    ------------------
    Har element nums[i] ka contribution count karte hain:

    As MIN:
      nums[i] * leftMin * rightMin

    As MAX:
      nums[i] * leftMax * rightMax

    Steps:
    ------
    1. Monotonic stack se leftMin, rightMin nikaalo.
    2. Monotonic stack se leftMax, rightMax nikaalo.
    3. SumMax - SumMin return karo.
    */

    public static long subArrayRanges(int[] nums)
    {
        int n = nums.length;

        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        Stack<Integer> stack = new Stack<>();

        // -------- LEFT MIN --------
        for (int i = 0; i < n; i++)
        {
            int count = 1;

            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
            {
                count = count + leftMin[stack.pop()];
            }

            leftMin[i] = count;
            stack.push(i);
        }

        stack.clear();

        // -------- RIGHT MIN --------
        for (int i = n - 1; i >= 0; i--)
        {
            int count = 1;

            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i])
            {
                count = count + rightMin[stack.pop()];
            }

            rightMin[i] = count;
            stack.push(i);
        }

        stack.clear();

        // -------- LEFT MAX --------
        for (int i = 0; i < n; i++)
        {
            int count = 1;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
            {
                count = count + leftMax[stack.pop()];
            }

            leftMax[i] = count;
            stack.push(i);
        }

        stack.clear();

        // -------- RIGHT MAX --------
        for (int i = n - 1; i >= 0; i--)
        {
            int count = 1;

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i])
            {
                count = count + rightMax[stack.pop()];
            }

            rightMax[i] = count;
            stack.push(i);
        }

        long sumMin = 0;
        long sumMax = 0;

        for (int i = 0; i < n; i++)
        {
            sumMin = sumMin + nums[i] * leftMin[i] * rightMin[i];
            sumMax = sumMax + nums[i] * leftMax[i] * rightMax[i];
        }

        return sumMax - sumMin;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};
        System.out.println(subArrayRanges(nums));
    }
}

/*
DRY RUN:
--------

nums = [1, 2, 3]
index:   0  1  2

Final Arrays:

leftMin  = [1, 1, 1]
rightMin = [3, 2, 1]

leftMax  = [1, 2, 3]
rightMax = [1, 1, 1]

-------------------------
Contribution as MIN:
-------------------------
i = 0 → 1 * 1 * 3 = 3
i = 1 → 2 * 1 * 2 = 4
i = 2 → 3 * 1 * 1 = 3
sumMin = 10

-------------------------
Contribution as MAX:
-------------------------
i = 0 → 1 * 1 * 1 = 1
i = 1 → 2 * 2 * 1 = 4
i = 2 → 3 * 3 * 1 = 9
sumMax = 14

-------------------------
FINAL ANSWER:
-------------------------
14 - 10 = 4
*/
