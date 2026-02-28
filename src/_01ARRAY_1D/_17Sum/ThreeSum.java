package _01ARRAY_1D._17Sum;

public class ThreeSum
{

    public static void main(String[] args)
    {

        int[] nums = {2, 1, 6, 4, 3, 5};  // Input array
        int target = 9;                  // Target sum

        boolean found = false;          // Flag to check if any triplet found

        for (int i = 0; i < nums.length - 2; i++)
        {
            for (int j = i + 1; j < nums.length - 1; j++)
            {
                for (int k = j + 1; k < nums.length; k++)
                {
                    if (nums[i] + nums[j] + nums[k] == target)
                    {
                        System.out.println("Triplet: " + nums[i] + ", " + nums[j] + ", " + nums[k]);
                        found = true;
                    }
                }
            }
        }

        if (!found)
        {
            System.out.println("No triplet found.");
        }

    }

}
