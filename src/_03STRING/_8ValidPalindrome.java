package _03STRING;

public class _8ValidPalindrome
{

    // Method to check if a string is a palindrome (simple version)
    public static boolean isPalindrome(String s)
    {
        // Remove spaces and convert to lowercase
        s = s.replace(" ", "").toLowerCase();

        // Compare characters from start and end
        int i = 0;
        int j = s.length() - 1;

        while (i < j)
        {
            if (s.charAt(i) != s.charAt(j))
            {
                return false; // Not a palindrome
            }

            i++;
            j--;
        }

        return true; // It's a palindrome
    }

    public static void main(String[] args)
    {
        // Example string
        String input = "madam";

        // Call the method and store result
        boolean result = isPalindrome(input);

        // Print the result
        System.out.println("Is it a palindrome? " + result);
    }

}

