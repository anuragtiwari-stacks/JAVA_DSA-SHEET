// 575. Distribute Candies
package _01ARRAY_1D;

import java.util.*;

public class _25Distribute
{
    static int distributeCandies(int[] candyType)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int x : candyType)
        {
            set.add(x);
        }

        int uniqueTypes = set.size();
        int maxSisterGets = candyType.length / 2;

        return Math.min(uniqueTypes, maxSisterGets);
    }

    public static void main(String[] args)
    {
        int[] candyType1 = {1, 1, 2, 2, 3, 3};
        int[] candyType2 = {1, 1, 2, 3};

        System.out.println(distributeCandies(candyType1)); // Output: 3
        System.out.println(distributeCandies(candyType2)); // Output: 2
    }
}
