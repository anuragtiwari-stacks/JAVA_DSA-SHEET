package _01ARRAY_1D;

import java.util.Scanner;

public class _26PairSumSortedRotated
{
    public static boolean pairSum(int[] arr, int target)
    {
        int n = arr.length;

        // Step 1: Find pivot (rotation point)
        // Pivot is the index where arr[i] > arr[i+1]
        int pivot = -1;

        for (int i = 0; i < n - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                pivot = i;
                break;
            }
        }

        // Step 2: Set left and right pointers
        // left will point to the smallest element
        int left = (pivot + 1) % n;

        // right will point to the largest element
        int right;

        // If pivot == -1, array is not rotated at all
        if (pivot == -1)
        {
            right = n - 1;
        }
        else
        {
            right = pivot;
        }

        // Step 3: Apply two pointer technique in circular manner
        while (left != right)
        {
            int sum = arr[left] + arr[right];

            // If pair sum is equal to target, return true
            if (sum == target)
            {
                return true;
            }
            // If sum is smaller, move left forward
            else if (sum < target)
            {
                left = (left + 1) % n;
            }
            // If sum is greater, move right backward
            else
            {
                right = (right - 1 + n) % n;
            }
        }

        // If no such pair is found
        return false;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = pairSum(arr, target);

        if (result)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}
