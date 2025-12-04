package _3STRING;

public class _8Palindrome
{

    // Method to check if a string is a palindrome using StringBuilder
    public static boolean isPalindrome(String s)
    {
        //convert to lowercase
        s=s.toLowerCase();

        // Use StringBuilder to reverse the string
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        // Check if original and reversed strings are equal
        return s.equals(reversed);
    }

    public static void main(String[] args)
    {
        // Example input
        String input = "Level";

        // Check if the input is a palindrome
        boolean result = isPalindrome(input);

        // Print the result
        System.out.println("Is it a palindrome? " + result);
    }

}

/*
However, when checking if a word is a palindrome, we usually ignore case—that is, we treat uppercase and lowercase letters as the same. So:

"Level" becomes "level" (when case is ignored)

Reversed: "level" → still "level"
*/