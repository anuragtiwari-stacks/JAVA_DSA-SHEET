package _6BinarySearchTree;

import java.util.Arrays;

public class _11ReplaceWithLeastGreater
{
    public static void replaceWithLeastGreater(int[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
        {
            int minGreater = Integer.MAX_VALUE;
            boolean found = false;

            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] > arr[i] && arr[j] < minGreater)
                {
                    minGreater = arr[j];
                    found = true;
                }
            }

            if (found)
            {
                arr[i] = minGreater;
            }
            else
            {
                arr[i] = -1;
            }
        }

        arr[n - 1] = -1;
    }

    public static void main(String[] args)
    {
        int[] arr =
                {
                        8, 58, 71, 18, 31, 32, 63, 92,
                        43, 3, 91, 93, 25, 80, 28
                };

        replaceWithLeastGreater(arr);

        System.out.println(Arrays.toString(arr));
    }
}

/*
| j  | arr\[j] | arr\[j] > 8? | Is arr\[j] < currentMin? | New minGreater |
| -- | ------- | ------------ | ------------------------ | -------------- |
| 1  | 58      | Yes          | Yes                      | 58             |
| 2  | 71      | Yes          | No                       | 58             |
| 3  | 18      | Yes          | Yes                      | 18             |
| 4  | 31      | Yes          | No                       | 18             |
| 5  | 32      | Yes          | No                       | 18             |
| 6  | 63      | Yes          | No                       | 18             |
| 7  | 92      | Yes          | No                       | 18             |
| 8  | 43      | Yes          | No                       | 18             |
| 9  | 3       | No           | -                        | 18             |
| 10 | 91      | Yes          | No                       | 18             |
| 11 | 93      | Yes          | No                       | 18             |
| 12 | 25      | Yes          | No                       | 18             |
| 13 | 80      | Yes          | No                       | 18             |
| 14 | 28      | Yes          | No                       | 18             |
*/