package _05StackQueue;

import java.util.Stack;

public class _11CelebrityProblem_Optimized
{
    public static int findCelebrity(int[][] M)
    {
        int n = M.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++)
        {
            st.push(i);
        }

        while (st.size() > 1)
        {
            int first = st.pop();
            int second = st.pop();

            if (M[first][second] == 1 && M[second][first] == 0)
            {
                st.push(second);
            }
            else if (M[first][second] == 0 && M[second][first] == 1)
            {
                st.push(first);
            }
        }

        if (st.isEmpty())
        {
            return -1;
        }

        int candidate = st.pop();

        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++)
        {
            row = row + M[candidate][i];
            col = col + M[i][candidate];
        }

        if (row == 0 && col == n - 1)
        {
            return candidate;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[][] M =
                {
                        {0, 1, 0},
                        {0, 0, 0},
                        {0, 1, 0}
                };

        System.out.println(findCelebrity(M));
    }
}

/*
DRY RUN:
--------

Matrix:
0 1 0
0 0 0
0 1 0

Initial Stack:
[0, 1, 2]

--------------------------------
Pop:
first = 2
second = 1

M[first][second] = M[2][1] = 1
M[second][first] = M[1][2] = 0

Condition matched:
M[first][second] == 1 && M[second][first] == 0

Action:
push(second)

Stack:
[0, 1]

--------------------------------
Pop:
first = 1
second = 0

M[first][second] = M[1][0] = 0
M[second][first] = M[0][1] = 1

Condition matched:
M[first][second] == 0 && M[second][first] == 1

Action:
push(first)

Stack:
[1]

--------------------------------
Candidate:
candidate = 1

--------------------------------
Verification:

Row sum:
M[1][0] + M[1][1] + M[1][2]
= 0 + 0 + 0
= 0

Column sum:
M[0][1] + M[1][1] + M[2][1]
= 1 + 0 + 1
= 2

Check:
row == 0
col == n - 1

--------------------------------
FINAL ANSWER:
Celebrity index = 1
*/
