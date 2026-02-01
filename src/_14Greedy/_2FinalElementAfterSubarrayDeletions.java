package _14Greedy;

/*
LeetCode 3828
Final Element After Subarray Deletions
*/

public class _2FinalElementAfterSubarrayDeletions
{

    public int finalElement(int[] nums)
    {
        int n = nums.length;

        if (n == 1)
        {
            return nums[0];
        }

        return Math.max(nums[0], nums[n - 1]);
    }

    // For running in IntelliJ IDEA
    public static void main(String[] args)
    {
        _2FinalElementAfterSubarrayDeletions obj =
                new _2FinalElementAfterSubarrayDeletions();

        int[] nums1 = {1, 5, 2};
        System.out.println(obj.finalElement(nums1)); // expected 2

        int[] nums2 = {11, 4, 5};
        System.out.println(obj.finalElement(nums2)); // expected 11

        int[] nums3 = {3, 7};
        System.out.println(obj.finalElement(nums3)); // expected 7
    }
}

/*
Dry Run

Example 1:
nums = [1, 5, 2]
nums[0] = 1
nums[n-1] = 2
max(1, 2) = 2
Answer = 2

Example 2:
nums = [11, 4, 5]
nums[0] = 11
nums[n-1] = 5
max(11, 5) = 11
Answer = 11

Example 3:
nums = [3, 7]
nums[0] = 3
nums[n-1] = 7
max(3, 7) = 7
Answer = 7
*/
