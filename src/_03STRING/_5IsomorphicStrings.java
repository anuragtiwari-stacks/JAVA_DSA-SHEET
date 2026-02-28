package _03STRING;

public class _5IsomorphicStrings
{
    public static boolean areIsomorphic(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for (int i = 0; i < s1.length(); i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            int idx1 = ch1 - 'a';   // character ka index (0–25)
            int idx2 = ch2 - 'a';

            if (f1[idx1] != f2[idx2])
            {
                return false;
            }

            f1[idx1] = i + 1;
            f2[idx2] = i + 1;
        }

        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(areIsomorphic("paper", "title"));
        System.out.println(areIsomorphic("foo", "bar"));
    }
}

/*
---------------- DRY RUN ----------------

Example 1:
s1 = "paper"
s2 = "title"

Initial:
f1 = all 0
f2 = all 0

i = 0
ch1 = 'p' → idx1 = 15
ch2 = 't' → idx2 = 19
f1[15] = 0, f2[19] = 0 → equal
update: f1[15] = 1, f2[19] = 1

i = 1
ch1 = 'a' → idx1 = 0
ch2 = 'i' → idx2 = 8
f1[0] = 0, f2[8] = 0 → equal
update: f1[0] = 2, f2[8] = 2

i = 2
ch1 = 'p' → idx1 = 15
ch2 = 't' → idx2 = 19
f1[15] = 1, f2[19] = 1 → equal
update: f1[15] = 3, f2[19] = 3

i = 3
ch1 = 'e' → idx1 = 4
ch2 = 'l' → idx2 = 11
f1[4] = 0, f2[11] = 0 → equal
update: f1[4] = 4, f2[11] = 4

i = 4
ch1 = 'r' → idx1 = 17
ch2 = 'e' → idx2 = 4
f1[17] = 0, f2[4] = 0 → equal
update: f1[17] = 5, f2[4] = 5

Result → return true

-----------------------------------------

Example 2:
s1 = "foo"
s2 = "bar"

i = 0
idx1 = 5, idx2 = 1
f1[5] = 0, f2[1] = 0 → equal
update: f1[5] = 1, f2[1] = 1

i = 1
idx1 = 14, idx2 = 0
f1[14] = 0, f2[0] = 0 → equal
update: f1[14] = 2, f2[0] = 2

i = 2
idx1 = 14, idx2 = 17
f1[14] = 2, f2[17] = 0 → NOT equal

Result → return false
-----------------------------------------
*/
