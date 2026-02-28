/*
Problem:
Given a sentence (string),
convert it into its equivalent sequence of numbers based on the classic mobile phone numeric keypad.

| Key | Letters   |
| --- | --------- |
| 2   | ABC       |
| 3   | DEF       |
| 4   | GHI       |
| 5   | JKL       |
| 6   | MNO       |
| 7   | PQRS      |
| 8   | TUV       |
| 9   | WXYZ      |
| 0   | Space ( ) |
*/
package _03STRING;

public class _13MobileKeypadConverter
{

    // Method to convert sentence to keypad sequence
    public static String convertToKeypadSequence(String sentence)
    {
        // Mapping letters a-z to their keypad sequences
        String[] keypad = {
                "0",     // space maps to 0
                "",      // 1 (no letters)
                "2",     // a
                "22",    // b
                "222",   // c
                "3",     // d
                "33",    // e
                "333",   // f
                "4",     // g
                "44",    // h
                "444",   // i
                "5",     // j
                "55",    // k
                "555",   // l
                "6",     // m
                "66",    // n
                "666",   // o
                "7",     // p
                "77",    // q
                "777",   // r
                "7777",  // s
                "8",     // t
                "88",    // u
                "888",   // v
                "9",     // w
                "99",    // x
                "999",   // y
                "9999"   // z
        };

        StringBuilder result = new StringBuilder();

        // Convert sentence to lowercase for easy mapping
        sentence = sentence.toLowerCase();

        for (int i = 0; i < sentence.length(); i++)
        {
            char ch = sentence.charAt(i);

            if (ch == ' ')
            {
                // Space maps to 0
                result.append("0");
            }
            else if (ch >= 'a' && ch <= 'z')
            {
                // Map character to keypad sequence
                int index = ch - 'a' + 2;
                result.append(keypad[index]);
            }
            // Ignore other characters (digits, punctuation)
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String input1 = "GEEKSFORGEEKS";
        System.out.println(convertToKeypadSequence(input1));
        // Expected: 4333355777733366677743333557777

        String input2 = "HELLO WORLD";
        System.out.println(convertToKeypadSequence(input2));
        // Expected: 4433555555666096667775553
    }

}
