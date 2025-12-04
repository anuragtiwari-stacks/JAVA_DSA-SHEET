package _1ARRAY_1D._6SearchSortedArray;

public class _6MinInRotatedSortedArray
{
    public static int findMin(int[] arr)
    {

        int start = 0;
        int end = arr.length - 1;
        int ans = Integer.MAX_VALUE;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            // Check if left half is sorted
            if (arr[start] <= arr[mid])
            {
                // Since left half is sorted, Minimum must be in right half, so move low pointer
                ans = Math.min(ans, arr[start]);
                start = mid + 1;
            }
            else
            {
                // Right half is unsorted, minimum lies here
                ans = Math.min(ans, arr[mid]);
                // Narrow down to left half to find smaller elements
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};

        System.out.println(findMin(nums1)); // Output: 0
        System.out.println(findMin(nums2)); // Output: 1
        System.out.println(findMin(nums3)); // Output: 11
    }
}
