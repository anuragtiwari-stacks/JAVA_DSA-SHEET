package _08Heap_Hashing;

import java.util.*;

/*
First Unique Even Number

Given an integer array nums, return the first even number that appears exactly once.
If no such number exists, return -1.

Example 1:
Input: nums = [1,2,3,2,4,5]
Output: 4
Explanation:
2 appears twice, so it is not unique.
4 appears once and is even, so answer = 4.

Example 2:
Input: nums = [1,3,5,7]
Output: -1
Explanation:
There are no even numbers.

Example 3:
Input: nums = [2,4,6,4,2]
Output: 6
Explanation:
2 appears twice
4 appears twice
6 appears once → first unique even number

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
*/

public class _3FirstUniqueEven
{
    public static int firstUniqueEven(int[] nums)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = nums.length;

        // count frequency of each number
        for(int i = 0; i < n; i++)
        {
            int x = nums[i];

            if(freq.containsKey(x))
            {
                freq.put(x, freq.get(x) + 1);
            }
            else
            {
                freq.put(x, 1);
            }
        }

        // find first unique even number
        for(int i = 0; i < n; i++)
        {
            int x = nums[i];

            if(x % 2 == 0 && freq.get(x) == 1)
            {
                return x;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,2,4,5}; // sample input

        int ans = firstUniqueEven(nums);

        System.out.println("First Unique Even Number: " + ans);
    }
}

/*
DRY RUN

Input:
nums = [1,2,3,2,4,5]

Step 1: Count frequency
1 -> 1
2 -> 2
3 -> 1
4 -> 1
5 -> 1

Frequency Map:
{1=1, 2=2, 3=1, 4=1, 5=1}

Step 2: Traverse array again

i=0 → 1
odd → skip

i=1 → 2
even but freq=2 → skip

i=2 → 3
odd → skip

i=3 → 2
even but freq=2 → skip

i=4 → 4
even and freq=1 → return 4

Output:
First Unique Even Number: 4
*/