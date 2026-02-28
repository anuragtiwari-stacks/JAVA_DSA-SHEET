package _03STRING;

public class _15LongestConsecutiveAlphabetSubstring
{
    public static int longestConsecutiveSubstring(String s)
    {
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < s.length(); i++)
        {
            // Check if current character is consecutive to previous
            if (s.charAt(i) - s.charAt(i - 1) == 1)
            {
                currLen++;
                if (currLen > maxLen)
                {
                    maxLen = currLen;
                }
            }
            else
            {
                currLen = 1; // reset if not consecutive
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        System.out.println(longestConsecutiveSubstring("abcde"));         // Output: 5
        System.out.println(longestConsecutiveSubstring("abdfgh"));        // Output: 2
        System.out.println(longestConsecutiveSubstring("xyzabc"));        // Output: 3
        System.out.println(longestConsecutiveSubstring("abacdefghij"));   // Output: 7
    }
}
