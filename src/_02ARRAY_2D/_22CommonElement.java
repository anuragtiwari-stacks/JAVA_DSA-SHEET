package _02ARRAY_2D;

import java.util.*;

public class _22CommonElement {

    public static int findCommon(int[][] mat) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int rows = mat.length;

        for (int r = 0; r < rows; r++)
        {
            HashSet<Integer> set = new HashSet<>();

            for (int c = 0; c < mat[r].length; c++)
            {
                set.add(mat[r][c]);
            }

            // count manually
            for (int val : set)
            {
                if (map.containsKey(val))
                {
                    map.put(val, map.get(val) + 1);
                }
                else
                {
                    map.put(val, 1);
                }
            }
        }

        // check common element
        for (int key : map.keySet())
        {
            if (map.get(key) == rows)
            {
                return key;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3, 4, 5},
                {2, 4, 5, 8, 10},
                {3, 5, 7, 9, 11},
                {1, 3, 5, 7, 9}
        };

        int result = findCommon(mat);

        if (result != -1)
            System.out.println("Common element: " + result);
        else
            System.out.println("No common element found");
    }
}