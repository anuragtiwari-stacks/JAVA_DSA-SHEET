package _15BitManipulation;

// Leetcode: 1680
public class _6ConcatenationBinaryUsingPowerOF2
{
    public static int concatenatedBinary(int n)
    {
        long result = 0;
        int MOD = 1000000007;
        int digits = 0;

        for (int i = 1; i <= n; i++)
        {
            // Check if i is power of 2 b/c -> 2,4,8,16,32,64,128 me hi digit count increase hota h
            if ((i & (i - 1)) == 0)
            {
                digits++;
            }

            result = ((result << digits) + i) % MOD;
        }

        return (int) result;   // Method return type int hai
    }

    public static void main(String[] args)
    {
        int n = 3;

        int ans = concatenatedBinary(n);

        System.out.println("Concatenated Binary Result = " + ans);
    }
}