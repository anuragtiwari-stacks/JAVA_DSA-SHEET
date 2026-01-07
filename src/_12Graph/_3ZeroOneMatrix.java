package _12Graph;

import java.util.LinkedList;
import java.util.Queue;

class _3ZeroOneMatrix
{
    static class Pair
    {
        int row;
        int col;

        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        // Initialize distances
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    dist[i][j] = 0;
                    q.add(new Pair(i, j));
                }
                else
                {
                    dist[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty())
        {
            Pair current = q.remove();
            int row = current.row;
            int col = current.col;

            // Check Top
            if (row > 0 && dist[row - 1][col] == -1)
            {
                dist[row - 1][col] = dist[row][col] + 1;
                q.add(new Pair(row - 1, col));
            }

            // Check Bottom
            if (row + 1 < m && dist[row + 1][col] == -1)
            {
                dist[row + 1][col] = dist[row][col] + 1;
                q.add(new Pair(row + 1, col));
            }

            // Check Left
            if (col > 0 && dist[row][col - 1] == -1)
            {
                dist[row][col - 1] = dist[row][col] + 1;
                q.add(new Pair(row, col - 1));
            }

            // Check Right
            if (col + 1 < n && dist[row][col + 1] == -1)
            {
                dist[row][col + 1] = dist[row][col] + 1;
                q.add(new Pair(row, col + 1));
            }
        }

        return dist;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                };

        int[][] result = updateMatrix(mat);

        for (int i = 0; i < result.length; i++)
        {
            for (int j = 0; j < result[0].length; j++)
            {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*
================================================
STEP-WISE DRY RUN – LEETCODE 542 (01 MATRIX)
================================================

Input Matrix:
0 0 0
0 1 0
1 1 1

Legend:
0 → Source (distance 0)
1 → Need to calculate distance

-----------------------------------------------
Step 1: Initialization
-----------------------------------------------
All 0 cells are added to the queue (multi-source BFS)

Queue (in order of insertion):
(0,0), (0,1), (0,2), (1,0), (1,2)

Distance Matrix (dist):
 0  0  0
 0 -1  0
-1 -1 -1

-----------------------------------------------
Step 2: Start BFS Processing
-----------------------------------------------
-----------------------------------------------
Process 1: (0,0)
-----------------------------------------------
Current cell: (0,0)
dist[0][0] = 0

Top:
row > 0 → false

Bottom:
(1,0) already has dist = 0 → ignore

Left:
col > 0 → false

Right:
(0,1) already has dist = 0 → ignore

Queue remains:
(0,1), (0,2), (1,0), (1,2)

-----------------------------------------------
Process 2: (0,1)
-----------------------------------------------
Current cell: (0,1)
dist[0][1] = 0

Top:
row > 0 → false

Bottom:
(1,1) has dist = -1
→ update dist[1][1] = 1
→ add (1,1) to queue

Left:
(0,0) already visited → ignore

Right:
(0,2) already visited → ignore

Queue now:
(0,2), (1,0), (1,2), (1,1)

-----------------------------------------------
Process 3: (0,2)
-----------------------------------------------
Current cell: (0,2)
dist[0][2] = 0

Top:
row > 0 → false

Bottom:
(1,2) already has dist = 0 → ignore

Left:
(0,1) already visited → ignore

Right:
col + 1 < n → false

Queue:
(1,0), (1,2), (1,1)

-----------------------------------------------
Process 4: (1,0)
-----------------------------------------------
Current cell: (1,0)
dist[1][0] = 0

Top:
(0,0) already visited → ignore

Bottom:
(2,0) has dist = -1
→ update dist[2][0] = 1
→ add (2,0)

Left:
col > 0 → false

Right:
(1,1) already updated → ignore

Queue:
(1,2), (1,1), (2,0)

-----------------------------------------------
Process 5: (1,2)
-----------------------------------------------
Current cell: (1,2)
dist[1][2] = 0

Top:
(0,2) already visited → ignore

Bottom:
(2,2) has dist = -1
→ update dist[2][2] = 1
→ add (2,2)

Left:
(1,1) already visited → ignore

Right:
col + 1 < n → false

Queue:
(1,1), (2,0), (2,2)

-----------------------------------------------
Step 3: Next Level (Distance = 2)
-----------------------------------------------
Process (1,1):
Bottom → (2,1)
→ dist[2][1] = 2
→ add (2,1)

-----------------------------------------------
Final Distance Matrix
-----------------------------------------------
0 0 0
0 1 0
1 2 1

-----------------------------------------------
END
-----------------------------------------------
*/
