package _01ARRAY_1D._9Repeat_and_Missing;

import java.util.HashSet;

public class _9UniqueNumber
{
    public static void printUnique(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
        {
            set.add(num);
        }

        System.out.print("Elements in HashSet: ");
        for (int num : set)
        {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 2, 5, 3, 6, 1, 7};

        printUnique(nums);
    }
}