package _05StackQueue;

import java.util.Stack;

public class _3MinimumRemoveToMakeValidParentheses
{
    public static String minRemoveToMakeValid(String s)
    {
        Stack<Integer> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++)
        {
            char ch = arr[i];

            if (ch == '(')
            {
                stack.push(i);
            }
            else if (ch == ')')
            {
                // matching '(' exists
                if (!stack.isEmpty() && arr[stack.peek()] == '(')
                {
                    stack.pop();
                }
                else
                {
                    // invalid ')'
                    stack.push(i);
                }
            }
        }

        // remove all invalid indices
        while (!stack.isEmpty())
        {
            arr[stack.pop()] = '*';
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : arr)
        {
            if (ch != '*')
            {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String s = "a)b(c)d";

        System.out.println(minRemoveToMakeValid(s));
    }
}