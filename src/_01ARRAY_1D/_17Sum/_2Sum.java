package _01ARRAY_1D._17Sum;

public class _2Sum
{
    public static boolean twoSum(int[] nums, int target)
    {
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 1, 7, 11, 8, 15};
        int target = 9;

        boolean ans = twoSum(nums, target);

        System.out.println(ans);  // true / false
    }
}