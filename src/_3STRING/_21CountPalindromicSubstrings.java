/*
✅ Question
Given a string s, return the number of palindromic substrings in it.

A palindrome means the string is symmetric: it equals its reverse.
A substring means characters are next to each other (no skipping).

Example 1:
Input: s = "abc"
Output: 3
Explanation: Palindromic substrings are "a", "b", "c"

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Palindromic substrings are "a", "a", "a", "aa", "aa", "aaa"
*/
package _3STRING;

public class _21CountPalindromicSubstrings
{

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

    // Count all palindromic substrings by generating all substrings and checking palindrome
    public int countPalindromicSubstrings(String s)
    {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j <= n; j++)
            {
                String sub = s.substring(i, j);

                if (isPalindrome(sub))
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        _21CountPalindromicSubstrings solution = new _21CountPalindromicSubstrings();

        System.out.println(solution.countPalindromicSubstrings("abc"));  // Output: 3
        System.out.println(solution.countPalindromicSubstrings("aaa"));  // Output: 6
    }
}
