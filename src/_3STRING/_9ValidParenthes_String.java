package _3STRING;

public class _9ValidParenthes_String
{
    public static boolean isValid(String s)
    {
        int prevLength = -1;

        // Keep looping until string length stops changing
        while (prevLength != s.length())
        {
            prevLength = s.length();

            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.length() == 0;
    }

    public static void main(String[] args)
    {
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[()]}"));   // true
    }
}

/*
------------- DRY RUN (SIMPLE) -------------

Input: "([)]"

Initial:
prevLength = -1
s.length() = 4

Loop 1:
prevLength = 4
No "()", "{}", "[]" found
s = "([)]"

Loop 2:
prevLength == s.length() (4 == 4)
Loop stops

String not empty → return false

-------------------------------------------
*/
