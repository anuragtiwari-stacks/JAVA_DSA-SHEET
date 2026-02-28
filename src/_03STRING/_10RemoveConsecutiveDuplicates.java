package _03STRING;

public class _10RemoveConsecutiveDuplicates
{

    // Method to remove consecutive duplicate characters from a string
    public static String removeDuplicates(String s)
    {
        if (s.length() <= 1)
        {
            return s;
        }

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++)
        {
            // Append character only if different from previous character
            if (s.charAt(i) != s.charAt(i - 1))
            {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String input1 = "aabb";
        System.out.println(removeDuplicates(input1)); // Output: "ab"

        String input2 = "aabaa";
        System.out.println(removeDuplicates(input2)); // Output: "aba"

        String input3 = "abcddcba";
        System.out.println(removeDuplicates(input3)); // Output: "abcdcba"
    }

}
