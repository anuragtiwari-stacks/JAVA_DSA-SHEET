/*
Question:
Given a string, find the minimum number of cuts required
such that every substring after the cuts is a palindrome.
Do not use recursion.
*/
package _3STRING;

public class _17PalindromeCuts
{
    static boolean isPalindrome(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static int minCuts(String s)
    {
        int n = s.length();
        int cuts = 0;
        int start = 0;

        // If the whole string is already a palindrome
        if (isPalindrome(s, 0, n - 1))
        {
            return 0;
        }

        for (int end = 0; end < n; end++)
        {
            if (isPalindrome(s, start, end))
            {
                if (end != n - 1)
                {
                    cuts++;
                    start = end + 1;
                }
            }
        }

        return cuts;
    }

    public static void main(String[] args)
    {
        String str = "aab";
        System.out.println("Minimum cuts needed: " + minCuts(str));
    }
}
