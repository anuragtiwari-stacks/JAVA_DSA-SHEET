package _03STRING;

public class _6MaxNumberInList
{
    public static void main(String[] args)
    {
        String[] numbers = {"3492857", "93837874467637638738738938", "37838", "234", "12", "333"};

        String max = numbers[0];

        for (int i = 1; i < numbers.length; i++)
        {
            // Compare as BigInteger to handle very large numbers
            if (new java.math.BigInteger(numbers[i]).compareTo(new java.math.BigInteger(max)) > 0)
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
