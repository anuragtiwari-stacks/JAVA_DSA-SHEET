package _11SegmentTree;

public class _6CountOfRangeSum_ST
{

    public static int countRangeSum(int[] nums, int lower, int upper)
    {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            int sum = 0;

            for (int j = i; j < n; j++)
            {
                sum = sum + nums[j];

                if (sum >= lower && sum <= upper)
                {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;

        System.out.println(countRangeSum(nums, lower, upper));
    }
}


    /*
    DRY RUN
    --------
    nums = [-2, 5, -1]
    lower = -2
    upper = 2

    count = 0

    i = 0
        sum = 0

        j = 0
            sum = 0 + (-2) = -2
            -2 >= -2 AND -2 <= 2  -> true
            count = 1

        j = 1
            sum = -2 + 5 = 3
            3 >= -2 AND 3 <= 2  -> false
            count = 1

        j = 2
            sum = 3 + (-1) = 2
            2 >= -2 AND 2 <= 2  -> true
            count = 2

    i = 1
        sum = 0

        j = 1
            sum = 0 + 5 = 5
            5 >= -2 AND 5 <= 2  -> false
            count = 2

        j = 2
            sum = 5 + (-1) = 4
            4 >= -2 AND 4 <= 2  -> false
            count = 2

    i = 2
        sum = 0

        j = 2
            sum = 0 + (-1) = -1
            -1 >= -2 AND -1 <= 2  -> true
            count = 3

    FINAL ANSWER = 3
    */