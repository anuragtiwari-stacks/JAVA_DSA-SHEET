package _1ARRAY_1D._3SubArray;

public class _3MaxProduct
{
    public static int maxProduct(int[] nums)
    {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            int current = nums[i];

            if (current < 0)
            {
                // Swap max and min when multiplied by a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {-2, 0, -1};      // Expected: 0
        int[] nums2 = {1};              // Expected: 1
        int[] nums3 = {2, 3, -2, 4};    // Expected: 6
        int[] nums4 = {5, 4, -1, 7, 8}; // Expected: 1120

        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
        System.out.println(maxProduct(nums4));
    }
}
