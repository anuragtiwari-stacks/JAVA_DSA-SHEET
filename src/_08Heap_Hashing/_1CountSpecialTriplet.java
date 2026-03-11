// 3583. Count Special Triplets
/*
PROBLEM DESCRIPTION

You are given an integer array nums.

A triplet (i, j, k) is called special if:

1. 0 <= i < j < k < nums.length
2. nums[i] = 2 * nums[j]
3. nums[k] = 2 * nums[j]

Return the number of special triplets in the array.

Since the answer may be very large, return it modulo 10^9 + 7.

EXAMPLE 1
Input: nums = [4,2,4]
Output: 1

Explanation:
The only special triplet is (0,1,2)
nums[0] = 4 = 2 * 2
nums[2] = 4 = 2 * 2


EXAMPLE 2
Input: nums = [1,2,3,4]
Output: 0

Explanation:
There is no triplet satisfying the condition.


EXAMPLE 3
Input: nums = [8,4,8,2,8]
Output: 3
*/

package _08Heap_Hashing;

import java.util.*;

public class _1CountSpecialTriplet
{
    public static int specialTriplets(int[] nums)
    {
        int MOD = 1000000007;

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // Count frequency of all elements in right map
        for (int x : nums)
        {
            if (right.containsKey(x))
            {
                right.put(x, right.get(x) + 1);
            }
            else
            {
                right.put(x, 1);
            }
        }

        long count = 0;

        for (int x : nums)
        {
            // Move current element from right to middle
            right.put(x, right.get(x) - 1);

            int need = x * 2;

            int leftCount = 0;
            if (left.containsKey(need))
            {
                leftCount = left.get(need);
            }
            else
            {
                leftCount = 0;
            }

            int rightCount = 0;
            if (right.containsKey(need))
            {
                rightCount = right.get(need);
            }
            else
            {
                rightCount = 0;
            }

            count = (count + (long) leftCount * rightCount) % MOD;

            // Add current element to left map
            if (left.containsKey(x))
            {
                left.put(x, left.get(x) + 1);
            }
            else
            {
                left.put(x, 1);
            }
        }

        return (int) count;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {4, 2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {8, 4, 8, 2, 8};

        System.out.println(specialTriplets(nums1));
        System.out.println(specialTriplets(nums2));
        System.out.println(specialTriplets(nums3));
    }
}


/*
========================
DRY RUN
========================

Example:
nums = [4,2,4]

Initial:

left  = {}
right = {4:2, 2:1}
count = 0

--------------------------------

Iteration 1
x = 4

Decrease right count
right = {4:1, 2:1}

need = 4 * 2 = 8

leftCount  = 0
rightCount = 0

count += 0 * 0 = 0

Add 4 to left
left = {4:1}

--------------------------------

Iteration 2
x = 2

Decrease right count
right = {4:1, 2:0}

need = 2 * 2 = 4

leftCount  = 1
rightCount = 1

count += 1 * 1 = 1

Add 2 to left
left = {4:1, 2:1}

--------------------------------

Iteration 3
x = 4

Decrease right count
right = {4:0, 2:0}

need = 4 * 2 = 8

leftCount  = 0
rightCount = 0

count += 0

--------------------------------

Final Answer = 1


========================
TIME COMPLEXITY
========================
O(n)

We traverse the array once and HashMap operations take O(1).

========================
SPACE COMPLEXITY
========================
O(n)

For storing frequencies in left and right maps.
*/