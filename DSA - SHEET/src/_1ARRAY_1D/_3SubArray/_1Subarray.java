package _1ARRAY_1D._3SubArray;

public class _1Subarray
{
    public void printAllSubarrays(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                System.out.print("[");
                for (int k = i; k <= j; k++)
                {
                    System.out.print(arr[k]);
                    if (k < j)
                    {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args)
    {
        _1Subarray sol = new _1Subarray();

        int[] nums = {1, 2, 3};
        System.out.println("All subarrays:");
        sol.printAllSubarrays(nums);
    }
}
