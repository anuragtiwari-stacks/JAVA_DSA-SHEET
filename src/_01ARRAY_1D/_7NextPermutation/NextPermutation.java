package _01ARRAY_1D._7NextPermutation;/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical
larger rearrangement.
*/
import java.util.*;

public class NextPermutation
{
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};

        System.out.print("Original array: ");
        printArray(nums);

        nextPermutation(nums);

        System.out.print("Next permutation: ");
        printArray(nums);
    }

    public static void nextPermutation(int[] nums)
    {
        int n = nums.length;

        // 🔹 Step 1: Find pivot using for loop
        int i;
        for (i = n - 2; i >= 0; i--)
        {
            if (nums[i] < nums[i + 1])
            {
                break;
            }
        }

        // 🔹 Step 2: Find successor using for loop
        if (i >= 0)
        {
            int j;
            for (j = n - 1; j > i; j--)
            {
                if (nums[j] > nums[i])
                {
                    break;
                }
            }
            swap(nums, i, j);
        }

        // 🔹 Step 3: Reverse right part
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end)
    {
        while (start < end)
        {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void printArray(int[] arr)
    {
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
🔢 Steps to Find Next Permutation:
Find the pivot index i
Traverse from right to left and find the first index i such that:
nums[i] < nums[i + 1]

Find the successor index j
From the end of the array, find the first index j such that:
nums[j] > nums[i]

Swap nums[i] and nums[j]
This places the next greater element at position i.

Reverse the subarray from index i + 1 to the end
This makes the suffix the smallest possible (i.e., next in lexicographical order).
*/