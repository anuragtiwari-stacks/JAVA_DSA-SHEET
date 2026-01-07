package _12Graph;

public class _10
{
    public static boolean canMeasureWater(int jug1, int jug2, int target)
    {
        // Case 1: target is 0
        if (target == 0)
        {
            return true;
        }

        // Case 2: target more than total capacity
        if (target > jug1 + jug2)
        {
            return false;
        }

        // Case 3: check GCD condition
        return target % gcd(jug1, jug2) == 0;
    }

    // Helper method to calculate GCD
    private static int gcd(int a, int b)
    {
        while (b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Driver code for IDE
    public static void main(String[] args)
    {
        int jug1 = 3;
        int jug2 = 5;
        int target = 4;

        System.out.println(canMeasureWater(jug1, jug2, target));
    }
}


/*
Input:
jug1 = 3
jug2 = 5
target = 4

Step 1:
target != 0 → continue

Step 2:
jug1 + jug2 = 3 + 5 = 8
target = 4 <= 8 → OK

Step 3:
gcd(3, 5) = 1

Step 4:
target % gcd = 4 % 1 = 0

So:
return true
*/
