package _05StackQueue;

public class _11CelebrityProblem_BruteForce
{
    /*
    LOGIC (Brute Force):
    -------------------
    Celebrity ke rules:
    1. Celebrity kisi ko nahi jaanta.
    2. Sab log celebrity ko jaante hain.

    Brute Force Steps:
    ------------------
    1. Har person i ko possible celebrity maan lo.
    2. Check karo:
       - i kisi aur ko jaanta ho → invalid
       - koi aur i ko na jaanta ho → invalid
    3. Jo person dono conditions satisfy kare → celebrity
    4. Agar koi bhi satisfy na kare → -1
    */

    public static int findCelebrity(int[][] mat)
    {
        int n = mat.length;

        for (int i = 0; i < n; i++)
        {
            boolean isCelebrity = true;

            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    continue;
                }

                if (mat[i][j] == 1 || mat[j][i] == 0)
                {
                    isCelebrity = false;
                    break;
                }
            }

            if (isCelebrity)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {0, 1, 0},
                        {0, 0, 0},
                        {0, 1, 0}
                };

        System.out.println(findCelebrity(mat));
    }
}

/*
DRY RUN:
--------

Matrix:
0 1 0
0 0 0
0 1 0

Person 0:
- mat[0][1] = 1 → knows someone ❌
Not celebrity

Person 1:
- mat[1][0] = 0 → does not know 0 ✔
- mat[1][2] = 0 → does not know 2 ✔
- mat[0][1] = 1 → 0 knows 1 ✔
- mat[2][1] = 1 → 2 knows 1 ✔
Celebrity found → index 1

FINAL ANSWER:
-------------
1
*/
