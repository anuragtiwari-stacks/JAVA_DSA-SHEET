package _1ARRAY_1D._6SearchSortedArray;
import java.util.Arrays;

public class RotateArray_Pivot
{
    public void rotateAtPivot(int[] arr, int pivot)
    {
        int n = arr.length;

        if (pivot < 0 || pivot >= n)
        {
            System.out.println("Invalid pivot index.");
            return;
        }

        // Step 1: Reverse 0 to pivot-1
        reverse(arr, 0, pivot - 1);

        // Step 2: Reverse pivot to n-1
        reverse(arr, pivot, n - 1);

        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }

    private void reverse(int[] arr, int start, int end)
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

    public static void main(String[] args)
    {
        RotateArray_Pivot rotator = new RotateArray_Pivot();

        int[] arr = {1, 2, 3, 4, 5, 6};
        int pivot = 2;

        System.out.println("Original array: " + Arrays.toString(arr));
        rotator.rotateAtPivot(arr, pivot);
        System.out.println("Rotated array at pivot " + pivot + ": " + Arrays.toString(arr));
    }
}
