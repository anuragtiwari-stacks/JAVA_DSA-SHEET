package _01ARRAY_1D._3SubArray;

public class _3MaxProduct
{
    public static int maxProduct(int[] nums)
    {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            int current = nums[i];

            if (current < 0)
            {
                // Swap max and min when multiplied by a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(current, maxProduct * current);
            minProduct = Math.min(current, minProduct * current);

            result = Math.max(result, maxProduct);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {-2, 0, -1};      // Expected: 0
        int[] nums2 = {1};              // Expected: 1
        int[] nums3 = {2, 3, -2, 4};    // Expected: 6
        int[] nums4 = {5, 4, -1, 7, 8}; // Expected: 56

        System.out.println(maxProduct(nums1));
        System.out.println(maxProduct(nums2));
        System.out.println(maxProduct(nums3));
        System.out.println(maxProduct(nums4));
    }
}

/*
Array:
nums = {2, 3, -2, 4}

Initial values

maxProduct = 2
minProduct = 2
result = 2


--------------------------------
Step 1 (i = 1, current = 3)

current < 0 ?
No

maxProduct = max(3 , 2 * 3)
           = max(3 , 6)
           = 6

minProduct = min(3 , 2 * 3)
           = min(3 , 6)
           = 3

result = max(2 , 6)
       = 6


--------------------------------
Step 2 (i = 2, current = -2)

current < 0 ?
Yes → swap(maxProduct , minProduct)

Before swap
maxProduct = 6
minProduct = 3

After swap
maxProduct = 3
minProduct = 6


maxProduct = max(-2 , 3 * -2)
           = max(-2 , -6)
           = -2

minProduct = min(-2 , 6 * -2)
           = min(-2 , -12)
           = -12

result = max(6 , -2)
       = 6


--------------------------------
Step 3 (i = 3, current = 4)

current < 0 ?
No

maxProduct = max(4 , -2 * 4)
           = max(4 , -8)
           = 4

minProduct = min(4 , -12 * 4)
           = min(4 , -48)
           = -48

result = max(6 , 4)
       = 6


--------------------------------
Final Result

Maximum Product Subarray = 6

Subarray = {2, 3}
*/