package _9SearchingSorting;

/*
 PROBLEM: 75. Sort Colors

 CONCEPT: COUNTING SORT (Frequency Method)

 We are given an array nums[] consisting only of:
 0 → Red
 1 → White
 2 → Blue

 Task:
 Sort the array in-place so that all 0s come first,
 then 1s, and then 2s.

 APPROACH:
 Since the values are limited (0, 1, 2),
 we can count their frequencies and overwrite the array.

 STEPS:
 1. Count number of 0s, 1s, and 2s
 2. Rewrite the array in order:
    - first all 0s
    - then all 1s
    - then all 2s

 TIME COMPLEXITY:
 O(n)

 SPACE COMPLEXITY:
 O(1)
*/

public class _2SortColors
{
    public static void sortColors(int[] nums)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Step 1: Count frequency
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                count0++;
            }
            else if (nums[i] == 1)
            {
                count1++;
            }
            else
            {
                count2++;
            }
        }

        // Step 2: Overwrite array
        int index = 0;

        while (count0 > 0)
        {
            nums[index++] = 0;
            count0--;
        }

        while (count1 > 0)
        {
            nums[index++] = 1;
            count1--;
        }

        while (count2 > 0)
        {
            nums[index++] = 2;
            count2--;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }
}

/*
 DRY RUN:

 nums = {2, 0, 2, 1, 1, 0}

 Step 1: Counting
 count0 = 2
 count1 = 2
 count2 = 2

 Step 2: Rewrite
 index = 0

 Place 0s:
 nums = {0, 0, _, _, _, _}

 Place 1s:
 nums = {0, 0, 1, 1, _, _}

 Place 2s:
 nums = {0, 0, 1, 1, 2, 2}

 OUTPUT:
 0 0 1 1 2 2
*/
