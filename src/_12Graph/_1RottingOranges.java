package _12Graph;

import java.util.LinkedList;
import java.util.Queue;

class _1RottingOranges
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

    public static int orangesRotting(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 2)
                {
                    q.add(new Pair(i, j));
                }
                else if (grid[i][j] == 1)
                {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0)
        {
            return 0;
        }

        int minutes = 0;

        while (!q.isEmpty())
        {
            int size = q.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++)
            {
                Pair current = q.remove();
                int row = current.row;
                int col = current.col;

                // Check Top
                if (row > 0)
                {
                    if (grid[row - 1][col] == 1)
                    {
                        grid[row - 1][col] = 2;
                        q.add(new Pair(row - 1, col));
                        freshCount--;
                        rotted = true;
                    }
                }

                // Check Bottom
                if (row + 1 < m)
                {
                    if (grid[row + 1][col] == 1)
                    {
                        grid[row + 1][col] = 2;
                        q.add(new Pair(row + 1, col));
                        freshCount--;
                        rotted = true;
                    }
                }

                // Check Left
                if (col > 0)
                {
                    if (grid[row][col - 1] == 1)
                    {
                        grid[row][col - 1] = 2;
                        q.add(new Pair(row, col - 1));
                        freshCount--;
                        rotted = true;
                    }
                }

                // Check Right
                if (col + 1 < n)
                {
                    if (grid[row][col + 1] == 1)
                    {
                        grid[row][col + 1] = 2;
                        q.add(new Pair(row, col + 1));
                        freshCount--;
                        rotted = true;
                    }
                }
            }

            if (rotted)
            {
                minutes++;
            }
        }

        if (freshCount == 0)
        {
            return minutes;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[][] grid =
                {
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };

        int result = orangesRotting(grid);
        System.out.println("Minimum minutes required: " + result);
    }
}
