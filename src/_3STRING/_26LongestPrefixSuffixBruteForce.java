package _3STRING;

/*
FORMULA / RULE USED:

Prefix  = s.substring(0, len)
Suffix  = s.substring(n - len)

where:
n = length of string
len = current length being checked (proper prefix/suffix)
*/

public class _26LongestPrefixSuffixBruteForce
{
    public static int longestPrefixSuffix(String s)
    {
        int n = s.length();

        // Try all possible proper lengths from n-1 to 1
        for (int len = n - 1; len > 0; len--)
        {
            String prefix = s.substring(0, len);
            String suffix = s.substring(n - len);

            if (prefix.equals(suffix))
            {
                return len;
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(longestPrefixSuffix("abab"));        // 2
        System.out.println(longestPrefixSuffix("aabcdaabc"));  // 4
        System.out.println(longestPrefixSuffix("aaaa"));       // 3
        System.out.println(longestPrefixSuffix("abcde"));      // 0
    }
}

/*
-------------------- DRY RUN --------------------

Input:
s = "abab"
n = 4

len = 3
prefix = s.substring(0,3) = "aba"
suffix = s.substring(4-3) = s.substring(1) = "bab"
"aba" != "bab"  → not equal

len = 2
prefix = s.substring(0,2) = "ab"
suffix = s.substring(4-2) = s.substring(2) = "ab"
"ab" == "ab"  → match found

Return: 2
-----------------------------------------------
*/
