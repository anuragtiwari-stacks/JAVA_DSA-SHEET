package _2ARRAY_2D;

public class _16ScoreAfterFlippingMatrix
{
    public int matrixScore(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        // Step 1: Make sure all rows start with 1
        for (int i = 0; i < rows; i++)
        {
            if (grid[i][0] == 0)
            {
                // Flip the entire row manually
                for (int j = 0; j < cols; j++)
                {
                    if (grid[i][j] == 0)
                    {
                        grid[i][j] = 1;
                    }
                    else
                    {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        // Step 2: For each column from 1 to end, maximize number of 1s
        for (int j = 1; j < cols; j++)
        {
            int ones = 0;

            for (int i = 0; i < rows; i++)
            {
                if (grid[i][j] == 1)
                {
                    ones++;
                }
            }

            int zeros = rows - ones;

            // If more 0s than 1s, flip column
            if (zeros > ones)
            {
                for (int i = 0; i < rows; i++)
                {
                    if (grid[i][j] == 0)
                    {
                        grid[i][j] = 1;
                    }
                    else
                    {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        // Step 3: Calculate the final score
        int score = 0;

        for (int i = 0; i < rows; i++)
        {
            int rowValue = 0;

            for (int j = 0; j < cols; j++)
            {
                rowValue = rowValue * 2 + grid[i][j]; // Binary to decimal conversion
            }

            score = score + rowValue;
        }

        return score;
    }

    public static void main(String[] args)
    {
        _16ScoreAfterFlippingMatrix obj = new _16ScoreAfterFlippingMatrix();

        int[][] grid = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };

        int result = obj.matrixScore(grid);
        System.out.println("Final Score: " + result);  // Output should be 39
    }
}


/*
^it is ia bitwise xor operator

If grid[i][j] == 0, it becomes 1
If grid[i][j] == 1, it becomes 0
*/