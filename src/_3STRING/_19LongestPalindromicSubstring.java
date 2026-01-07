package _3STRING;

public class _19LongestPalindromicSubstring {

    // Function to check if a string is a palindrome
    private boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if (ch1 != ch2)
            {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public String longestPalindrome(String s)
    {
        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                String sub = s.substring(i, j);

                if (isPalindrome(sub) && sub.length() > longest.length())
                {
                    longest = sub;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args)
    {
        _19LongestPalindromicSubstring solution = new _19LongestPalindromicSubstring();

        System.out.println(solution.longestPalindrome("babad"));  // Output: "bab" or "aba"
        System.out.println(solution.longestPalindrome("cbbd"));   // Output: "bb"
    }
}
