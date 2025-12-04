/*
Question:
Given two integers a and b,
print all numbers between a and b (inclusive) that are multiples of 2 or multiples of 5.

Input:
Two integers a and b.

Output:
All numbers in the range [a, b] that are divisible by 2 or 5,
printed in ascending order separated by spaces.
*/
package _1ARRAY_1D._21SpaceOptimization;

public class MultiplesOf2And5
{
    public static void printMultiples(int a, int b)
    {
        int size = Math.abs(b - a) + 1;
        int[] array = new int[size];

        // Mark multiples of 2 or 5 in the range [a, b]
        for (int i = a; i <= b; i++)
        {
            if (i % 2 == 0 || i % 5 == 0)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        // Example 1
        System.out.println("Input: 2 10");
        System.out.print("Output: ");
        printMultiples(2, 10);

        // Example 2
        System.out.println("Input: 60 95");
        System.out.print("Output: ");
        printMultiples(60, 95);
    }
}
