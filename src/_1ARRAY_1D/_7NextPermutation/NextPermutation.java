/*
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
package _1ARRAY_1D._7NextPermutation;

import java.util.Scanner;

public class NextPermutation
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Ask the user for input size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Accept array input from the user
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.print("Original array: ");
        printArray(nums);

        // Call method to compute next permutation
        nextPermutation(nums);

        System.out.print("Next permutation: ");
        printArray(nums);
    }

    // Method to compute the next lexicographical permutation
    public static void nextPermutation(int[] arr)
    {
        int n = arr.length;

        // Step 1: Find the first decreasing element from the end  -->last second
        int i = n - 2;

        while (i >= 0 && arr[i] >= arr[i + 1])
        {
            i--;
        }

        // Step 2: If we found such an element, find the next bigger number from the right
        if (i >= 0)
        {
            int j = n - 1;

            while (arr[j] <= arr[i])
            {
                j--;
            }

            // Step 3: Swap the two numbers
            swap(arr, i, j);
        }

        // Step 4: Reverse the numbers after index i to get the next permutation
        reverse(arr, i + 1, n - 1);
    }

    // Helper method to swap two elements in the array
    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a subarray in place
    private static void reverse(int[] nums, int start, int end)
    {
        while (start < end)
        {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Method to print array elements without converting to string
    public static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
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