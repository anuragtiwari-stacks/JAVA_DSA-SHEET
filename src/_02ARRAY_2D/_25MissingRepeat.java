package _02ARRAY_2D;

public class _25MissingRepeat
{
    public static int[] findMissingAndRepeatedValues(int[][] grid)
    {
        int n = grid.length;
        int size = n * n;

        int[] freq = new int[size + 1];

        // Count frequency
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                freq[grid[i][j]]++;
            }
        }

        int repeat = 0;
        int missing = 0;

        // Find repeated and missing
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
        // Example 1
        int[][] grid1 =
                {
                        {1, 3},
                        {2, 2}
                };

        int[] result1 = findMissingAndRepeatedValues(grid1);
        System.out.println("Example 1:");
        System.out.println("Repeated Value: " + result1[0]);
        System.out.println("Missing Value: " + result1[1]);
        // Expected Output:
        // Repeated Value: 2
        // Missing Value: 4


        // Example 2
        int[][] grid2 =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 8}
                };

        int[] result2 = findMissingAndRepeatedValues(grid2);
        System.out.println("\nExample 2:");
        System.out.println("Repeated Value: " + result2[0]);
        System.out.println("Missing Value: " + result2[1]);
        // Expected Output:
        // Repeated Value: 8
        // Missing Value: 9
    }
}