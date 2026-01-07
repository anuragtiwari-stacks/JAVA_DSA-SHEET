package _9SearchingSorting;

/*
 PROBLEM: 775. Global and Local Inversions

 CONCEPT: BRUTE FORCE COUNTING

 DEFINITIONS:
 - Local Inversion:
   nums[i] > nums[i + 1]

 - Global Inversion:
   nums[i] > nums[j] where i < j

 IDEA:
 1. Count all LOCAL inversions using single loop
 2. Count all GLOBAL inversions using two nested loops
 3. If both counts are equal → return true
    else → return false

 NOTE:
 This approach is slow but very clear conceptually.

 TIME COMPLEXITY:
 O(n^2)

 SPACE COMPLEXITY:
 O(1)
*/

public class _9GlobalAndLocalInversions
{
    public static boolean isIdealPermutation(int[] nums)
    {
        int n = nums.length;

        int local = 0;
        int global = 0;

        // Count local inversions
        for (int i = 0; i < n - 1; i++)
        {
            if (nums[i] > nums[i + 1])
            {
                local++;
            }
        }

        // Count global inversions
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (nums[i] > nums[j])
                {
                    global++;
                }
            }
        }

        return local == global;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 0, 2};
        int[] nums2 = {1, 2, 0};

        System.out.println(isIdealPermutation(nums1)); // true
        System.out.println(isIdealPermutation(nums2)); // false
    }
}

/*
 DRY RUN:

 Example 1:
 nums = {1, 0, 2}

 Local inversions:
 i=0 → 1 > 0 → local = 1
 i=1 → 0 < 2 → no

 Global inversions:
 (1,0) → global = 1

 local == global → TRUE


 Example 2:
 nums = {1, 2, 0}

 Local inversions:
 i=0 → 1 < 2 → no
 i=1 → 2 > 0 → local = 1

 Global inversions:
 (1,0)
 (2,0)
 global = 2

 local != global → FALSE
*/
