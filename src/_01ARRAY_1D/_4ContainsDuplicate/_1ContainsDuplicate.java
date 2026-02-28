/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Examples:
Example 1:
Input: nums = [1, 2, 3, 1]
Output: true
Explanation: The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1, 2, 3, 4]
Output: false
Explanation: All elements are distinct.

Example 3:
Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true
*/

package _01ARRAY_1D._4ContainsDuplicate;

import java.util.HashSet;

public class _1ContainsDuplicate
{
    public static boolean containsDuplicate(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums)
        {
            if (set.contains(i))
            {
                return true;  // Duplicate found
            }

            set.add(i);  // Add new number to the set
        }

        return false;  // No duplicates found
    }

        public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1));  // true
        System.out.println(containsDuplicate(nums2));  // false
        System.out.println(containsDuplicate(nums3));  // true
    }
}

/*
| Iteration | Value of `i` | `set.contains(i)` | Action Taken                     | `set` After Action |
| --------- | ------------ | ----------------- | -------------------------------- | ------------------ |
| 1         | 1            | false             | Add 1 to the set                 | {1}                |
| 2         | 2            | false             | Add 2 to the set                 | {1, 2}             |
| 3         | 3            | false             | Add 3 to the set                 | {1, 2, 3}          |
| 4         | 1            | **true**          | Return `true` (duplicate found!) | (loop exits here)  |
*/