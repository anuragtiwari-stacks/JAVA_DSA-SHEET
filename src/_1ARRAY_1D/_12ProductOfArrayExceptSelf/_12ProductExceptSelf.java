package _1ARRAY_1D._12ProductOfArrayExceptSelf;

public class _12ProductExceptSelf
{
    public static int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
        {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++)
        {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
            {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = productExceptSelf(nums1);
        printArray(result1);  // Output: 24 12 8 6

        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = productExceptSelf(nums2);
        printArray(result2);  // Output: 0 0 9 0 0
    }
}
