package _01ARRAY_1D._17Sum;

public class TwoSum
{

    public static void main(String[] args)
    {

        int[] nums = {2, 1, 7, 11, 8, 15};  // Input array
        int target = 9;                    // Target sum

        boolean found = false;            // Flag to track if any pair is found

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    // Print only the elements
                    System.out.println("Elements: " + nums[i] + " and " + nums[j]);
                    found = true;
                }
            }
        }

        if (!found)
        {
            System.out.println("No valid pair found.");
        }

    }

}
