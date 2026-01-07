package _5StackQueue;

import java.util.Stack;

public class _5NextGreaterElementII
{
    /*
    LOGIC:
    ------
    Problem:
    Given a circular array nums, find the Next Greater Element
    for each element.

    Next Greater Element:
    First greater element on the right side.
    If not found, because array is circular, continue from start.
    If still not found → -1.

    Approach (Monotonic Stack):
    1. Use stack to store indices.
    2. Traverse array twice (0 to 2*n - 1) to simulate circular behavior.
    3. Use modulo (i % n) to access elements.
    4. While stack not empty AND
       nums[current] > nums[stack.peek()]
       → pop index and set its answer.
    5. Push index only in first traversal (i < n).
    */

    public static int[] nextGreaterElements(int[] nums)
    {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            result[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++)
        {
            int index = i % n;

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()])
            {
                int prevIndex = stack.pop();
                result[prevIndex] = nums[index];
            }

            if (i < n) // isse second pass me element stack me push nhi hoge
            {
                stack.push(index);
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 1};

        int[] ans = nextGreaterElements(nums);

        for (int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}

/*
DRY RUN:
--------

Input:
nums = [1, 2, 1]
n = 3

Initialize:
result = [-1, -1, -1]
stack = []

--------------------------------
i = 0  (index = 0)
nums[0] = 1
stack empty → push 0
stack = [0]

--------------------------------
i = 1  (index = 1)
nums[1] = 2
2 > nums[0] = 1 → pop 0
result[0] = 2
stack empty → push 1
stack = [1]

--------------------------------
i = 2  (index = 2)
nums[2] = 1
1 > nums[1]? NO
push 2
stack = [1, 2]

--------------------------------
i = 3  (index = 0)
nums[0] = 1
1 > nums[2]? NO

--------------------------------
i = 4  (index = 1)
nums[1] = 2
2 > nums[2] = 1 → pop 2
result[2] = 2
2 > nums[1]? NO

--------------------------------
i = 5  (index = 2)
nums[2] = 1
1 > nums[1]? NO

Loop ends

Final Result:
--------------
result = [2, -1, 2]

Output:
2 -1 2
*/
