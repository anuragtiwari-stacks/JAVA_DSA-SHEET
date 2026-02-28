package _03STRING;

import java.util.*;

public class _18GroupAnagrams
{
    // Helper method to check if two strings are anagrams
    public static boolean isAnagram(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }

        int[] freq = new int[26];

        for (char c : s1.toCharArray())
        {
            freq[c - 'a']++;
        }

        for (char c : s2.toCharArray())
        {
            freq[c - 'a']--;
        }

        for (int f : freq)
        {
            if (f != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs)
    {
        boolean[] used = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++)
        {
            if (used[i])
            {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < strs.length; j++)
            {
                if (!used[j] && isAnagram(strs[i], strs[j]))
                {
                    group.add(strs[j]);
                    used[j] = true;
                }
            }

            result.add(group);
        }

        return result;
    }

    public static void main(String[] args)
    {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }
}

/*
-------------------- DRY RUN --------------------

Input:
["eat","tea","tan","ate","nat","bat"]

used = [false,false,false,false,false,false]
result = []

i = 0 → "eat"
group = ["eat"]
used[0] = true

j = 1 → "tea"
isAnagram("eat","tea") → true
group = ["eat","tea"]
used[1] = true

j = 2 → "tan"
isAnagram("eat","tan") → false

j = 3 → "ate"
isAnagram("eat","ate") → true
group = ["eat","tea","ate"]
used[3] = true

j = 4 → "nat"
isAnagram("eat","nat") → false

j = 5 → "bat"
isAnagram("eat","bat") → false

result = [["eat","tea","ate"]]

-----------------------------------------------

i = 1 → already used → skip

i = 2 → "tan"
group = ["tan"]
used[2] = true

j = 3 → already used → skip

j = 4 → "nat"
isAnagram("tan","nat") → true
group = ["tan","nat"]
used[4] = true

j = 5 → "bat"
isAnagram("tan","bat") → false

result = [["eat","tea","ate"], ["tan","nat"]]

-----------------------------------------------

i = 3 → already used → skip
i = 4 → already used → skip

i = 5 → "bat"
group = ["bat"]
used[5] = true

result = [["eat","tea","ate"], ["tan","nat"], ["bat"]]

Final Output:
[["eat","tea","ate"], ["tan","nat"], ["bat"]]

-----------------------------------------------
*/
