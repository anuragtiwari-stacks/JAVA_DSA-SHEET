package _03STRING;

public class _7StringCompression
{
    public static String compress(String str)
    {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++)
        {
            if (str.charAt(i) == str.charAt(i + 1))
            {
                count++;
            }
            else
            {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }

        // last character handle
        compressed.append(str.charAt(str.length() - 1));
        compressed.append(count);

        return compressed.toString();
    }


    public static void main(String[] args)
    {
        String input = "aaabbbccdd";
        String output = compress(input);
        System.out.println("Compressed string: " + output);
    }
}
