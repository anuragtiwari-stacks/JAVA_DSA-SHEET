package _03STRING;

import java.util.Stack;

public class _9ValidParentheses_Stack
{
    // Method to check if the input string has valid parentheses
    public static boolean isValid(String s)
    {
        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }
            // If it's a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']')
            {
                // If stack is empty, it's invalid
                if (stack.isEmpty())
                {
                    return false;
                }

                // Pop the top element and check if it matches
                char top = stack.pop();

                if (ch == ')' && top != '(' ||
                        ch == '}' && top != '{' ||
                        ch == ']' && top != '[')
                {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets matched
        return true;
    }

    public static void main(String[] args)
    {
        // Example test input
        String input = "({[]})";

        // Check if the input is valid
        boolean result = isValid(input);

        // Print the result
        System.out.println("Is the parentheses string valid? " + result);
    }

}

