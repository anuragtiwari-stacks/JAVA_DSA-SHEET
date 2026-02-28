/*
LOGIC:
1. We check all possible substrings of the given string.
2. For each substring, we count the frequency of every character.
3. We find the character with the maximum frequency in that substring.
4. To make all characters in the substring same:
      replacements = length of substring - maximum frequency
5. If replacements needed are less than or equal to k, the substring is valid.
6. We store the maximum length among all valid substrings.
7. Finally, we return the maximum length found.
*/

package _03STRING;

public class _16LongestRepeatingCharacterReplacement
{
    public static int characterReplacement(String s, int k)
    {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            int[] freq = new int[26];

            for (int j = i; j < n; j++)
            {
                freq[s.charAt(j) - 'A']++;

                int maxFreq = 0;
                for (int f : freq)
                {
                    maxFreq = Math.max(maxFreq, f);
                }

                int len = j - i + 1;
                int replacements = len - maxFreq;

                if (replacements <= k)
                {
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(characterReplacement("ABAB", 2));     // 4
        System.out.println(characterReplacement("AABABBA", 1));  // 4
    }
}

/*
-------------------- DRY RUN --------------------

Example 1:
s = "ABAB", k = 2

i = 0
  j = 0 → substring = "A"
      freq[A] = 1, maxFreq = 1
      len = 1, replacements = 1 - 1 = 0 ≤ 2
      ans = 1

  j = 1 → substring = "AB"
      freq[A]=1, freq[B]=1, maxFreq = 1
      len = 2, replacements = 2 - 1 = 1 ≤ 2
      ans = 2

  j = 2 → substring = "ABA"
      freq[A]=2, freq[B]=1, maxFreq = 2
      len = 3, replacements = 3 - 2 = 1 ≤ 2
      ans = 3

  j = 3 → substring = "ABAB"
      freq[A]=2, freq[B]=2, maxFreq = 2
      len = 4, replacements = 4 - 2 = 2 ≤ 2
      ans = 4

i = 1
  substrings: "B", "BA", "BAB"
  max valid length here = 3 (ans remains 4)

i = 2
  substrings: "A", "AB"
  max valid length = 2

i = 3
  substring: "B"
  max valid length = 1

Final Answer = 4

-----------------------------------------------

Example 2:
s = "AABABBA", k = 1

i = 0
  "A"     → replacements = 0 → valid
  "AA"    → replacements = 0 → valid
  "AAB"   → maxFreq=2, len=3, replacements=1 → valid
  "AABA"  → maxFreq=3, len=4, replacements=1 → valid (ans=4)
  "AABAB" → maxFreq=3, len=5, replacements=2 → invalid

Other i values checked similarly
Maximum valid length found = 4

-----------------------------------------------
*/
