package _12Graph;

import java.util.LinkedList;
import java.util.Queue;

class _2FloodFill
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

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];

        if (originalColor == newColor)
        {
            return image;
        }

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr, sc));
        image[sr][sc] = newColor;

        while (!q.isEmpty())
        {
            Pair current = q.remove();
            int row = current.row;
            int col = current.col;

            // Check Top
            if (row > 0)
            {
                if (image[row - 1][col] == originalColor)
                {
                    image[row - 1][col] = newColor;
                    q.add(new Pair(row - 1, col));
                }
            }

            // Check Bottom
            if (row + 1 < m)
            {
                if (image[row + 1][col] == originalColor)
                {
                    image[row + 1][col] = newColor;
                    q.add(new Pair(row + 1, col));
                }
            }

            // Check Left
            if (col > 0)
            {
                if (image[row][col - 1] == originalColor)
                {
                    image[row][col - 1] = newColor;
                    q.add(new Pair(row, col - 1));
                }
            }

            // Check Right
            if (col + 1 < n)
            {
                if (image[row][col + 1] == originalColor)
                {
                    image[row][col + 1] = newColor;
                    q.add(new Pair(row, col + 1));
                }
            }
        }

        return image;
    }

    public static void main(String[] args)
    {
        int[][] image =
                {
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

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
===========================
DRY RUN – FLOOD FILL (BFS)
===========================

Input Image:
1 1 1
1 1 0
1 0 1

Start:
sr = 1, sc = 1
originalColor = 1
newColor = 2

--------------------------------
Step 1: Initialization
--------------------------------
Queue = [(1,1)]
image[1][1] = 2

Image:
1 1 1
1 2 0
1 0 1

--------------------------------
Step 2: Process (1,1)
--------------------------------
Top    → (0,1) = 1 → change to 2, add to queue
Bottom → (2,1) = 0 → ignore
Left   → (1,0) = 1 → change to 2, add to queue
Right  → (1,2) = 0 → ignore

Queue = [(0,1), (1,0)]

Image:
1 2 1
2 2 0
1 0 1

--------------------------------
Step 3: Process (0,1)
--------------------------------
Top    → out of bounds
Bottom → (1,1) = 2 → ignore
Left   → (0,0) = 1 → change to 2, add
Right  → (0,2) = 1 → change to 2, add

Queue = [(1,0), (0,0), (0,2)]

--------------------------------
Step 4: Process (1,0)
--------------------------------
Top    → (0,0) = 2 → ignore
Bottom → (2,0) = 1 → change to 2, add
Left   → out of bounds
Right  → (1,1) = 2 → ignore

Queue = [(0,0), (0,2), (2,0)]

--------------------------------
Remaining cells processed...
No more cells with originalColor = 1

--------------------------------
Final Image:
2 2 2
2 2 0
2 0 1
*/
