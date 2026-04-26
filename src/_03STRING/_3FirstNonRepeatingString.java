package _03STRING;

import java.util.HashMap;

public class _3FirstNonRepeatingString
{
    public static String firstNonRepeating(String[] arr)
    {
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Count each string using simple if-else
        for (int i = 0; i < arr.length; i++)
        {
            String word = arr[i];

            if (map.containsKey(word))
            {
                map.put(word, map.get(word) + 1);
            }
            else
            {
                map.put(word, 1);
            }
        }

        // Step 2: Find first non-repeating string
        for (int i = 0; i < arr.length; i++)
        {
            if (map.get(arr[i]) == 1)
            {
                return arr[i];
            }
        }

        return null;
    }

    public static void main(String[] args)
    {
        String[] arr = { "apple", "banana", "apple", "cherry", "banana", "date" };

        String result = firstNonRepeating(arr);

        if (result != null)
        {
            System.out.println("First non-repeating string is: " + result);
        }
        else
        {
            System.out.println("No non-repeating string found.");
        }
    }
}

/*
🔹 Step 1: Count frequencies
We loop through the array and update the map:
| Iteration | `arr[i]` | Action                                          | `map`                                   |
| --------- | -------- | ----------------------------------------------- | --------------------------------------- |
| 0         | "apple"  | Not in map → `put("apple", 1)`                  | { apple=1 }                             |
| 1         | "banana" | Not in map → `put("banana", 1)`                 | { apple=1, banana=1 }                   |
| 2         | "apple"  | In map → `get("apple")=1` → `put("apple", 2)`   | { apple=2, banana=1 }                   |
| 3         | "cherry" | Not in map → `put("cherry", 1)`                 | { apple=2, banana=1, cherry=1 }         |
| 4         | "banana" | In map → `get("banana")=1` → `put("banana", 2)` | { apple=2, banana=2, cherry=1 }         |
| 5         | "date"   | Not in map → `put("date", 1)`                   | { apple=2, banana=2, cherry=1, date=1 } |

🔹 Step 2: Find first element with count 1
| Iteration | `arr[i]` | `map.get(arr[i])` | Action            |
| --------- | -------- | ----------------- | ----------------- |
| 0         | "apple"  | 2                 | skip              |
| 1         | "banana" | 2                 | skip              |
| 2         | "apple"  | 2                 | skip              |
| 3         | "cherry" | 1                 | return "cherry" ✅ |
*/