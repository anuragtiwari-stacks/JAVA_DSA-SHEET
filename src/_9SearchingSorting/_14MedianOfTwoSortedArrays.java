package _9SearchingSorting;

// Median of Two Sorted Arrays (Merge Method)
public class _14MedianOfTwoSortedArrays
{
    public static double findMedian(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;

        int[] merged = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // merge both sorted arrays
        while (i < m && j < n)
        {
            if (nums1[i] <= nums2[j])
            {
                merged[k++] = nums1[i++];
            }
            else
            {
                merged[k++] = nums2[j++];
            }
        }

        // remaining elements of nums1
        while (i < m)
        {
            merged[k++] = nums1[i++];
        }

        // remaining elements of nums2
        while (j < n)
        {
            merged[k++] = nums2[j++];
        }

        int len = m + n;

        // odd length
        if (len % 2 == 1)
        {
            return merged[len / 2];
        }

        // even length
        return (merged[len / 2 - 1] + merged[len / 2]) / 2.0;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};

        System.out.println(findMedian(nums1, nums2));
    }
}

/*
==================== DRY RUN ====================

nums1 = [1, 3]
nums2 = [2, 4]

After merge:
merged = [1, 2, 3, 4]

Total length = 4 (even)

Median =
(merged[1] + merged[2]) / 2
= (2 + 3) / 2
= 2.5

===============================================
*/
