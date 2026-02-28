package _01ARRAY_1D._14MinOperation_Palindrome;

public class MinInsertionsPalindrome
{
    public static int minInsertions(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;
        int insertions = 0;

        while (start < end)
        {
            if (arr[start] == arr[end])
            {
                start++;
                end--;
            }
            else if (arr[start] < arr[end])
            {
                start++;
                insertions++;
            }
            else
            {
                end--;
                insertions++;
            }
        }

        return insertions;
    }

    public static void main(String[] args)
    {
        int[] arr1 = { 1, 2, 3, 1 };
        int[] arr2 = { 1, 2, 3, 4, 1 };

        System.out.println("Min insertions (arr1): " + minInsertions(arr1));
        System.out.println("Min insertions (arr2): " + minInsertions(arr2));
    }
}

/*
Initial state:
start = 0, end = 3, insertions = 0

Step 1:
arr[start] = 1, arr[end] = 1 → equal ✅
Move both: start = 1, end = 2

Step 2:
arr[start] = 2, arr[end] = 3 → not equal ❌
2 < 3, so insert 2 near the right
insertions = 1
Move start = 2

Now: start = 2, end = 2 → stop
✅ Result: Min insertions = 1

Final array would look like: 1 2 3 2 1
*/