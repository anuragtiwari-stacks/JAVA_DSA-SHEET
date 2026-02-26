package _15BitManipulation;


// LeetCode 1356 - Sort Integers by The Number of 1 Bits

import java.util.*;

public class _5SortNumber_1Bits
{
    public static void main(String[] args)
    {
        int[] arr = {5, 3, 7, 8, 2};

        sortByBits(arr);

        System.out.println("Sorted Output:");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortByBits(int[] arr)
    {
        Integer[] nums = new Integer[arr.length];

        // Step 1: Convert int[] to Integer[]
        for(int i = 0; i < arr.length; i++)
        {
            nums[i] = arr[i];
        }

        // Step 2: Custom Sorting
        Arrays.sort(nums, (a, b) ->
        {
            int Count_A = Integer.bitCount(a);
            int Count_B = Integer.bitCount(b);

            if(Count_A == Count_B)
            {
                return a - b;
            }

            return Count_A - Count_B;
        });

        // Step 3: Copy back to int[]
        for(int i = 0; i < nums.length; i++)
        {
            arr[i] = nums[i];
        }

        return arr;
    }
}


/*

========================
        DRY RUN
========================

Input:
arr = {5, 3, 7, 8, 2}

Binary Representation:
5 → 101 → 2 ones
3 → 11  → 2 ones
7 → 111 → 3 ones
8 → 1000 → 1 one
2 → 10 → 1 one

Sorting Logic:
1️⃣ First compare number of 1 bits
2️⃣ If same → smaller number first

After sorting:
[2, 8, 3, 5, 7]

Time Complexity: O(n log n)
Space Complexity: O(n)

*/