package _15BitManipulation;

/*
LeetCode: 1545
Problem: Find Kth Bit in Nth Binary String

S1 = "0"
Sn = Sn-1 + "1" + reverse(invert(Sn-1))
*/

public class _7FindKthBit
{
    public static char findKthBit(int n, int k)
    {
        if(n == 1)
        {
            return '0';
        }

        int len = (1 << n) - 1;      // Length of Sn
        int mid = (len + 1) / 2;    // Middle position

        if(k == mid)
        {
            return '1';
        }

        if(k < mid)
        {
            return findKthBit(n - 1, k);
        }

        else
        {
            int mirror = len - k + 1;
            char bit = findKthBit(n - 1, mirror);

            if(bit == '0')
            {
                return '1';
            }

            return '0';
        }
    }

    public static void main(String[] args)
    {
        int n = 3;
        int k = 5;

        char result = findKthBit(n, k);

        System.out.println("Answer = " + result);
    }
}


/*
==================== DRY RUN ====================

Input:
n = 3
k = 5

Step 1:
Length of S3 = 2^3 - 1 = 7
mid = (7 + 1) / 2 = 4

Since k = 5 > mid
We go to right half.

Mirror position:
mirror = 7 - 5 + 1 = 3

Now solve:
findKthBit(2, 3)

---------------------------------

For n = 2:
Length = 3
mid = 2

k = 3 > mid

Mirror = 3 - 3 + 1 = 1

Now solve:
findKthBit(1, 1)

---------------------------------

Base case:
n = 1 → return '0'

---------------------------------

Now unwind recursion:

Right side → invert '0' → '1'
Again right side → invert '1' → '0'

Final Answer:
0

=================================================
*/