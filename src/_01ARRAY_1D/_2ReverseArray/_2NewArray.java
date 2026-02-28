package _01ARRAY_1D._2ReverseArray;

public class _2NewArray
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        int[] reversed = new int[n];

        for (int i = 0; i < n; i++)
        {
            reversed[i] = arr[n - 1 - i];
        }

        for (int i : reversed)
        {
            System.out.print(i + " ");
        }
    }
}

