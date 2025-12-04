/*
You are given a string s and an integer k.
You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get
after performing the above operations.

Example 1:
Input:
s = "ABAB", k = 2
Output:
4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input:
s = "AABABBA", k = 1
Output:
4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

package _3STRING;

public class _17CharacterReplacement
{
    // Brute-force method: no sliding window
    public int characterReplacement(String s, int k)
    {
        int n = s.length();
        int maxLength = 0;

        // Check every substring
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                int[] freq = new int[26]; // frequency of chars A-Z
                int maxFreq = 0;

                // Count frequency of characters in s[i..j]
                for (int m = i; m <= j; m++)
                {
                    int idx = s.charAt(m);
                    freq[idx - 'A']++;
                    if (freq[idx - 'A'] > maxFreq)
                    {
                        maxFreq = freq[idx - 'A'];
                    }
                }

                int length = j - i + 1;
                int toReplace = length - maxFreq;

                // If replacements needed ≤ k, update maxLength
                if (toReplace <= k)
                {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args)
    {
        _17CharacterReplacement solution = new _17CharacterReplacement();

        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Input: " + s1 + ", k = " + k1);
        System.out.println("Output: " + solution.characterReplacement(s1, k1));
        // Expected output: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Input: " + s2 + ", k = " + k2);
        System.out.println("Output: " + solution.characterReplacement(s2, k2));
        // Expected output: 4
    }
}

/*
Dry Run: s = "ABAB", k = 2

n = s.length() = 4
Initialize maxLength = 0

Loop through all substrings:
--------------------------------------------------
i = 0, j = 0 → substring = "A"
   freq: A = 1
   maxFreq = 1
   length = 1
   toReplace = 1 - 1 = 0 ≤ 2 → maxLength = 1
--------------------------------------------------
i = 0, j = 1 → substring = "AB"
   freq: A = 1, B = 1
   maxFreq = 1
   length = 2
   toReplace = 2 - 1 = 1 ≤ 2 → maxLength = 2
--------------------------------------------------
i = 0, j = 2 → substring = "ABA"
   freq: A = 2, B = 1
   maxFreq = 2
   length = 3
   toReplace = 3 - 2 = 1 ≤ 2 → maxLength = 3
--------------------------------------------------
i = 0, j = 3 → substring = "ABAB"
   freq: A = 2, B = 2
   maxFreq = 2
   length = 4
   toReplace = 4 - 2 = 2 ≤ 2 → maxLength = 4
--------------------------------------------------
i = 1, j = 1 → substring = "B"
   freq: B = 1
   maxFreq = 1
   length = 1
   toReplace = 0 ≤ 2 → maxLength = 4 (unchanged)
--------------------------------------------------
i = 1, j = 2 → substring = "BA"
   freq: B = 1, A = 1
   maxFreq = 1
   length = 2
   toReplace = 1 ≤ 2 → maxLength = 4
--------------------------------------------------
i = 1, j = 3 → substring = "BAB"
   freq: B = 2, A = 1
   maxFreq = 2
   length = 3
   toReplace = 1 ≤ 2 → maxLength = 4
--------------------------------------------------
i = 2, j = 2 → substring = "A"
   freq: A = 1
   maxFreq = 1
   length = 1
   toReplace = 0 ≤ 2 → maxLength = 4
--------------------------------------------------
i = 2, j = 3 → substring = "AB"
   freq: A = 1, B = 1
   maxFreq = 1
   length = 2
   toReplace = 1 ≤ 2 → maxLength = 4
--------------------------------------------------
i = 3, j = 3 → substring = "B"
   freq: B = 1
   maxFreq = 1
   length = 1
   toReplace = 0 ≤ 2 → maxLength = 4

Final maxLength = 4
*/
