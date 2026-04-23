package _01ARRAY_1D;

public class _26PairSumSortedRotated
{
    public static boolean pairSum(int[] arr, int target)
    {
        int n = arr.length;

        // Step 1: Find pivot
        int pivot = -1;

        for (int i = 0; i < n - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                pivot = i;
                break;
            }
        }

        // Step 2: left = smallest, right = largest
        int left = (pivot + 1) % n;
        int right = (pivot == -1) ? n - 1 : pivot;

        // Step 3: Two pointer (circular)
        while (left != right)
        {
            int sum = arr[left] + arr[right];

            if (sum == target)
            {
                return true;
            }
            else if (sum < target)
            {
                left = (left + 1) % n;
            }
            else
            {
                right = (right - 1 + n) % n;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        // Example 1
        int[] arr1 = {11, 15, 6, 8, 9, 10};
        int target1 = 16;

        System.out.println("Example 1 Result: " + pairSum(arr1, target1));
        // Expected: true (6 + 10)

        // Example 2
        int[] arr2 = {4, 5, 6, 7, 8, 1, 2};
        int target2 = 20;

        System.out.println("Example 2 Result: " + pairSum(arr2, target2));
        // Expected: false
    }
}