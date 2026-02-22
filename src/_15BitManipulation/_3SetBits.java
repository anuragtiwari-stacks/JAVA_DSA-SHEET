package _15BitManipulation;

// Leetcode: 762

public class _3SetBits
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
    {
        int left = 6;
        int right = 10;

        int result = countPrimeSetBits(left, right);

        System.out.println("Count of numbers with prime set bits = " + result);
    }
}

/*
DRY RUN

Input:
left = 6
right = 10

Numbers checked: 6, 7, 8, 9, 10

---------------------------------
i = 6
Binary = 110
Number of 1's = 2
2 is prime → count = 1

---------------------------------
i = 7
Binary = 111
Number of 1's = 3
3 is prime → count = 2

---------------------------------
i = 8
Binary = 1000
Number of 1's = 1
1 is NOT prime → count = 2

---------------------------------
i = 9
Binary = 1001
Number of 1's = 2
2 is prime → count = 3

---------------------------------
i = 10
Binary = 1010
Number of 1's = 2
2 is prime → count = 4

---------------------------------

Final Output:
Count of numbers with prime set bits = 4

=================================================
*/