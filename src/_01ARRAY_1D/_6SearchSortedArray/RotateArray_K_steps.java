package _01ARRAY_1D._6SearchSortedArray;

import java.util.Scanner;

public class RotateArray_K_steps
{
    // Function to reverse part of array
    public static void reverse(int[] arr, int start, int end)
    {
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Function to rotate array by k steps
    public static void rotate(int[] nums, int k)
    {
        int n = nums.length;
        k = k % n; // Handle k > n

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse remaining elements
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input elements
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        // Input rotation steps
        System.out.print("Enter number of steps to rotate: ");
        int k = sc.nextInt();

        // Rotate array
        rotate(nums, k);

        // Output result
        System.out.println("Array after rotation:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(nums[i] + " ");
        }
    }
}
