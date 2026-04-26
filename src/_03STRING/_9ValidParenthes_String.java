package _03STRING;

public class _9ValidParenthes_String
{
    public static boolean isValid(String s)
    {
        int start = 0;
        int end = s.length() - 1;

        while (start < end)
        {
            char left = s.charAt(start);
            char right = s.charAt(end);

            if ((left == '(' && right == ')') || (left == '{' && right == '}') ||
                    (left == '[' && right == ']'))
            {
                start++;
                end--;
            }
            else
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[()]}"));   // true
    }
}
