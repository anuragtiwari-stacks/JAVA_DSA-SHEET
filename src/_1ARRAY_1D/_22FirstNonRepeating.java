package _1ARRAY_1D;

import java.util.HashMap;

public class _22FirstNonRepeating
{
    public static int firstNonRepeating(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Put all elements in the map with their count
        for (int i = 0; i < arr.length; i++)
        {
            if (map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else
            {
                map.put(arr[i], 1);
            }
        }

        // Step 2: Find the first element with count 1
        for (int i = 0; i < arr.length; i++)
        {
            if (map.get(arr[i]) == 1)
            {
                return arr[i];
            }
        }

        return -1; // If no non-repeating element found
    }

    public static void main(String[] args)
    {
        int[] arr = {9, 4, 9, 6, 7, 4};

        int result = firstNonRepeating(arr);

        if (result != -1)
        {
            System.out.println("First non-repeating element is: " + result);
        }
        else
        {
            System.out.println("No non-repeating element found.");
        }
    }
}
