package _1ARRAY_1D;

/*
------------------------------------------------------------
LeetCode 414: Third Maximum Number
------------------------------------------------------------
Question:
Given an integer array nums, return the third distinct maximum
number in this array. If the third maximum does not exist,
return the maximum number.

Examples:
Input: nums = [3,2,1]
Output: 1

Input: nums = [1,2]
Output: 2

Input: nums = [2,2,3,1]
Output: 1
------------------------------------------------------------

Concept Used (Brute Force Approach):
1. Use a HashSet to remove duplicate elements.
2. Convert the HashSet into an ArrayList.
3. Sort the list in ascending order.
4. If at least 3 distinct elements exist, return the 3rd maximum.
5. Otherwise, return the maximum element.

Time Complexity:
O(n log n)

Space Complexity:
O(n)
------------------------------------------------------------
*/

import java.util.*;

public class _30ThirdMax
{
    public static int thirdMax(int[] nums)
    {
        // Step 1: Remove duplicates
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            set.add(num);
        }

        // Step 2: Convert set to list
        List<Integer> list = new ArrayList<>(set);

        // Step 3: Sort the list
        Collections.sort(list);

        int size = list.size();

        // Step 4: Return the result
        if (size >= 3)
        {
            return list.get(size - 3);
        }
        else
        {
            return list.get(size - 1);
        }
    }

    // Main method for testing in IDE
    public static void main(String[] args)
    {
        int[] nums1 = {3, 2, 1};
        int[] nums2 = {1, 2};
        int[] nums3 = {2, 2, 3, 1};

        System.out.println(thirdMax(nums1)); // 1
        System.out.println(thirdMax(nums2)); // 2
        System.out.println(thirdMax(nums3)); // 1
    }
}
