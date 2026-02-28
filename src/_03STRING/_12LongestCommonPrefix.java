package _03STRING;

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

        // Take first and last string after sorting
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        // Compare characters one by one
        while (i < first.length() && i < last.length()
                && first.charAt(i) == last.charAt(i))
        {
            i++;
        }

        // Return common prefix
        return first.substring(0, i);
    }

    public static void main(String[] args)
    {
        String[] input1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(input1)); // fl

        String[] input2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(input2)); // ""
    }
}

/*
------------- DRY RUN (SIMPLE) -------------

Example 1:
Input = ["flower", "flow", "flight"]

After sorting:
["flight", "flow", "flower"]

first = "flight"
last  = "flower"

i = 0 → f == f → i = 1
i = 1 → l == l → i = 2
i = 2 → i != o → stop

Substring from 0 to 2 → "fl"
Return "fl"

-------------------------------------------

Example 2:
Input = ["dog", "racecar", "car"]

After sorting:
["car", "dog", "racecar"]

first = "car"
last  = "racecar"

i = 0 → c != r → stop immediately

No common prefix
Return ""

-------------------------------------------
*/
