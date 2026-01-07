package _2ARRAY_2D;

import java.util.PriorityQueue;

public class _26KthSmallestInMatrix
{
    public static int kthSmallest(int[][] matrix, int k)
    {
        int n = matrix.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                pq.offer(matrix[i][j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < k; i++)
        {
            ans = pq.poll();
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        { 1, 5, 9 },
                        { 10, 11, 13 },
                        { 12, 13, 15 }
                };

        int k = 8;

        int result = kthSmallest(matrix, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}
