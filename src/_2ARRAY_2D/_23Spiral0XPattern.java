package _2ARRAY_2D;

public class _23Spiral0XPattern
{
    public static void fill0X(int rows, int cols)
    {
        char[][] matrix = new char[rows][cols];

        int minr = 0;
        int maxr = rows - 1;
        int minc = 0;
        int maxc = cols - 1;

        char ch = 'X';  // starting character

        while (minr <= maxr && minc <= maxc)
        {
            // → Fill top row
            for (int c = minc; c <= maxc; c++)
            {
                matrix[minr][c] = ch;
            }
            minr++;

            // ↓ Fill right column
            for (int r = minr; r <= maxr; r++)
            {
                matrix[r][maxc] = ch;
            }
            maxc--;

            // ← Fill bottom row
            if (minr <= maxr)
            {
                for (int c = maxc; c >= minc; c--)
                {
                    matrix[maxr][c] = ch;
                }
                maxr--;
            }

            // ↑ Fill left column
            if (minc <= maxc)
            {
                for (int r = maxr; r >= minr; r--)
                {
                    matrix[r][minc] = ch;
                }
                minc++;
            }

            // Alternate character
            ch = (ch == 'X') ? '0' : 'X';
        }

        // Print matrix
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Output for 5 x 6:");
        fill0X(5, 6);

        System.out.println("\nOutput for 4 x 4:");
        fill0X(4, 4);

        System.out.println("\nOutput for 3 x 4:");
        fill0X(3, 4);
    }
}
