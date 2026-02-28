package _05StackQueue;

public class _6TrappingRainWater
{
    /*
    LOGIC:
    ------
    Rain water tab trap hota hai jab:
    water at index i =
    min(leftMax, rightMax) - height[i]

    Steps:
    1. leftMax[i]  = left side ka maximum height
    2. rightMax[i] = right side ka maximum height
    3. Har index par:
       water += min(leftMax[i], rightMax[i]) - height[i]
    4. Total water return karo
    */

    public static int trap(int[] height)
    {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++)
        {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;

        for (int i = 0; i < n; i++)
        {
            water = water + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

    public static void main(String[] args)
    {
        int[] height = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height));
    }
}

/*
DRY RUN:
--------

Input:
height = [4, 2, 0, 3, 2, 5]
Index:     0  1  2  3  4  5

Step 1: leftMax
leftMax = [4, 4, 4, 4, 4, 5]

Step 2: rightMax
rightMax = [5, 5, 5, 5, 5, 5]

--------------------------------
Index-wise trapped water:
--------------------------------

i = 0:
min(4,5) - 4 = 0

i = 1:
min(4,5) - 2 = 2

i = 2:
min(4,5) - 0 = 4

i = 3:
min(4,5) - 3 = 1

i = 4:
min(4,5) - 2 = 2

i = 5:
min(5,5) - 5 = 0

--------------------------------
Total Water:
2 + 4 + 1 + 2 = 9

FINAL ANSWER:
-------------
9
*/
