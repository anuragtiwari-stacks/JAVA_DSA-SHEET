package _03STRING;

import java.util.HashMap;

public class _4MaxFreqCharWithHashing
{
    public static void main(String[] args)
    {
        String str = "abAccA@b";

        // Step 1: Create a map to store frequency
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 2: Count frequency of each character
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if (map.containsKey(ch))
            {
                int Count = map.get(ch);
                map.put(ch, Count + 1);
            }
            else
            {
                map.put(ch, 1);
            }
        }

        // Step 3: Find the character with max frequency
        int maxFreq = 0;
        char maxChar = ' ';

        for (char key : map.keySet())
        {
            int freq = map.get(key);
            if (freq > maxFreq)
            {
                maxFreq = freq;
                maxChar = key;
            }
        }

        System.out.println("Character with highest frequency: " + maxChar);
        System.out.println("Frequency: " + maxFreq);
    }
}
