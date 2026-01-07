/*
Find minimum number of merge operations to make an array palindrome
*/
package _1ARRAY_1D._14MinOperation_Palindrome;

public class MinMergePalindrome
{
    public static int minMergeOperations(int[] arr)
    {
        int i = 0;
        int j = arr.length - 1;
        int count = 0;

        while (i < j)
        {
            if (arr[i] == arr[j])
            {
                i++;
                j--;
            }
            else if (arr[i] < arr[j])
            {
                arr[i] = arr[i] + arr[i+1];
                i++;
                j--;
                count++;
            }
            else if (arr[i] > arr[j])
            {
                arr[j] = arr[j] + arr[j-1];
                j--;
                i++;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 4, 5, 9, 1};
        System.out.println("Minimum merge operations: " + minMergeOperations(arr));

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i] +" ");
        }
    }
}

