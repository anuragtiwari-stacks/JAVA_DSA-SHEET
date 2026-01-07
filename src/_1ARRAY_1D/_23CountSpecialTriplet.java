/*Problem: Count Special Triplets

You are given an integer array nums of size n.
Your task is to count the number of special triplets (i, j, k) such that:

1. 0 ≤ i < j < k < n
2. nums[i] = 2 × nums[j]
3. nums[k] = 2 × nums[j]

Return the total number of such special triplets.*/

package _1ARRAY_1D;
public class _23CountSpecialTriplet
{
    public static int specialTriplets(int[] nums)
    {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    if (nums[i] == 2 * nums[j] && nums[k] == 2 * nums[j])
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 2, 4, 8, 4};

        int result = specialTriplets(nums);
        System.out.println("Special Triplets Count = " + result);
    }
}
