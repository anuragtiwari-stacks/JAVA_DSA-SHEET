package _3STRING;

public class _26LongestPrefixSuffixBruteForce
{

    // Function to find the length of the longest proper prefix
    // which is also a suffix
    public static int longestPrefixSuffix(String s)
    {
        int n = s.length();

        // Try all lengths from n-1 to 1
        for (int len = n - 1; len > 0; len--)
        {
            // Extract prefix of length 'len'
            String prefix = s.substring(0, len);

            // Extract suffix of length 'len'
            String suffix = s.substring(n - len, n);

            // If prefix and suffix are the same, return the length
            if (prefix.equals(suffix))
            {
                return len;
            }
        }

        // If no proper prefix-suffix found, return 0
        return 0;
    }

    // Main method to test the function
    public static void main(String[] args)
    {
        String s1 = "abab";
        String s2 = "aabcdaabc";
        String s3 = "aaaa";
        String s4 = "abcde";

        System.out.println("Longest Prefix-Suffix of \"" + s1 + "\": " + longestPrefixSuffix(s1));     // Output: 2
        System.out.println("Longest Prefix-Suffix of \"" + s2 + "\": " + longestPrefixSuffix(s2));     // Output: 4
        System.out.println("Longest Prefix-Suffix of \"" + s3 + "\": " + longestPrefixSuffix(s3));     // Output: 3
        System.out.println("Longest Prefix-Suffix of \"" + s4 + "\": " + longestPrefixSuffix(s4));     // Output: 0
    }
}

/*
🔹 Step-by-step dry run of the function longestPrefixSuffix("abab"):
String: "abab"
Length, n = 4

We check decreasing values of len from n - 1 to 1:

✅ Try len = 3
prefix = s.substring(0, 3) = "aba"
suffix = s.substring(1, 4) = "bab"
"aba" ≠ "bab" → Not a match.

✅ Try len = 2
prefix = s.substring(0, 2) = "ab"
suffix = s.substring(2, 4) = "ab"
"ab" = "ab" → ✅ Match found!

Return 2
 */