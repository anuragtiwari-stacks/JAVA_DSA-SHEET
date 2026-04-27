package _01ARRAY_1D._17Sum;

import java.util.*;

public class TwoSum_Hashing
{
    public static List<List<Integer>> twoSum(int[] nums, int target)
    {
        Set<List<Integer>> result = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            int need = target - nums[i];

            if(set.contains(need))
            {
                List<Integer> pair = new ArrayList<>();
                pair.add(need);
                pair.add(nums[i]);

                Collections.sort(pair); // duplicate avoid
                result.add(pair);
            }

            set.add(nums[i]);
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        List<List<Integer>> ans = twoSum(nums, target);

        for(List<Integer> list : ans)
        {
            System.out.println(list);
        }
    }
}