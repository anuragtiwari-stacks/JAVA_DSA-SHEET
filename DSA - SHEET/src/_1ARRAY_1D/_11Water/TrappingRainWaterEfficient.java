/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
*/

package _1ARRAY_1D._11Water;

public class TrappingRainWaterEfficient
{
    public static int trap(int[] height)
    {
        int n = height.length;
        if (n == 0)
        {
            return 0;
        }

        int[] lmax = new int[n];
        int[] rmax = new int[n];

        // Step 1: Fill lmax
        lmax[0] = height[0];
        for (int i = 1; i < n; i++)
        {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        // Step 2: Fill rmax
        rmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        // Step 3: Calculate trapped water
        int totalWater = 0;
        for (int i = 0; i < n; i++)
        {
            totalWater += Math.min(lmax[i], rmax[i]) - height[i];
        }

        return totalWater;
    }

    public static void main(String[] args)
    {
        int[] height1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println("Trapped Water = " + trap(height1)); // Output: 6

        int[] height2 = { 4, 2, 0, 3, 2, 5 };
        System.out.println("Trapped Water = " + trap(height2)); // Output: 9
    }
}
