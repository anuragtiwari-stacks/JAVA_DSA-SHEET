/*
Find a common element in all rows of a given row-wise sorted matrix

Input: mat[4][5] = {
                    {1, 2, 3, 4, 5},
                    {2, 4, 5, 8, 10},
                    {3, 5, 7, 9, 11},
                    {1, 3, 5, 7, 9},
                  };
Output: 5
*/
package _2ARRAY_2D;

public class _22CommonElement
{
    // Binary Search helper method
    public static boolean binarySearch(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
            {
                return true;
            }
            else if (arr[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return false;
    }

    public static int findCommon(int[][] mat)
    {
        int m = mat.length;
        int n = mat[0].length;

        for (int col = 0; col < n; col++)
        {
            int element = mat[0][col];
            boolean foundInAll = true;

            for (int row = 1; row < m; row++)
            {
                if (!binarySearch(mat[row], element))
                {
                    foundInAll = false;
                    break;
                }
            }
            if (foundInAll)
            {
                return element;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        {1, 2, 3, 4, 5},
                        {2, 4, 5, 8, 10},
                        {3, 5, 7, 9, 11},
                        {1, 3, 5, 7, 9}
                };

        int common = findCommon(mat);

        if (common != -1)
        {
            System.out.println("Common element is: " + common);
        }
        else
        {
            System.out.println("No common element found.");
        }
    }
}
