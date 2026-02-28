package _15BitManipulation;

// Leetcode: 1680
public class _6Concatenation
{
    public static int concatenatedBinary(int n)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++)
        {
            String s = Integer.toBinaryString(i);
            sb.append(s);
        }

        String str = sb.toString();

        int x = Integer.parseInt(str, 2);   // Works only for small n (32-bit limit)

        return x % 1000000007;
    }

    public static void main(String[] args)
    {
        int n = 3;

        int result = concatenatedBinary(n);

        System.out.println("Concatenated Binary Result = " + result);
    }
}

/*
DRY RUN

Input:
n = 3

Step 1: Convert numbers to binary

1 -> 1
2 -> 10
3 -> 11

Step 2: Concatenate
"1" + "10" + "11"
= "11011"

Step 3: Convert to decimal
11011 (binary) = 27

Step 4: Apply modulo
27 % 1000000007 = 27

Final Answer:
Concatenated Binary Result = 27

===================================================================================================================================================

NOTE:
This solution is logically correct
but works only when final binary length <= 31 bits.
Otherwise Integer.parseInt() will throw NumberFormatException.
*/