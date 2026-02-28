package _09SearchingSorting;

/*
 PROBLEM: 1051. Height Checker

 CONCEPT: DIRECT SORT + COMPARE

 APPROACH:
 1. Original array ka ek copy banao
 2. Copy ko Arrays.sort() se sort karo
 3. Original array aur sorted array ko index-wise compare karo
 4. Jahan mismatch mile, count increase karo

 NOTE:
 - Original array modify nahi hota
 - Logic simple aur readable hai

 TIME COMPLEXITY:
 O(n log n)

 SPACE COMPLEXITY:
 O(n)  (extra array used)
*/

import java.util.Arrays;

public class _3HeightChecker
{
    public static int heightChecker(int[] heights)
    {
        int[] expected = heights.clone();

        // Step 1: Sort the copied array
        Arrays.sort(expected);

        int count = 0;

        // Step 2: Compare original and sorted array
        for (int i = 0; i < heights.length; i++)
        {
            if (heights[i] != expected[i])
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] heights = {1, 1, 4, 2, 1, 3};

        System.out.println("Students in wrong position: "
                + heightChecker(heights));
    }
}

/*
 DRY RUN:

 heights  = {1, 1, 4, 2, 1, 3}

 Copy:
 expected = {1, 1, 4, 2, 1, 3}

 After Sorting:
 expected = {1, 1, 1, 2, 3, 4}

 Comparison:
 index 0: 1 == 1 → OK
 index 1: 1 == 1 → OK
 index 2: 4 != 1 → count = 1
 index 3: 2 == 2 → OK
 index 4: 1 != 3 → count = 2
 index 5: 3 != 4 → count = 3

 OUTPUT:
 Students in wrong position = 3
*/
