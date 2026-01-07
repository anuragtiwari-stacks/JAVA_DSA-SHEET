package _5StackQueue;

import java.util.Stack;

public class _2LongestValidParentheses
{
    /*
    LOGIC:
    ------
    1. Stack me indices store karte hain (characters nahi).
    2. Stack ko -1 se initialize karte hain (base index).
    3. '(' aaye → uska index push karo.
    4. ')' aaye →
       a) pop karo
       b) agar stack empty ho jaaye → current index push (new base)
       c) warna → current index - stack.peek() = valid length
    5. Maximum length maintain karte raho.
    */

    public static int longestValidParentheses(String s)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == '(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
                int len = i - stack.peek();
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        String s = ")()())";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }
}

/*
DRY RUN:
--------

Input: ")()())"

Initial:
stack = [-1]
maxLen = 0


i = 0, ch = ')'
pop → -1 removed
stack empty → push 0
stack = [0]

i = 1, ch = '('
push 1
stack = [0, 1]

i = 2, ch = ')'
pop → remove 1
stack = [0]
len = 2 - 0 = 2
maxLen = 2

i = 3, ch = '('
push 3
stack = [0, 3]

i = 4, ch = ')'
pop → remove 3
stack = [0]
len = 4 - 0 = 4
maxLen = 4

i = 5, ch = ')'
pop → remove 0
stack = []

Loop ends

FINAL ANSWER:
-------------
Longest Valid Parentheses = 4
*/
