package _9SearchingSorting;

/*
 PROBLEM: 35. Search Insert Position

 CONCEPT: BINARY SEARCH

 GIVEN:
 - A sorted array of DISTINCT integers
 - A target value

 TASK:
 - If target exists → return its index
 - If not → return the index where it should be inserted
   to maintain sorted order

 OBSERVATION:
 Since the array is sorted and we need O(log n),
 Binary Search is the best approach.

 APPROACH:
 1. Use binary search on nums[]
 2. If nums[mid] == target → return mid
 3. If nums[mid] < target → search right half
 4. If nums[mid] > target → search left half
 5. If target not found, low pointer gives insert position

 TIME COMPLEXITY:
 O(log n)

 SPACE COMPLEXITY:
 O(1)
*/

public class _6SearchInsertPosition
{
    public static int searchInsert(int[] nums, int target)
    {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        // low is the correct insert position
        return low;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsert(nums, 5)); // 2
        System.out.println(searchInsert(nums, 2)); // 1
        System.out.println(searchInsert(nums, 7)); // 4
    }
}

/*
 DRY RUN:

 Example 1:
 nums = {1, 3, 5, 6}, target = 5

 low = 0, high = 3
 mid = 1 → nums[1] = 3 < 5 → low = 2
 mid = 2 → nums[2] = 5 == target → return 2

 OUTPUT: 2


 Example 2:
 nums = {1, 3, 5, 6}, target = 2

 low = 0, high = 3
 mid = 1 → nums[1] = 3 > 2 → high = 0
 mid = 0 → nums[0] = 1 < 2 → low = 1

 loop ends → return low = 1

 OUTPUT: 1


 Example 3:
 nums = {1, 3, 5, 6}, target = 7

 low = 0, high = 3
 mid = 1 → nums[1] = 3 < 7 → low = 2
 mid = 2 → nums[2] = 5 < 7 → low = 3
 mid = 3 → nums[3] = 6 < 7 → low = 4

 loop ends → return low = 4

 OUTPUT: 4
*/
