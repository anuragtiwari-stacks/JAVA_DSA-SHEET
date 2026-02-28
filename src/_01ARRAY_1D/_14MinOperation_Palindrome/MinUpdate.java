package _01ARRAY_1D._14MinOperation_Palindrome;

public class MinUpdate
{
    static int MakingPalindrome(int[] arr)
    {
        int n = arr.length;  // Get length inside method
        int count = 0;         // Count of merge operations
        int i = 0, j = n - 1;

        while (i < j)
        {
            if (arr[i] == arr[j])
            {
                i++;
                j--;
            }
            else if (arr[i] > arr[j])
            {
                arr[i] = arr[j];
                i++;
                j--;
                count++;
            }
            else if (arr[i] < arr[j])
            {
                arr[i] = arr[i] + arr[i+1];
                i++;
                j--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 4, 5, 9, 1};

        System.out.print("Initial Array: ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] +" ");
        }

        int update = MakingPalindrome(arr);

        System.out.println();

        System.out.println("Total updates: "+update);

        System.out.print("Updated Array: ");
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] +" ");
        }
    }
}
