package _2ARRAY_2D;

/*
QUESTION (LeetCode 1411 - Number of Ways to Paint N × 3 Grid):

You are given an integer n.
You have an n x 3 grid which you have to paint.

Rules:
1. You can use only 3 colors: 1, 2, 3
2. No two adjacent cells in the same row can have the same color
3. No two cells in the same column (vertical) can have the same color

Return the number of ways to paint the grid.
Answer can be very large, return it modulo (10^9 + 7).
*/

public class _28PaintGrid3
{
    public static void main(String[] args)
    {
        int n = 2;

        int ans = numOfWays(n);

        System.out.println(ans);
    }

    static int numOfWays(int n)
    {
        long mod = 1000000007;

        /*
        same  → ABA pattern (1st and 3rd same)
        diff  → ABC pattern (all 3 different)
        */

        long same = 6;
        long diff = 6;

        for (int row = 2; row <= n; row++)
        {
            long newSame = (same * 3 + diff * 2) % mod;
            long newDiff = (same * 2 + diff * 2) % mod;

            same = newSame;
            diff = newDiff;
        }

        return (int)((same + diff) % mod);
    }
}

/*
==================== BEGINNER FRIENDLY DRY RUN ====================

COLORS USED:
1, 2, 3

-------------------- ROW 1 --------------------

All possible valid colorings of ONE ROW (3 columns):

SAME (ABA pattern) → 6 ways
1 2 1
1 3 1
2 1 2
2 3 2
3 1 3
3 2 3

diff = 6

DIFF (ABC pattern) → 6 ways
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

same = 6

So after row 1:
same = 6
diff = 6

-------------------- ROW 2 --------------------

We build row 2 based on row 1 patterns.

FORMULAS:
newSame = same * 3 + diff * 2
newDiff = same * 2 + diff * 2

WHY?

1) From SAME (ABA):
- Can form 3 SAME patterns
- Can form 2 DIFF patterns

2) From DIFF (ABC):
- Can form 2 SAME patterns
- Can form 2 DIFF patterns

-------------------- CALCULATION --------------------

same = 6
diff = 6

newSame = 6 * 3 + 6 * 2
        = 18 + 12
        = 30

newDiff = 6 * 2 + 6 * 2
        = 12 + 12
        = 24

-------------------- FINAL --------------------

Total ways for n = 2:

same + diff
= 30 + 24
= 54

OUTPUT:
54

-------------------- KEY POINTS --------------------
- Har row me sirf 2 patterns hote hain (ABA, ABC)
- same = ABA count
- diff = ABC count
- Har next row ke liye fixed transition hota hai
- Space O(1), Time O(n)

===================================================
*/
