package _01ARRAY_1D._9Repeat_and_Missing;

import java.util.HashMap;
import java.util.Map;

public class _9UniqueNumber
{
    public static void printUnique(int[] nums)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each element
        for (int num : nums)
        {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        System.out.print("Unique elements: ");

        // Print elements with frequency = 1
        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            if (entry.getValue() == 1)
            {
                System.out.print(entry.getKey() + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 3, 4, 2, 5, 3, 6, 1, 7 };

        printUnique(nums);
    }
}
