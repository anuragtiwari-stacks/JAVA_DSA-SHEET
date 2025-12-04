package _2ARRAY_2D;

public class _15SpiralMatrixTraversal
{
    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15,16}
        };

        System.out.println("Spiral traversal of the matrix:");

        int minr = 0;
        int maxr = matrix.length - 1;
        int minc = 0;
        int maxc = matrix[0].length - 1;

        while (minr <= maxr && minc <= maxc)
        {
            // Traverse top row (→)
            for (int i = minc; i <= maxc; i++)
            {
                System.out.print(matrix[minr][i] + " ");
            }
            minr++; // shrink top boundary

            // Traverse right column (↓)
            for (int i = minr; i <= maxr; i++)
            {
                System.out.print(matrix[i][maxc] + " ");
            }
            maxc--; // shrink right boundary

            // Traverse bottom row (←)
            if (minr <= maxr)
            {
                for (int i = maxc; i >= minc; i--)
                {
                    System.out.print(matrix[maxr][i] + " ");
                }
                maxr--; // shrink bottom boundary
            }

            // Traverse left column (↑)
            if (minc <= maxc)
            {
                for (int i = maxr; i >= minr; i--)
                {
                    System.out.print(matrix[i][minc] + " ");
                }
                minc++; // shrink left boundary
            }
        }
    }
}
