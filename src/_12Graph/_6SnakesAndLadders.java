package _12Graph;

import java.util.*;

// 909. Snakes and Ladders

/*
================================================
LOGIC : SNAKES AND LADDERS (LeetCode 909)
================================================

1. Board cells are numbered from 1 to n*n.
2. From any cell, we can move 1 to 6 steps using a dice.
3. If a cell contains:
   - -1  → normal cell
   - any number → snake or ladder (jump immediately)
4. We need the MINIMUM number of dice moves
   → therefore we use BFS.
5. BFS is done level by level:
   - each BFS level = 1 dice move
6. Use:
   - Queue<Integer> for BFS
   - visited[row][col] to avoid revisiting cells
7. First time we reach cell n*n, return moves.
*/

public class _6SnakesAndLadders
{
    public static int snakesAndLadders(int[][] board)
    {
        int n = board.length;

        // visited array to avoid revisiting board cells
        boolean[][] visited = new boolean[n][n];

        // BFS queue stores cell numbers (1 to n*n)
        Queue<Integer> queue = new LinkedList<>();

        // start from cell 1
        queue.add(1);

        int moves = 0;

        // BFS traversal
        while (!queue.isEmpty())
        {
            int size = queue.size(); // nodes at current BFS level

            // one BFS level = one dice move
            while (size-- > 0)
            {
                int curr = queue.remove();

                // reached destination
                if (curr == n * n)
                {
                    return moves;
                }

                // try dice values from 1 to 6
                for (int dice = 1; dice <= 6; dice++)
                {
                    int next = curr + dice;

                    if (next > n * n)
                    {
                        break;
                    }

                    // convert cell number to (row, col)
                    int[] coord = getCoord(next, n);
                    int row = coord[0];
                    int col = coord[1];

                    if (visited[row][col])
                    {
                        continue;
                    }

                    visited[row][col] = true;

                    // snake or ladder jump
                    if (board[row][col] != -1)
                    {
                        queue.add(board[row][col]);
                    }
                    else
                    {
                        queue.add(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    /*
        Converts a cell number (1 to n*n)
        into board coordinates (row, col)
        considering zig-zag numbering.
    */
    private static int[] getCoord(int num, int n)
    {
        int rowFromTop = (num - 1) / n;
        int row = (n - 1) - rowFromTop;

        int col = (num - 1) % n;

        // reverse direction for alternate rows
        if (rowFromTop % 2 == 1)
        {
            col = (n - 1) - col;
        }

        return new int[]{row, col};
    }

    // Driver code for IDE
    public static void main(String[] args)
    {
        int[][] board =
                {
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}
                };

        System.out.println("Minimum moves = " + snakesAndLadders(board));
    }
}

/*
================================================
COMPLETE DRY RUN (CORRECT ANSWER = 4)
================================================

Board numbering:
36 35 34 33 32 31
25 26 27 28 29 30
24 23 22 21 20 19
13 14 15 16 17 18
12 11 10  9  8  7
 1  2  3  4  5  6

Ladders:
2  -> 15
14 -> 35

Snake:
17 -> 13

-----------------------------------------------
Start:
queue = [1]
moves = 0
-----------------------------------------------

MOVE 1:
From 1 → dice gives 2..7

2  -> ladder -> 15
3  -> 3
4  -> 4
5  -> 5
6  -> 6
7  -> 7

queue = [15, 3, 4, 5, 6, 7]
moves = 1

-----------------------------------------------
MOVE 2:
Process all nodes in queue

From 15:
dice → 16..21
17 -> snake -> 13

queue now contains 13 (among others)
moves = 2

-----------------------------------------------
MOVE 3:
From 13:
dice → 14
14 -> ladder -> 35

queue contains 35
moves = 3

-----------------------------------------------
MOVE 4:
From 35:
dice → 36

Reached destination (36)

-----------------------------------------------
FINAL ANSWER:
Minimum moves = 4
================================================
*/
