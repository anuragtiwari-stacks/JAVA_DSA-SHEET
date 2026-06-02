package _12Graph;

import java.util.LinkedList;
import java.util.Queue;

// 733. Flood Fill
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
            int size = q.size();

            for (int i = 0; i < size; i++)
            {
                Pair current = q.remove();

                int row = current.row;
                int col = current.col;

                if (row > 0 && image[row - 1][col] == originalColor)
                {
                    image[row - 1][col] = newColor;

                    q.add(new Pair(row - 1, col));
                }

                if (row + 1 < m && image[row + 1][col] == originalColor)
                {
                    image[row + 1][col] = newColor;

                    q.add(new Pair(row + 1, col));
                }

                if (col > 0 && image[row][col - 1] == originalColor)
                {
                    image[row][col - 1] = newColor;

                    q.add(new Pair(row, col - 1));
                }

                if (col + 1 < n && image[row][col + 1] == originalColor)
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