package _03STRING;

import java.util.*;

public class _18GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Map: sorted word -> list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Step 1: sort characters of word
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            // Step 2: put into map
            if (!map.containsKey(key))
            {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
            else
            {
                map.get(key).add(word);
            }
        }

        // Step 3: return all grouped values
        List<List<String>> result = new ArrayList<>();

        for (List<String> list : map.values())
        {
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {

        String[] input = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = groupAnagrams(input);

        // Print result nicely
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}