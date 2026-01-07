package _5StackQueue;

import java.util.Stack;

public class _7SumOfSubarrayMinimums_Opimized
{
    /*
    LOGIC:
    ------
    Har element arr[i] ka contribution nikaalte hain
    using LEFT aur RIGHT counts.

    left[i]  = number of subarrays ending at i
               jisme arr[i] minimum hai
    right[i] = number of subarrays starting at i
               jisme arr[i] minimum hai

    Contribution:
    arr[i] * left[i] * right[i]

    Steps:
    ------
    1. left[] calculate karo using monotonic stack
       (strictly greater elements pop karo)
    2. right[] calculate karo using monotonic stack
       (greater OR equal elements pop karo)
    3. Total sum nikaalo
    */

    public static int sumSubarrayMins(int[] arr)
    {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // -------- LEFT COUNT --------
        for (int i = 0; i < n; i++)
        {
            int count = 1;

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
            {
                count = count + left[stack.pop()];
            }

            left[i] = count;
            stack.push(i);
        }

        stack.clear();

        // -------- RIGHT COUNT --------
        for (int i = n - 1; i >= 0; i--)
        {
            int count = 1;

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                count = count + right[stack.pop()];
            }

            right[i] = count;
            stack.push(i);
        }

        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            sum = sum + arr[i] * left[i] * right[i];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }
}

/*
DRY RUN:
--------

arr = [3, 1, 2, 4]
index:  0  1  2  3

left = [1, 2, 1, 1]
right = [1, 3, 2, 1]

--------------------------------
Contribution Calculation:
--------------------------------

i = 0:
arr[0] * left[0] * right[0]
= 3 * 1 * 1
= 3

i = 1:
arr[1] * left[1] * right[1]
= 1 * 2 * 3
= 6

i = 2:
arr[2] * left[2] * right[2]
= 2 * 1 * 2
= 4

i = 3:
arr[3] * left[3] * right[3]
= 4 * 1 * 1
= 4

--------------------------------
Total Sum:
--------------------------------
3 + 6 + 4 + 4 = 17

FINAL ANSWER:
-------------
17
*/
