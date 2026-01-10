package _13DP;

// LeetCode 1458 — Max Dot Product of Two Subsequences
public class _1MaxDotProductOfTwoSubsequences
{
    public static int maxDotProduct(int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        // Initialize DP with MIN_VALUE
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        // Fill DP bottom-up
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                int product = nums1[i - 1] * nums2[j - 1];

                // Start new subsequence by default
                int takeBoth = product;

                // Extend previous subsequence
                if (dp[i - 1][j - 1] != Integer.MIN_VALUE)
                {
                    takeBoth = product + dp[i - 1][j - 1];
                }

                int skip1 = dp[i - 1][j]; // skip nums1 element
                int skip2 = dp[i][j - 1]; // skip nums2 element

                dp[i][j] = Math.max(takeBoth, Math.max(product, Math.max(skip1, skip2)));
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args)
    {
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};

        System.out.println(maxDotProduct(nums1, nums2)); // Expected: 18
    }
}


/*
==============================
         DRY RUN
==============================

INPUT:
nums1 = [2, 1, -2, 5]
nums2 = [3, 0, -6]

DP SIZE: (4+1) x (3+1) = 5x4

Initial DP Table (all MIN_VALUE = -∞):

       j→   0     1     2     3
i↓
0          -∞    -∞    -∞    -∞
1 (2)      -∞    -∞    -∞    -∞
2 (1)      -∞    -∞    -∞    -∞
3(-2)      -∞    -∞    -∞    -∞
4 (5)      -∞    -∞    -∞    -∞

--------------------------------
Step by Step Filling:
--------------------------------

i=1, j=1 → nums1[0]=2, nums2[0]=3
product = 2*3 = 6
dp[0][0] = -∞ so takeBoth = product = 6
skip1 = -∞, skip2 = -∞
dp[1][1] = 6

i=1, j=2 → nums1[0]=2, nums2[1]=0
product = 2*0 = 0
takeBoth = 0
skip2 = dp[1][1] = 6
skip1 = dp[0][2] = -∞
dp[1][2] = max(0,6) = 6

i=1, j=3 → nums1[0]=2, nums2[2]=-6
product = -12
takeBoth = -12
skip2 = dp[1][2] = 6
dp[1][3] = 6

Row-1: [ -∞ , 6 , 6 , 6 ]

--------------------------------

i=2, j=1 → nums1[1]=1, nums2[0]=3
product = 3
takeBoth = 3
skip1 = dp[1][1] = 6
dp[2][1] = 6

i=2, j=2 → product = 1*0 = 0
takeBoth = 0
skip1 = dp[1][2]=6
skip2 = dp[2][1]=6
dp[2][2] = 6

i=2, j=3 → product = 1*(-6)= -6
takeBoth = -6
skip2=dp[2][2]=6
dp[2][3] = 6

Row-2: [ -∞ , 6 , 6 , 6 ]

--------------------------------

i=3, j=1 → nums1[2]=-2, nums2[0]=3
product=-6
takeBoth=-6
skip1=dp[2][1]=6
dp[3][1]=6

i=3, j=2 → product=-2*0=0
takeBoth=0
skip1=dp[2][2]=6
skip2=dp[3][1]=6
dp[3][2]=6

i=3, j=3 → product=-2*(-6)=12
dp[2][2]=6 so extend: takeBoth = 12 + 6 = 18
skip1=dp[2][3]=6
skip2=dp[3][2]=6
dp[3][3] = 18

Row-3: [ -∞ , 6 , 6 , 18 ]

--------------------------------

i=4, j=1 → nums1[3]=5, nums2[0]=3
product = 15
takeBoth = 15
skip1=dp[3][1]=6
dp[4][1]=15

i=4, j=2 → product=5*0=0
takeBoth=0
skip1=dp[3][2]=6
skip2=dp[4][1]=15
dp[4][2]=15

i=4, j=3 → product=5*(-6)=-30
dp[3][2]=6, so extend: takeBoth = -30 + 6 = -24
skip1=dp[3][3]=18
skip2=dp[4][2]=15
dp[4][3] = 18

--------------------------------
FINAL DP TABLE:
--------------------------------

       j→     0     1     2     3
i↓
0            -∞    -∞    -∞    -∞
1 (2)        -∞     6     6     6
2 (1)        -∞     6     6     6
3(-2)        -∞     6     6    18
4 (5)        -∞    15    15    18

--------------------------------
FINAL ANSWER = dp[4][3] = 18
--------------------------------
*/
