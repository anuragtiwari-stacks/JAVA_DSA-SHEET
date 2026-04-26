package _03STRING;

import java.util.Stack;

public class _9ValidParentheses_Stack
{
    public static boolean isValid(String s)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[')
            {
                st.push(ch);
            }
            else
            {
                // Agar stack empty hai → invalid
                if (st.isEmpty())
                {
                    return false;
                }

                char top = st.pop();

                // Matching check
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '['))
                {
                    return false;
                }
            }
        }

        // Agar stack empty → valid
        return st.isEmpty();
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[()]}"));   // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
    }
}