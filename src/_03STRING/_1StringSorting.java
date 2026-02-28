package _03STRING;

import java.util.Arrays;

public class _1StringSorting
{
    public static void main(String[] args)
    {
        // Original input string
        String input = "javaString";

        // ------------- Using String -------------

        // Step 1: Convert to character array
        char[] charArray1 = input.toCharArray();

        // Step 2: Sort the character array
        Arrays.sort(charArray1);

        // Step 3: Convert sorted char array back to a string
        String sortedString = new String(charArray1);

        // Output result
        System.out.println("Sorted using String: " + sortedString);

        // ------------- Using StringBuilder -------------

        // Step 1: Convert to char array again for a fresh copy
        char[] charArray2 = input.toCharArray();

        // Step 2: Sort the character array
        Arrays.sort(charArray2);

        // Step 3: Use StringBuilder to build the sorted string
        StringBuilder sb = new StringBuilder();
        for (char ch : charArray2)
        {
            sb.append(ch);
        }

        // Output result
        System.out.println("Sorted using StringBuilder: " + sb.toString());
    }
}
