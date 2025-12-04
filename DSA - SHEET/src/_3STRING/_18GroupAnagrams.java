/*
Question: Group Anagrams
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

Examples:
Example 1:
Input:
strs = ["eat","tea","tan","ate","nat","bat"]
Output:
[["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:

There is no string in strs that can be rearranged to form "bat".

The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.

The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input:
strs = [""]
Output:
[[""]]

Example 3:
Input:
strs = ["a"]
Output:
[["a"]]
*/

package _3STRING;

import java.util.*;

public class _18GroupAnagrams
{

    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs)
        {
            int[] freq = new int[26];

            for (char c : s.toCharArray())
            {
                freq[c - 'a']++;
            }

            // Build a frequency-based key string
            StringBuilder keyBuilder = new StringBuilder();

            for (int count : freq)
            {
                keyBuilder.append('#');  // delimiter to avoid ambiguity
                keyBuilder.append(count);
            }

            String key = keyBuilder.toString();

            if (!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args)
    {
        _18GroupAnagrams solution = new _18GroupAnagrams();

        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> groupedAnagrams = solution.groupAnagrams(input);

        System.out.println(groupedAnagrams);
    }
}
