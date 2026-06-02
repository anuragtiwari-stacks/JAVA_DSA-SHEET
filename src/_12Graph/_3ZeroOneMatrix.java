package _12Graph;

import java.util.LinkedList;
import java.util.Queue;

// 542. 01 Matrix
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
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty())
        {
            Pair current = q.remove();

            int row = current.row;
            int col = current.col;

            // Top
            if (row > 0 && !vis[row - 1][col])
            {
                dist[row - 1][col] = dist[row][col] + 1;
                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            // Bottom
            if (row + 1 < m && !vis[row + 1][col])
            {
                dist[row + 1][col] = dist[row][col] + 1;
                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
            }

            // Left
            if (col > 0 && !vis[row][col - 1])
            {
                dist[row][col - 1] = dist[row][col] + 1;
                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }

            // Right
            if (col + 1 < n && !vis[row][col + 1])
            {
                dist[row][col + 1] = dist[row][col] + 1;
                vis[row][col + 1] = true;
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