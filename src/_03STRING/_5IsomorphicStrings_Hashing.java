package _03STRING;

import java.util.HashMap;
import java.util.HashSet;

public class _5IsomorphicStrings_Hashing
{
    public static boolean areIsomorphic(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> used = new HashSet<>();

        for (int i = 0; i < s1.length(); i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map.containsKey(c1))
            {
                if (!map.get(c1).equals(c2))
                {
                    return false;
                }
            }
            else
            {
                if (used.contains(c2))
                {
                    return false;
                }
                map.put(c1, c2);
                used.add(c2);
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        // True example: "paper" and "title" are isomorphic
        String s1 = "paper";
        String s2 = "title";
        System.out.println(s1 + " and " + s2 + " are isomorphic? " + areIsomorphic(s1, s2));

        // False example: "foo" and "bar" are not isomorphic
        String s3 = "foo";
        String s4 = "bar";
        System.out.println(s3 + " and " + s4 + " are isomorphic? " + areIsomorphic(s3, s4));
    }
}
