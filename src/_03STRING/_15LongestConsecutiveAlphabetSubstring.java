package _03STRING;

public class _15LongestConsecutiveAlphabetSubstring
{
    public static int longestConsecutiveSubstring(String s)
    {
        if (s.length() == 0) return 0;

        int maxLen = 1;
        int currLen = 1;

        for (int i = 0; i < s.length() - 1; i++)
        {
            // compare current with next
            if (s.charAt(i + 1) - s.charAt(i) == 1)
            {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }
            else
            {
                currLen = 1;
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
