package _9SearchingSorting;

/*
 PROBLEM: 18. 4Sum

 CONCEPT: SORTING + TWO POINTERS

 GIVEN:
 - Integer array nums[]
 - Integer target

 TASK:
 Find all UNIQUE quadruplets (a, b, c, d) such that:
 nums[a] + nums[b] + nums[c] + nums[d] == target

 APPROACH:
 1. Sort the array
 2. Fix first index i (0 to n-4)
 3. Fix second index j (i+1 to n-3)
 4. Use two pointers:
    - left = j + 1
    - right = n - 1
 5. Calculate sum:
    - If sum == target → add quadruplet
    - If sum < target → left++
    - If sum > target → right--
 6. Skip duplicates at every step

 WHY SORTING:
 - Makes duplicate handling easy
 - Enables two-pointer technique

 TIME COMPLEXITY:
 O(n^3)

 SPACE COMPLEXITY:
 O(1) extra space (excluding result)
*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class _12FourSum
{
    public static List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;

        if (n < 4)
        {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++)
            {
                if (j > i + 1 && nums[j] == nums[j - 1])
                {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right)
                {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target)
                    {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);

                        result.add(quad);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1])
                        {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1])
                        {
                            right--;
                        }
                    }
                    else if (sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        System.out.println(fourSum(nums1, target1));

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;

        System.out.println(fourSum(nums2, target2));
    }
}

/*
 DRY RUN:

 Example 1:
 nums = {1, 0, -1, 0, -2, 2}, target = 0

 After Sorting:
 {-2, -1, 0, 0, 1, 2}

 i = 0 (-2)
  j = 1 (-1)
   left=2 (0), right=5 (2)
   sum = -2 + -1 + 0 + 2 = -1 < 0 → left++
   left=3 (0), right=5 (2)
   sum = -1 < 0 → left++
   left=4 (1), right=5 (2)
   sum = 0 → add {-2, -1, 1, 2}

  j = 2 (0)
   left=3 (0), right=5 (2)
   sum = 0 → add {-2, 0, 0, 2}

 i = 1 (-1)
  j = 2 (0)
   left=3 (0), right=4 (1)
   sum = 0 → add {-1, 0, 0, 1}

 OUTPUT:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]


 Example 2:
 nums = {2,2,2,2,2}, target = 8

 Only one unique quadruplet:
 [2,2,2,2]

 OUTPUT:
 [[2,2,2,2]]
*/
