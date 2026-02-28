package _02ARRAY_2D;

import java.util.HashMap;

public class _22CommonElement
{
    public static int findCommon(int[][] mat)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        int rows = mat.length;

        // Count occurrences of every element
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < mat[r].length; c++)
            {
                int value = mat[r][c];

                // Count only first time in each row to avoid duplicates
                if (r == 0 || !map.containsKey(value) || map.get(value) == r)
                {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                }
            }
        }

        // Check which element appears in all rows
        for (int key : map.keySet())
        {
            if (map.get(key) == rows)
            {
                return key;
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
            System.out.println("Common element is: " + common);
        else
            System.out.println("No common element found.");
    }
}
