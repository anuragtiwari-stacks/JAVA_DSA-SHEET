package _3STRING;

public class _23PalindromicSubsequences
{
    public static int countPalindromicSubsequences(String str)
    {
        int n = str.length();

        Integer[][] dp = new Integer[n][n];

        return helper(str, 0, n - 1, dp);
    }

    private static int helper(String str, int i, int j, Integer[][] dp)
    {
        if (i > j)
        {
            return 0;
        }

        if (i == j)
        {
            return 1;
        }

        if (dp[i][j] != null)
        {
            return dp[i][j];
        }

        if (str.charAt(i) == str.charAt(j))
        {
            dp[i][j] = 1 + helper(str, i + 1, j, dp)
                    + helper(str, i, j - 1, dp);
        }
        else
        {
            dp[i][j] = helper(str, i + 1, j, dp)
                    + helper(str, i, j - 1, dp)
                    - helper(str, i + 1, j - 1, dp);
        }

        return dp[i][j];
    }

    public static void main(String[] args)
    {
        String str = "abca";

        System.out.println("Total Palindromic Subsequences: " + countPalindromicSubsequences(str));
    }
}
