/*
 * LeetCode 712. Minimum ASCII Delete Sum for Two Strings
 */

package _13DP;

public class _2MinimumASCIIDeleteSum
{
    public static int minimumDeleteSum(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Fill DP (ASCII-weighted LCS)
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = s1.charAt(i - 1) + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int LCS = dp[n][m];

        // sum of s1
        int sum1 = 0;
        for(char c : s1.toCharArray())
        {
            sum1 += c;
        }

        // sum of s2
        int sum2 = 0;
        for(char c : s2.toCharArray())
        {
            sum2 += c;
        }

        int deleteFromS1 = sum1 - LCS;
        int deleteFromS2 = sum2 - LCS;

        return deleteFromS1 + deleteFromS2;
    }

    public static void main(String[] args)
    {
        String s1 = "delete";
        String s2 = "leet";

        int result = minimumDeleteSum(s1, s2);
        System.out.println("Minimum Delete Sum = " + result);
    }
}

/*
----------------------------------------------------
                 DRY RUN (FINAL DP TABLE)
----------------------------------------------------
s1 = "delete"
s2 = "leet"

ASCII values:
d = 100, e = 101, l = 108, t = 116

dp[i][j] = max ASCII sum of LCS of s1[0..i-1] & s2[0..j-1]

        0    l     e     e    t
      -------------------------
0 |    0     0     0     0     0
d |    0     0     0     0     0
e |    0     0   101   101   101
l |    0   108   108   108   108
e |    0   108   209   209   209
t |    0   108   209   209   325
e |    0   108   209   310   325

Final dp[n][m] = dp[6][4] = 325  ← (ASCII-weighted LCS = "let")

Sum of s1 ASCII = 627
Sum of s2 ASCII = 426

deleteFromS1 = 627 - 325 = 302
deleteFromS2 = 426 - 325 = 101

Minimum Delete Sum = 302 + 101 = 403
----------------------------------------------------
*/
