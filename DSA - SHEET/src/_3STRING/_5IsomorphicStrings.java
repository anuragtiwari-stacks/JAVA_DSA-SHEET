/*
🔹 What is an Isomorphic String?
Two strings s and t are isomorphic if the characters in s can be replaced to get t,
with these conditions:

Each character in s must map to one and only one character in t.
No two different characters in s can map to the same character in t.

Example:
Input:  s = "egg", t = "add"
Output: true
Explanation:
  'e' → 'a'
  'g' → 'd' (both 'g's map to the same 'd')
*/
package _3STRING;

public class _5IsomorphicStrings
{
    public static boolean areIsomorphic(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < s1.length(); i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            // Map char to index 0-25
            int idx1 = ch1 - 'a';
            int idx2 = ch2 - 'a';

            // Check if first occurrence indexes match
            if (f1[idx1] != f2[idx2])
            {
                return false;
            }

            // Store current position + 1 (to avoid confusion with default 0)
            f1[idx1] = i + 1;
            f2[idx2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args)
    {
        String s1 = "paper";
        String s2 = "title";
        System.out.println(s1 + " and " + s2 + " are isomorphic? " + areIsomorphic(s1, s2));

        String s3 = "foo";
        String s4 = "bar";
        System.out.println(s3 + " and " + s4 + " are isomorphic? " + areIsomorphic(s3, s4));
    }
}


/*
| Step | i | s1.charAt(i) | s2.charAt(i) | freq1 value | freq2 value | Equal? | Action                       |
| ---- | - | ------------ | ------------ | ----------- | ----------- | ------ | ---------------------------- |
| 1    | 0 | e            | a            | 0           | 0           | ✅      | Set freq1\[e]=1, freq2\[a]=1 |
| 2    | 1 | g            | d            | 0           | 0           | ✅      | Set freq1\[g]=2, freq2\[d]=2 |
| 3    | 2 | g            | d            | 2           | 2           | ✅      | Set freq1\[g]=3, freq2\[d]=3 |
*/

/*
| Step | i | s1.charAt(i) | s2.charAt(i) | freq1 value | freq2 value | Equal? | Action                       |
| ---- | - | ------------ | ------------ | ----------- | ----------- | ------ | ---------------------------- |
| 1    | 0 | f            | b            | 0           | 0           | ✅      | Set freq1\[f]=1, freq2\[b]=1 |
| 2    | 1 | o            | a            | 0           | 0           | ✅      | Set freq1\[o]=2, freq2\[a]=2 |
| 3    | 2 | o            | r            | 2           | 0           | ❌      | Return false                 |
*/