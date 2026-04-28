package _01ARRAY_1D._14MinOperation_Palindrome;

import java.util.*;

public class MinUpdate
{
    public static int minMerge(ArrayList<Integer> list)
    {
        int start = 0;
        int end = list.size() - 1;
        int count = 0;

        while(start < end)
        {
            if(list.get(start).equals(list.get(end)))
            {
                start++;
                end--;
            }
            else if(list.get(start) < list.get(end))
            {
                // merge left
                int sum = list.get(start) + list.get(start + 1);
                list.set(start + 1, sum);
                list.remove(start);

                end--; // size kam hua
                count++;
            }
            else
            {
                // merge right
                int sum = list.get(end) + list.get(end - 1);
                list.set(end - 1, sum);
                list.remove(end);

                end--;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 4, 5, 9, 1};

        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr)
        {
            list.add(x);
        }

        int result = minMerge(list);

        System.out.println("Minimum Merges: " + result);
    }
}