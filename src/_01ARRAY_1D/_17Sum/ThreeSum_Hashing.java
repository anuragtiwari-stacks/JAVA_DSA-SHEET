package _01ARRAY_1D._17Sum;

import java.util.*;

public class ThreeSum_Hashing
{
    public static List<List<Integer>> threeSum(int[] nums, int target)
    {
        HashSet<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            Set<Integer> set = new HashSet<>();

            for(int j = i + 1; j < nums.length; j++)
            {
                int need = target - (nums[i] + nums[j]);

                if(set.contains(need))
                {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(need);

                    Collections.sort(triplet); // duplicate remove
                    result.add(triplet);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<List<Integer>>(result);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, -2, -1, 0, 3};
        int target = 2;

        List<List<Integer>> ans = threeSum(nums, target);

        for(List<Integer> list : ans)
        {
            System.out.println(list);
        }
    }
}