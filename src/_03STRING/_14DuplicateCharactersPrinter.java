package _03STRING;

public class _14DuplicateCharactersPrinter
{
    // Print duplicate characters in alphabetical order using freq[] directly
    public static void printDuplicateCharacters(String s)
    {
        int[] freq = new int[26]; // For 'a' to 'z'

        // Count frequency of each character
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') // Consider lowercase only
            {
                freq[ch - 'a']++;
            }
        }

        // Now print characters with freq > 1 in order from 'a' to 'z'
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 1)
            {
                char ch = (char)(i + 'a'); // Convert index back to char
                System.out.println(ch + ", count = " + freq[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        String input = "geeksforgeeks";
        printDuplicateCharacters(input);
    }
}
