package _01ARRAY_1D;

public class _23Optimized
{
    public static int specialTriplets(int[] nums)
    {
        int n = nums.length;
        int count = 0;

        for (int j = 0; j < n; j++)
        {
            int leftCount = 0;
            int rightCount = 0;

            for (int i = 0; i < j; i++)
            {
                if (nums[i] == 2 * nums[j])
                {
                    leftCount++;
                }
            }

            for (int k = j + 1; k < n; k++)
            {
                if (nums[k] == 2 * nums[j])
                {
                    rightCount++;
                }
            }

            count += leftCount * rightCount;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 2, 4, 8, 4};

        int result = specialTriplets(nums);
        System.out.println("Special Triplets Count = " + result);
    }
}
