package _3STRING;

import java.util.LinkedHashMap;
import java.util.Map;

public class _11UniqueCharacters
{

    // Method to return only unique characters from the string
    public static String printUniqueCharacters(String s)
    {
        // LinkedHashMap to store character counts and preserve order
        Map<Character, Integer> map = new LinkedHashMap<>();

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(map.containsKey(ch))
            {
                int count = map.get(ch);
                map.put(ch,count+1);
            }

            else
            {
                map.put(ch,1);
            }
        }

        // Build result string of characters with count == 1
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == 1)
            {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String input1 = "aabb";
        System.out.println(printUniqueCharacters(input1)); // Output: ""

        String input2 = "aabaa";
        System.out.println(printUniqueCharacters(input2)); // Output: "b"

        String input3 = "abcddcba";
        System.out.println(printUniqueCharacters(input3)); // Output: ""

        String input4 = "abacdef";
        System.out.println(printUniqueCharacters(input4)); // Output: "bcdef"
    }

}

