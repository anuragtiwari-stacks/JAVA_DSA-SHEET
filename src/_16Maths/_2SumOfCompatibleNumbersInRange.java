package _16Maths;/*LeetCode 3954. Sum of Compatible Numbers in Range I

Question:
You are given two integers n and k.

A positive integer x is called compatible if it satisfies both of the following conditions:

1. abs(n - x) <= k
2. (n & x) == 0

Return the sum of all compatible integers x.

Example:
Input: n = 2, k = 3
Output: 10

Explanation:
Compatible integers:
x = 1
x = 4
x = 5

Sum = 1 + 4 + 5 = 10
*/

public class _2SumOfCompatibleNumbersInRange
{
    public static int sumOfGoodIntegers(int n, int k)
    {
        int sum = 0;

        for(int x = Math.max(1, n - k); x <= n + k; x++)
        {
            if((Math.abs(n - x) <= k) && ((n & x) == 0))
            {
                sum += x;
            }
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int n = 2;
        int k = 3;

        int result = sumOfGoodIntegers(n, k);

        System.out.println("n = " + n);
        System.out.println("k = " + k);
        System.out.println("Sum of Compatible Numbers = " + result);
    }
}

/*
Expected Output:

n = 2
k = 3
Sum of Compatible Numbers = 10

Time Complexity : O(k)
Space Complexity: O(1)
*/