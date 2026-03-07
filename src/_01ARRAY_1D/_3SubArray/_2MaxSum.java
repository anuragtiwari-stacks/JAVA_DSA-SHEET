package _01ARRAY_1D._3SubArray;

public class _2MaxSum
{
    public int maxSubArray(int[] arr)
    {
        int maxSum = arr[0];
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++)
        {
            currentSum = currentSum + arr[i];

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
            }

            if (currentSum < 0)
            {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args)
    {
        _2MaxSum sol = new _2MaxSum();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(sol.maxSubArray(nums1));
        System.out.println(sol.maxSubArray(nums2));
        System.out.println(sol.maxSubArray(nums3));
    }
}

