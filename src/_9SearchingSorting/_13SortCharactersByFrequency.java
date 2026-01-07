package _9SearchingSorting;

import java.util.*;

public class _13SortCharactersByFrequency
{

    public static String frequencySort(String s)
    {
        // Step 1: Count frequency manually
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray())
        {
            if (freqMap.containsKey(ch))
            {
                freqMap.put(ch, freqMap.get(ch) + 1);
            }
            else
            {
                freqMap.put(ch, 1);
            }
        }

        // Step 2: Max Heap based on frequency
        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>(new Comparator<Character>()
                {
                    public int compare(Character a, Character b)
                    {
                        return freqMap.get(b) - freqMap.get(a);
                    }
                });

        maxHeap.addAll(freqMap.keySet());

        // Step 3: Build result string
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty())
        {
            char ch = maxHeap.poll();
            int count = freqMap.get(ch);

            for (int i = 0; i < count; i++)
            {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "tree";

        String output = frequencySort(s);
        System.out.println("Sorted by frequency: " + output);
    }
}

/*
Input:
s = "tree"

Step 1: Frequency Map
t -> 1
r -> 1
e -> 2

Step 2: Max Heap (by frequency)
Order: e, t, r

Step 3: Build Result
poll 'e' → "ee"
poll 't' → "eet"
poll 'r' → "eetr"

Final Output:
"eetr"   (or "eert" – both correct)
*/
