package _05StackQueue;

import java.util.Stack;

public class _2LongestValidParentheses
{
    public static int longestValidParentheses(String s)
    {
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            // opening bracket
            if (ch == '(')
            {
                stack.push(i);
            }
            else
            {
                // match one '('
                stack.pop();

                // no base left
                if (stack.isEmpty())
                {
                    stack.push(i);
                }
                else
                {
                    int len = i - stack.peek();

                    maxLen = Math.max(maxLen, len);
                }
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

Input:
")()())"

------------------------------------------------

Initial:

stack = [-1]
maxLen = 0

------------------------------------------------

i = 0
ch = ')'

pop → remove -1

stack = []

stack empty
push current index 0

stack = [0]

------------------------------------------------

i = 1
ch = '('

push 1

stack = [0, 1]

------------------------------------------------

i = 2
ch = ')'

pop → remove 1

stack = [0]

len = 2 - 0 = 2

maxLen = 2

------------------------------------------------

i = 3
ch = '('

push 3

stack = [0, 3]

------------------------------------------------

i = 4
ch = ')'

pop → remove 3

stack = [0]

len = 4 - 0 = 4

maxLen = 4

------------------------------------------------

i = 5
ch = ')'

pop → remove 0

stack = []

stack empty
push current index 5

stack = [5]

------------------------------------------------

Loop Ends

Final Answer:

Longest Valid Parentheses = 4

*/

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
