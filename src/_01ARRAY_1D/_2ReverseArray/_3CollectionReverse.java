package _01ARRAY_1D._2ReverseArray;

import java.util.*;

public class _3CollectionReverse
{
    public static void main(String[] args)
    {
        Integer[] arr = {1, 2, 3, 4, 5};

        List <Integer> list = Arrays.asList(arr);  // Convert array to List

        Collections.reverse(list);  // Reverse the List (and array)

        for (int i : list)  // Print reversed elements
        {
            System.out.print(i + " ");
        }
    }
}
