package _01ARRAY_1D._17Sum;

public class _3Sum
{
    public static boolean threeSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length - 2; i++)
        {
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                for (int k = j + 1; k < nums.length; k++)
                {
                    if (nums[i] + nums[j] + nums[k] == target)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 1, 6, 4, 3, 5};
        int target = 9;

        boolean ans = threeSum(nums, target);

        System.out.println(ans);
    }
}