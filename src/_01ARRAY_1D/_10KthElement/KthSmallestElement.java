package _01ARRAY_1D._10KthElement;

public class KthSmallestElement
{
    public int findKthSmallest(int[] arr, int k)
    {
        int n = arr.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // kth smallest is at index k - 1
        return arr[k - 1];
    }

    public static void main(String[] args)
    {
        KthSmallestElement solver = new KthSmallestElement();

        int[] arr1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("3rd smallest: " + solver.findKthSmallest(arr1, k1));  // Output: 7

        int[] arr2 = {2, 3, 1, 20, 15};
        int k2 = 4;
        System.out.println("4th smallest: " + solver.findKthSmallest(arr2, k2));  // Output: 15
    }
}
