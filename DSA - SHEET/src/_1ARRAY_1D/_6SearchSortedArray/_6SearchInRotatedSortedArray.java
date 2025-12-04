/*
You have an ascending sorted array which might be rotated at some unknown pivot, e.g.,

Original sorted array:
[0, 1, 2, 4, 5, 6, 7]

Rotated at index 3:
[4, 5, 6, 7, 0, 1, 2]

Given a target value, return the index of target in this rotated array or -1 if not found.
*/

package _1ARRAY_1D._6SearchSortedArray;

public class _6SearchInRotatedSortedArray
{
    public static int search(int[] arr, int target)
    {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end)
        {
            int mid = start + (end - start) / 2;

            //Target found
            if (arr[mid] == target)
            {
                return mid;
            }

            // Left half is sorted
            if (arr[start] <= arr[mid])
            {
                if (target >= arr[start] && target < arr[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else if (arr[end] >= arr[mid])
            {
                if (target > arr[mid] && target <= arr[end])
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args)
    {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println(search(nums1, target1)); // Output: 4

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println(search(nums2, target2)); // Output: -1

        int[] nums3 = {1};
        int target3 = 0;
        System.out.println(search(nums3, target3)); // Output: -1
    }
}

/*
Key Insight:
Even though the array is rotated, one half of the array is always sorted.

By checking which half is sorted and whether the target lies in that half,
you can discard half of the search space every time — just like binary search.

Step-by-step Approach:
Initialize two pointers: start = 0, end = n - 1.

While start <= end:
Calculate mid = start + (end - start) / 2.
If nums[mid] == target, return mid.
Determine which half is sorted:
If nums[start] <= nums[mid], the left half is sorted.
Check if target lies between nums[start] and nums[mid].
If yes, move end = mid - 1.
Else, move start = mid + 1.
Else, the right half is sorted.
Check if target lies between nums[mid] and nums[end].
If yes, move start = mid + 1.
Else, move end = mid - 1.

If target not found, return -1.
*/