package _5StackQueue;

import java.util.Stack;

public class _9RemoveKDigits
{
    /*
    LOGIC:
    ------
    Goal:
    Number ko smallest banana hai by removing k digits.

    Key Idea (Monotonic Increasing Stack):
    -------------------------------------
    - Agar current digit chhota hai aur stack ka top bada hai,
      to top ko remove karna faydemand hai (number chhota banega).
    - Ye process tab tak chalta hai jab tak:
      k > 0 AND stack not empty AND stack.peek() > current digit

    Steps:
    ------
    1. Har digit ko left se right process karo.
    2. While possible ho, bade digits pop karo.
    3. Current digit push karo.
    4. Agar k abhi bhi > 0 ho, to end se digits remove karo.
    5. Leading zeros hatao.
    6. Agar string empty ho → return "0".
    */

    public static String removeKdigits(String num, int k)
    {
        Stack<Character> stack = new Stack<>();

        for (char ch : num.toCharArray())
        {
            while (!stack.isEmpty() && k > 0 && stack.peek() > ch)
            {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k > 0 && !stack.isEmpty())
        {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack)
        {
            if (sb.length() == 0 && c == '0')
            {
                continue;
            }
            sb.append(c);
        }

        if (sb.length() == 0)
        {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }
}

/*
DRY RUN:
--------

num = "1432219"
k = 3

stack = []

--------------------------------
ch = '1'
push
stack = [1]

--------------------------------
ch = '4'
push
stack = [1, 4]

--------------------------------
ch = '3'
4 > 3 → pop 4, k = 2
push 3
stack = [1, 3]

--------------------------------
ch = '2'
3 > 2 → pop 3, k = 1
push 2
stack = [1, 2]

--------------------------------
ch = '2'
2 > 2 ? NO
push 2
stack = [1, 2, 2]

--------------------------------
ch = '1'
2 > 1 → pop 2, k = 0
push 1
stack = [1, 2, 1]

--------------------------------
ch = '9'
k = 0 → no pop
push 9
stack = [1, 2, 1, 9]

--------------------------------
k = 0 → no more removals

Remove leading zeros → none

Final number:
"1219"
*/
