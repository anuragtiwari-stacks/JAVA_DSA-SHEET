package _1ARRAY_1D;

public class _31PlusOne
{
    public int[] plusOne(int[] digits)
    {
        long sum = 0;

        for (int i = 0; i < digits.length; i++)
        {
            sum = sum * 10 + digits[i];
        }

        sum = sum + 1;

        String s = String.valueOf(sum);
        int[] ans = new int[s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            ans[i] = s.charAt(i) - '0';
        }

        return ans;
    }
}

/*
Dry Run:

Input:
digits = [1, 2, 3]

Step 1: Convert array to number
sum = 0

i = 0
sum = 0 * 10 + 1 = 1

i = 1
sum = 1 * 10 + 2 = 12

i = 2
sum = 12 * 10 + 3 = 123

Step 2: Add 1
sum = 123 + 1 = 124

Step 3: Convert number to string
s = "124"

Step 4: Convert string to array
ans[0] = '1' - '0' = 1
ans[1] = '2' - '0' = 2
ans[2] = '4' - '0' = 4

Output:
[1, 2, 4]

------------------------------------
⚠ NOTE:
This approach works only if the number fits in `long`.
For very large digit arrays, overflow occurs.
*/
