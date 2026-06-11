package _03STRING;

// Leetcode - 76
import java.util.HashMap;

public class _24SmallestWindowContainingAllCharacters
{
    public static String findSmallestWindow(String S, String P)
    {
        HashMap<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < P.length(); i++)
        {
            char ch = P.charAt(i);

            if(need.containsKey(ch))
            {
                need.put(ch, need.get(ch) + 1);
            }
            else
            {
                need.put(ch, 1);
            }
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < S.length(); right++)
        {
            char ch = S.charAt(right);

            if(need.containsKey(ch))
            {
                if(window.containsKey(ch))
                {
                    window.put(ch, window.get(ch) + 1);
                }
                else
                {
                    window.put(ch, 1);
                }
            }

            while(isValid(need, window))
            {
                int currentLength = right - left + 1;

                if(currentLength < minLength)
                {
                    minLength = currentLength;
                    startIndex = left;
                }

                char leftChar = S.charAt(left);

                if(window.containsKey(leftChar))
                {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE)
        {
            return "-1";
        }

        return S.substring(startIndex, startIndex + minLength);
    }

    public static boolean isValid(HashMap<Character, Integer> need,
                                  HashMap<Character, Integer> window)
    {
        for(char ch : need.keySet())
        {
            if(!window.containsKey(ch))
            {
                return false;
            }

            if(window.get(ch) < need.get(ch))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String S = "ADOBECODEBANC";
        String P = "ABC";

        System.out.println(findSmallestWindow(S, P));
    }
}