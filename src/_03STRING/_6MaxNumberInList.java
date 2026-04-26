package _03STRING;

import java.math.BigInteger;

public class _6MaxNumberInList
{
    public static void main(String[] args)
    {
        String[] numbers =
                {
                        "12345678901234567890",
                        "9876543210123456789012345",
                        "456789123456789",
                        "999999999999999999999999999999"
                };

        String max = numbers[0];

        for (int i = 1; i < numbers.length; i++)
        {
            BigInteger current = new BigInteger(numbers[i]);
            BigInteger maxVal = new BigInteger(max);

            if (current.compareTo(maxVal) > 0)
            {
                max = numbers[i];
            }
        }

        System.out.println("Maximum number is: " + max);
    }
}

/*
🧠 Why use BigInteger?
Some of your numbers are too big for normal integer types like int or long.
BigInteger lets you handle very large numbers safely in Java.
*/
