package _02ARRAY_2D;

public class _24MaxArea_Rectangle
{
    // Brute force method to find max area in a histogram
    public static int maxHistogram(int[] heights)
    {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++)
        {
            int height = heights[i];

            // Expand left
            int left = i;
            while (left >= 0 && heights[left] >= height)
            {
                left--;
            }

            // Expand right
            int right = i;
            while (right < n && heights[right] >= height)
            {
                right++;
            }

            int width = right - left - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // Main function to find max rectangle area in 2D binary matrix
    public static int maxArea(int[][] matrix)
    {
        if (matrix.length == 0)
        {
            return 0;
        }

        int[] curRow = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            // Update histogram row
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 1)
                {
                    curRow[j] = curRow[j] + 1;
                }
                else
                {
                    curRow[j] = 0;
                }
            }

            // Calculate max histogram area for this row
            maxArea = Math.max(maxArea, maxHistogram(curRow));
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {0, 1, 1, 0},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0}
                };

        System.out.println("Maximum rectangle area of 1s: " + maxArea(mat));
    }
}

/*
🧮 Dry Run – Row by Row
▶️ Row 0 → curRow = [0, 1, 1, 0]
Call: maxHistogram([0, 1, 1, 0])
Area at index 0: 0 × 1 = 0
Area at index 1: 1 × 2 = 2
Area at index 2: 1 × 2 = 2
Area at index 3: 0 × 1 = 0
Max area this row = 2
🟩 maxArea = 2

▶️ Row 1 → curRow = [1, 2, 2, 1]
Call: maxHistogram([1, 2, 2, 1])
Area at index 0: 1 × 4 = 4
Area at index 1: 2 × 1 = 2
Area at index 2: 2 × 1 = 2
Area at index 3: 1 × 4 = 4
Max area this row = 4
🟩 maxArea = max(2, 4) = 4

▶️ Row 2 → curRow = [2, 3, 3, 2]
Call: maxHistogram([2, 3, 3, 2])
Area at index 0: 2 × 4 = 8 ✅
Area at index 1: 3 × 1 = 3
Area at index 2: 3 × 1 = 3
Area at index 3: 2 × 4 = 8 ✅
Max area this row = 8
🟩 maxArea = max(4, 8) = 8

▶️ Row 3 → curRow = [3, 4, 0, 0]
Call: maxHistogram([3, 4, 0, 0])
Area at index 0: 3 × 1 = 3
Area at index 1: 4 × 1 = 4
Area at index 2: 0 × 1 = 0
Area at index 3: 0 × 1 = 0
Max area this row = 4
🟩 maxArea = max(8, 4) = 8 (unchanged)
*/