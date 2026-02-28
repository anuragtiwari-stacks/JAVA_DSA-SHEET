package _01ARRAY_1D._9Repeat_and_Missing;

public class _9MissingNumber
{
    public static int findMissing(int[] nums)
    {
        int n = nums.length + 1;  // Since one number is missing, array length is n-1

        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int num : nums)
        {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args)
    {
        int[] nums = { 1, 2, 4, 5, 6 };  // Missing number is 3

        int missing = findMissing(nums);

        System.out.println("Missing number: " + missing);
    }
}
