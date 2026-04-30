package _01ARRAY_1D;

import java.util.*;

public class _31RangeFrequencyQueries
{
    public static void main(String[] args)
    {
        int[] nums = {1, 1, 2, 1, 3};
        int[][] queries = {{1, 5}, {2, 4}};
        int k = 1;

        // 🔹 Step 1: convert queries to 0-based
        for (int i = 0; i < queries.length; i++)
        {
            queries[i][0]--;
            queries[i][1]--;
        }

        // 🔹 Step 2: process queries
        for (int q = 0; q < queries.length; q++)
        {
            int L = queries[q][0];
            int R = queries[q][1];

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = L; i <= R; i++)
            {
                if (map.containsKey(nums[i]))
                {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
                else
                {
                    map.put(nums[i], 1);
                }
            }

            int count = 0;

            for (Integer key : map.keySet())
            {
                if (map.get(key) >= k)
                {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}