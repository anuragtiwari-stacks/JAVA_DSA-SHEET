package _3STRING;

public class _25WildcardMatching
{

    // Main matching function (recursive)
    public static boolean match(String wild, String pattern)
    {
        return matchHelper(wild.toCharArray(), pattern.toCharArray(), 0, 0);
    }

    // Helper function with char arrays and indices
    private static boolean matchHelper(char[] wild, char[] pattern, int i, int j)
    {
        // If both strings are fully traversed
        if (i == wild.length && j == pattern.length)
        {
            return true;
        }

        // If wild has '*' but no more characters in pattern
        if (i < wild.length && wild[i] == '*' && i + 1 < wild.length && j == pattern.length)
        {
            return false;
        }

        // If characters match or wild has '?'
        if (i < wild.length && j < pattern.length &&
                (wild[i] == '?' || wild[i] == pattern[j]))
        {
            return matchHelper(wild, pattern, i + 1, j + 1);
        }

        // If wild has '*', try two possibilities:
        // 1. '*' matches zero characters (i + 1, j)
        // 2. '*' matches one character from pattern (i, j + 1)
        if (i < wild.length && wild[i] == '*')
        {
            return matchHelper(wild, pattern, i + 1, j) ||
                    (j < pattern.length && matchHelper(wild, pattern, i, j + 1));
        }

        // All other cases - mismatch
        return false;
    }

    // Main method for testing
    public static void main(String[] args)
    {
        String wild = "a*b?d";
        String pattern = "aXYbcd";

        if (match(wild, pattern))
        {
            System.out.println("Yes, the strings match.");
        }
        else
        {
            System.out.println("No, the strings do not match.");
        }
    }
}

/*
How the code works:
We have two strings:

1-wild (may contain * and ?)
2-pattern (no wildcards)

We use a recursive helper function
matchHelper(wild, pattern, i, j) to check if wild[i..end] matches pattern[j..end].
*/