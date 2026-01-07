package _1ARRAY_1D;

public class _24MissingDuplicate
{
    static int[] findTwoElement(int[] arr)
    {
        int n = arr.length;

        // Expected sum of numbers from 1 to n
        // S1 = 1 + 2 + 3 + ... + n
        long S1 = (long)n * (n + 1) / 2;

        // Expected sum of squares of numbers from 1 to n
        // S2 = 1^2 + 2^2 + 3^2 + ... + n^2
        long S2 = (long)n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        // Calculate actual sum and actual square sum from the array
        for (int x : arr)
        {
            actualSum += x;
            actualSquareSum += (long)x * x;
        }

        // Let:
        // Missing number   = x
        // Duplicate number = y

        // diff = S1 - actualSum = x - y
        long diff = S1 - actualSum;

        // diffSquare = S2 - actualSquareSum = x^2 - y^2
        long diffSquare = S2 - actualSquareSum;

        // x^2 - y^2 = (x - y)(x + y)
        // So:
        // diffSquare = diff * (x + y)
        // (x + y) = diffSquare / diff
        long sum = diffSquare / diff;

        // Now we have:
        // x - y = diff
        // x + y = sum
        // Adding both:
        // 2x = diff + sum
        long missing = (diff + sum) / 2;

        // Since x - y = diff
        // y = x - diff
        long duplicate = missing - diff;

        return new int[]{(int)duplicate, (int)missing};
    }

    public static void main(String[] args)
    {
        int[] arr = {1,3,3,4,5};

        int[] ans = findTwoElement(arr);

        System.out.println("Duplicate = " + ans[0]);
        System.out.println("Missing = " + ans[1]);
    }
}
