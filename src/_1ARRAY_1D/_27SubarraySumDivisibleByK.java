package _1ARRAY_1D;

public class _27SubarraySumDivisibleByK
{
    public static int subarraysDivByK(int[] nums, int k)
    {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++)
        {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int[] freq = new int[k];
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            int rem = prefix[i] % k;

            if (rem < 0)
            {
                rem += k;
            }

            if (rem == 0)
            {
                count++;
            }

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraysDivByK(nums, k));
    }
}

/*
======================== DRY RUN ========================

nums   = [4, 5, 0, -2, -3, 1]
k = 5

Prefix Sum Array:
prefix[0] = 4
prefix[1] = 4 + 5  = 9
prefix[2] = 9 + 0  = 9
prefix[3] = 9 - 2  = 7
prefix[4] = 7 - 3  = 4
prefix[5] = 4 + 1  = 5

prefix = [4, 9, 9, 7, 4, 5]

Initial:
freq = [0, 0, 0, 0, 0]
count = 0

---------------------------------------------------------
i = 0
prefix[0] = 4
rem = 4 % 5 = 4
count += freq[4] → 0 + 0 = 0
freq[4]++
freq = [0, 0, 0, 0, 1]

---------------------------------------------------------
i = 1
prefix[1] = 9
rem = 9 % 5 = 4
count += freq[4] → 0 + 1 = 1
freq[4]++
freq = [0, 0, 0, 0, 2]

Subarray found: [5]

---------------------------------------------------------
i = 2
prefix[2] = 9
rem = 9 % 5 = 4
count += freq[4] → 1 + 2 = 3
freq[4]++
freq = [0, 0, 0, 0, 3]

Subarrays found:
[5, 0]
[0]

---------------------------------------------------------
i = 3
prefix[3] = 7
rem = 7 % 5 = 2
count += freq[2] → 3 + 0 = 3
freq[2]++
freq = [0, 0, 1, 0, 3]

---------------------------------------------------------
i = 4
prefix[4] = 4
rem = 4 % 5 = 4
count += freq[4] → 3 + 3 = 6
freq[4]++
freq = [0, 0, 1, 0, 4]

Subarrays found:
[5, 0, -2, -3]
[0, -2, -3]
[-2, -3]

---------------------------------------------------------
i = 5
prefix[5] = 5
rem = 5 % 5 = 0
rem == 0 → count++ → 7
count += freq[0] → 7 + 0 = 7
freq[0]++
freq = [1, 0, 1, 0, 4]

Subarray found:
[4, 5, 0, -2, -3, 1]

---------------------------------------------------------

FINAL ANSWER:
count = 7

=========================================================
*/
