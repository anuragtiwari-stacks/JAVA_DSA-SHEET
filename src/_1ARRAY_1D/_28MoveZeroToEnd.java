package _1ARRAY_1D;

public class _28MoveZeroToEnd
{
    /*
     * LeetCode 283: Move Zeroes
     * Move all 0s to the end of the array
     * while maintaining the order of non-zero elements.
     */

    public static void moveZeroes(int[] nums)
    {
        int pos = 0;

        // Copy all non-zero elements to the front
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != 0)
            {
                nums[pos] = nums[i];
                pos++;
            }
        }

        // Fill remaining positions with 0
        while (pos < nums.length)
        {
            nums[pos] = 0;
            pos++;
        }
    }

    // Main method for testing
    public static void main(String[] args)
    {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        for (int num : nums)
        {
            System.out.print(num + " ");
        }
    }
}
