package _01ARRAY_1D._10KthElement;

public class KthLargestWithBubbleSort
{
    public static int findKthLargest(int[] nums, int k)
    {
        int n = nums.length;

        // Bubble Sort (descending order)
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (nums[j] < nums[j + 1])
                {
                    // Swap nums[j] and nums[j + 1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        // kth largest element is at index k - 1 after sorting in descending order
        return nums[k - 1];
    }

    public static void main(String[] args)
    {
        int[] nums1 = { 3, 2, 1, 5, 6, 4 };
        int k1 = 2;

        int result1 = findKthLargest(nums1, k1);
        System.out.println("Kth largest element is: " + result1);  // Output: 5

        int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k2 = 4;

        int result2 = findKthLargest(nums2, k2);
        System.out.println("Kth largest element is: " + result2);  // Output: 4
    }

}
