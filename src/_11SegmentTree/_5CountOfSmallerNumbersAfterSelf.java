package _11SegmentTree;

import java.util.*;

public class _5CountOfSmallerNumbersAfterSelf
{

    public static List<Integer> countSmaller(int[] nums)
    {
        int n = nums.length;
        Integer[] result = new Integer[n];

        for (int i = 0; i < n; i++)
        {
            int count = 0;

            for (int j = i + 1; j < n; j++)
            {
                if (nums[j] < nums[i])
                {
                    count++;
                }
            }

            result[i] = count;
        }

        return Arrays.asList(result);
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
}
