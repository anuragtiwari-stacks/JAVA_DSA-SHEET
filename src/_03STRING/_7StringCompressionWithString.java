package _03STRING;

public class _7StringCompressionWithString
{
    public static String compress(String str)
    {
        String compressed = "";  // empty string to build result
        int count = 1;

        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i) == str.charAt(i - 1))
            {
                count++;
            }
            else
            {
                compressed += str.charAt(i - 1);  // add previous char
                compressed += count;              // add count
                count = 1;                       // reset count for new char
            }
        }

        // Append last group
        compressed += str.charAt(str.length() - 1);
        compressed += count;

        return compressed;
    }

    public static void main(String[] args)
    {
        String input = "aaabbcc";
        String output = compress(input);
        System.out.println("Compressed string: " + output);
    }
}
