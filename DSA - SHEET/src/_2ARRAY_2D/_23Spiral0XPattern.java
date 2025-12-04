package _2ARRAY_2D;

import java.io.*;

class Spiral0XPattern
{

    // Method to fill the m x n matrix in spiral form with alternating 'X' and '0'
    static void fill0X(int m, int n)
    {
        // Starting row index
        int k = 0;

        // Starting column index
        int l = 0;

        // Save original dimensions for printing later
        int rows = m, cols = n;

        // 2D array to store the result
        char[][] a = new char[m][n];

        // Initialize character to 'X' - will alternate between 'X' and '0'
        char x = 'X';

        // Loop until starting indices cross ending indices
        while (k < m && l < n)
        {

            // Fill the top row from left to right
            for (int i = l; i < n; i++)
            {
                a[k][i] = x;
            }
            k++; // Move down to the next row

            // Fill the rightmost column from top to bottom
            for (int i = k; i < m; i++)
            {
                a[i][n - 1] = x;
            }
            n--; // Move left to the next column

            // Fill the bottom row from right to left, if not already traversed
            if (k < m)
            {
                for (int i = n - 1; i >= l; i--)
                {
                    a[m - 1][i] = x;
                }
                m--; // Move up to the next row
            }

            // Fill the leftmost column from bottom to top, if not already traversed
            if (l < n)
            {
                for (int i = m - 1; i >= k; i--)
                {
                    a[i][l] = x;
                }
                l++; // Move right to the next column
            }

            // Alternate character for next rectangle layer
            x = (x == '0') ? 'X' : '0';

        } // end while

        // Print the filled matrix
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    } // end fill0X

    // Main method to test the fill0X function
    public static void main(String[] args)
    {
        System.out.println("Output for m = 5, n = 6:");
        fill0X(5, 6);

        System.out.println("\nOutput for m = 4, n = 4:");
        fill0X(4, 4);

        System.out.println("\nOutput for m = 3, n = 4:");
        fill0X(3, 4);
    }

} // end class
