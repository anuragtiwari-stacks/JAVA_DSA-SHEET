package _2ARRAY_2D;

public class _18SetMatrixZeroes_UsingRowColArrays
{
    public void setZeroes(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Step 1: Create two arrays to mark rows and columns
        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // Step 2: Mark rows and columns that need to be zeroed
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 3: Update the matrix based on row[] and col[]
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (row[i] || col[j])
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        _18SetMatrixZeroes_UsingRowColArrays obj = new _18SetMatrixZeroes_UsingRowColArrays();

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        obj.setZeroes(matrix);

        // Print updated matrix
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
