package _5StackQueue;

import java.util.Stack;

public class _3MinimumRemoveToMakeValidParentheses
{
    /*
    LOGIC:
    ------
    1. Stack me parentheses ke indices store karenge.
    2. '(' aaye → index push karo.
    3. ')' aaye →
       - agar stack empty hai → iska index push (invalid ')')
       - warna → pop (valid pair mil gaya)
    4. Loop ke baad stack me sirf invalid parentheses ke indices bachenge.
    5. Un indices ko string se remove kar denge.
    6. Bachi hui string valid parentheses hogi.
    */

    public static String minRemoveToMakeValid(String s)
    {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '(')
            {
                stack.push(i);
            }
            else if (arr[i] == ')')
            {
                if (!stack.isEmpty() && arr[stack.peek()] == '(')
                {
                    stack.pop();
                }
                else
                {
                    stack.push(i);
                }
            }
        }

        // remove invalid indices
        while (!stack.isEmpty())
        {
            int idx = stack.pop();
            arr[idx] = '*';
        }

        StringBuilder result = new StringBuilder();

        for (char c : arr)
        {
            if (c != '*')
            {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s));
    }
}

/*
DRY RUN:
--------

Input: "a)b(c)d"

Index : 0 1 2 3 4 5 6
Char  : a ) b ( c ) d

Initial:
stack = []

i = 0, 'a'
ignore

i = 1, ')'
stack empty → push index 1
stack = [1]

i = 2, 'b'
ignore

i = 3, '('
push index 3
stack = [1, 3]

i = 4, 'c'
ignore

i = 5, ')'
top is '(' at index 3 → pop
stack = [1]

i = 6, 'd'
ignore

Loop ends

Stack now contains invalid indices:
stack = [1]

Mark index 1 with '*'

Array becomes:
a * b ( c ) d

Remove '*'

Final String:
"ab(c)d"
*/
