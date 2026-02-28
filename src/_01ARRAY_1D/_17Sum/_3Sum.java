package _01ARRAY_1D._17Sum;

import java.util.*;

public class _3Sum
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0)
                {
                    j++;
                }
                else if (sum > 0)
                {
                    k--;
                }
                else
                {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                    {
                        j++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> result = threeSum(nums);

        System.out.println("Triplets with sum 0:");
        System.out.println(result);
    }
}
