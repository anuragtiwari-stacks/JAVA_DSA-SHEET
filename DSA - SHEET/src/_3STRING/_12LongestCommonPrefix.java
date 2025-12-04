package _3STRING;

import java.util.Arrays;

public class _12LongestCommonPrefix
{
    // Method to find the longest common prefix using sorting
    public static String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }

        // Sort the array
        Arrays.sort(strs);

        // Compare only the first and last strings after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        // Find common prefix length between first and last strings
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i))
        {
            i++;
        }

        // Return the common prefix substring
        return first.substring(0, i);
    }

    public static void main(String[] args)
    {
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(input1)); // Output: "fl"

        String[] input2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(input2)); // Output: ""
    }
}

/*
Step-by-step example:
For the input:
["flower", "flow", "flight"]

Sorted array:
["flight", "flow", "flower"]

First string: "flight"

Last string: "flower"

| Index | flight | flower | Same? |
| ----- | ------ | ------ | ----- |
| 0     | f      | f      | Yes   |
| 1     | l      | l      | Yes   |
| 2     | i      | o      | No    |
*/

