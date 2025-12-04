package _3STRING;

public class _22CheckPalindromicSubsequence
{
    // Check if sub is subsequence of s
    private boolean isSubsequence(String s, String sub)
    {
        int i = 0; // pointer for s
        int j = 0; // pointer for sub

        while (i < s.length() && j < sub.length())
        {
            if (s.charAt(i) == sub.charAt(j))
            {
                j++;
            }
            i++;
        }
        // If pointer j reached end of sub,
        // it means all characters of sub are found in s in order

        if(j == sub.length())
        {
            return  true;
        }
        else
        {
            return false;
        }
    }

    // Check if string is palindrome
    private boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // Check if sub is palindromic subsequence of s
    public boolean isPalindromicSubsequence(String s, String sub)
    {
        return isSubsequence(s, sub) && isPalindrome(sub);
    }

    public static void main(String[] args)
    {
        _22CheckPalindromicSubsequence solution = new _22CheckPalindromicSubsequence();

        String s = "abacbdab";

        System.out.println(solution.isPalindromicSubsequence(s, "aba"));  // true
        System.out.println(solution.isPalindromicSubsequence(s, "abc"));  // false (not palindrome)
        System.out.println(solution.isPalindromicSubsequence(s, "bab"));  // true
        System.out.println(solution.isPalindromicSubsequence(s, "acd"));  // false (not subsequence)
    }
}

/*
Dry Run for: isPalindromicSubsequence("abacbdab", "abc")

Step 1: Call isPalindromicSubsequence("abacbdab", "abc")
  -> calls isSubsequence("abacbdab", "abc") AND isPalindrome("abc")

Step 2: isSubsequence("abacbdab", "abc")
  Initialize: i = 0, j = 0

  Loop:
    i=0, s[i]='a', sub[j]='a' -> match, i=1, j=1
    i=1, s[i]='b', sub[j]='b' -> match, i=2, j=2
    i=2, s[i]='a', sub[j]='c' -> no match, i=3
    i=3, s[i]='c', sub[j]='c' -> match, i=4, j=3

  j == sub.length() → return true

Step 3: isPalindrome("abc")
  i=0, j=2
  s[0]='a' != s[2]='c' → return false

Step 4: isPalindromicSubsequence returns:
  isSubsequence = true
  isPalindrome = false
  Result = true && false = false

Final Output: false
*/
