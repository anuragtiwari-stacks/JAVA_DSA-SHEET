package _3STRING;

public class _4MaxFreqCharInString
{
    public static void main(String[] args)
    {
        String str = "abaccab";

        // Frequency array for lowercase characters
        int[] freq = new int[26]; // All initialized to 0

        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        int maxFreq = 0;
        char maxChar = ' ';

        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > maxFreq)
            {
                maxFreq = freq[i];
                maxChar = (char)(i + 'a');
            }
        }

        System.out.println("Character with highest frequency: " + maxChar);
        System.out.println("Frequency: " + maxFreq);
    }
}

/*
🔹 Step 2: Count frequency of each character
Loop through each character of the string and update the frequency:

| i | `str.charAt(i)` | `ch - 'a'` | `freq[ch - 'a']++` | freq\[] (only non-zero values shown) |
| - | --------------- | ---------- | ------------------ | ------------------------------------ |
| 0 | `'a'`           | 0          | `freq[0] = 1`      | a=1                                  |
| 1 | `'b'`           | 1          | `freq[1] = 1`      | a=1, b=1                             |
| 2 | `'a'`           | 0          | `freq[0] = 2`      | a=2, b=1                             |
| 3 | `'c'`           | 2          | `freq[2] = 1`      | a=2, b=1, c=1                        |
| 4 | `'c'`           | 2          | `freq[2] = 2`      | a=2, b=1, c=2                        |
| 5 | `'a'`           | 0          | `freq[0] = 3`      | a=3, b=1, c=2                        |
| 6 | `'b'`           | 1          | `freq[1] = 2`      | a=3, b=2, c=2                        |


🔹 Step 3: Find character with max frequency
Loop through the freq[] array and find the max:

 | i    | `freq[i]` | Condition: `freq[i] > maxFreq` | `maxFreq` | `maxChar` |
| ---- | --------- | ------------------------------ | --------- | --------- |
| 0    | 3         | `3 > 0` → yes                  | 3         | `'a'`     |
| 1    | 2         | `2 > 3` → no                   | 3         | `'a'`     |
| 2    | 2         | `2 > 3` → no                   | 3         | `'a'`     |
| 3–25 | 0         | All zero                       | –         | –         |
*/