package _2ARRAY_2D;

import java.util.Scanner;

public class _25MissingRepeat
{
    public static int[] findMissingAndRepeatedValues(int[][] grid)
    {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                freq[grid[i][j]]++;
            }
        }

        int repeat = 0;
        int missing = 0;

        for (int i = 1; i <= size; i++)
        {
            if (freq[i] == 2)
            {
                repeat = i;
            }
            else if (freq[i] == 0)
            {
                missing = i;
            }
        }

        return new int[] { repeat, missing };
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = findMissingAndRepeatedValues(grid);

        System.out.println("Repeated Value: " + result[0]);
        System.out.println("Missing Value: " + result[1]);
    }
}
