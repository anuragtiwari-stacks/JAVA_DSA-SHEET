package _15BitManipulation;

// Leetcode: 1680
public class _6ConcatenationBinaryUsingLeadingZeros
{
    public static int concatenatedBinary(int n)
    {
        long result = 0;
        int MOD = 1000000007;

        for (int i = 1; i <= n; i++)
        {
            int digits = 32 - Integer.numberOfLeadingZeros(i);

            result = ((result << digits) + i) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args)
    {
        int n = 3;

        int ans = concatenatedBinary(n);

        System.out.println("Concatenated Binary Result = " + ans);
    }
}