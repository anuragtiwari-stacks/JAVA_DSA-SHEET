package _1ARRAY_1D._3SubArray;

public class _2MaxSum
{
    public int maxSubArray(int[] arr)
    {
        int maxSum = arr[0];
        int currentSum = 0;

        int start = 0;
        int tempStart = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++)
        {
            currentSum = currentSum + arr[i];

            if (currentSum > maxSum)
            {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0)
            {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
        System.out.print("Maximum Subarray: ");

        for (int i = start; i <= end; i++)
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        return maxSum;
    }

    public static void main(String[] args)
    {
        _2MaxSum sol = new _2MaxSum();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        sol.maxSubArray(nums1);
        sol.maxSubArray(nums2);
        sol.maxSubArray(nums3);
    }
}
