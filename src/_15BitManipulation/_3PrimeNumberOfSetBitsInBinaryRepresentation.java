package _15BitManipulation;

//Leetcode: 762

public class _3PrimeNumberOfSetBitsInBinaryRepresentation
{
    public static int countPrimeSetBits(int left, int right)
    {
        int count = 0;

        for(int i = left; i <= right; i++)
        {
            String binary = Integer.toBinaryString(i);

            int ones = 0;

            for(int j = 0; j < binary.length(); j++)
            {
                if(binary.charAt(j) == '1')
                {
                    ones++;
                }
            }

            count = count + isPrime(ones);
        }

        return count;
    }

    public static int isPrime(int ones)
    {
        if(ones < 2)
        {
            return 0;
        }

        for(int i = 2; i * i <= ones; i++)
        {
            if(ones % i == 0)
            {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args)

        int left = 6;
        int right = 10;

        int result = countPrimeSetBits(left, right);

        System.out.println("Count of numbers with prime set bits = " + result);
    }
}