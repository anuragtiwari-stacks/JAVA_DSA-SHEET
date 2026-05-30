package _08Heap_Hashing;

import java.util.*;

// LeetCode 3940 - Limit Occurrences in Sorted Array

public class _4LimitOccurrences
{
    public static void main(String[] args)
    {
        int[] nums = {29, 35};
        int k = 2;

        int[] ans = limitOccurrences(nums, k);

        System.out.println(Arrays.toString(ans));
    }

    public static int[] limitOccurrences(int[] nums, int k)
    {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(nums[i]))
            {
                int freq = map.get(nums[i]);
                map.put(nums[i], freq + 1);
            }
            else
            {
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet())
        {
            if (map.get(key) > k)
            {
                map.put(key, k);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int key : map.keySet())
        {
            int freq = map.get(key);

            while (freq > 0)
            {
                list.add(key);
                freq--;
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }

        return ans;
    }
}