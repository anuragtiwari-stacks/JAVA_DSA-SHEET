package _03STRING;

public class _24SmallestWindowContainingAllCharacters
{
    // Function to check if current window contains all characters of pattern
    static boolean check(int[] c1, int[] c2)
    {
        for (int i = 0; i < 26; i++)
        {
            if (c1[i] < c2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static String findSmallestWindow(String S, String P)
    {
        int n = S.length();
        int m = P.length();

        // Frequency array for pattern P
        int[] c2 = new int[26];

        for (int i = 0; i < m; i++)
        {
            c2[P.charAt(i) - 'a']++;
        }

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        // Try every starting index
        for (int i = 0; i < n; i++)
        {
            int[] c1 = new int[26]; // frequency of current window

            for (int j = i; j < n; j++)
            {
                c1[S.charAt(j) - 'a']++;

                // If window contains all characters of P
                if (check(c1, c2))
                {
                    int windowLen = j - i + 1;

                    if (windowLen < minLen)
                    {
                        minLen = windowLen;
                        ans = S.substring(i, j + 1);
                    }

                    break; // smallest window from this i found
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        String S1 = "timetopractice";
        String P1 = "toc";

        String S2 = "zoomlazapzo";
        String P2 = "oza";

        String S3 = "zoom";
        String P3 = "zooe";

        System.out.println(findSmallestWindow(S1, P1)); // toprac
        System.out.println(findSmallestWindow(S2, P2)); // omla
        System.out.println(findSmallestWindow(S3, P3)); // ""
    }
}

/*
-------------------- DRY RUN --------------------

Input:
S = "timetopractice"
P = "toc"

Step 1:
Pattern frequency:
t → 1
o → 1
c → 1

Step 2:
Start checking substrings

i = 0 → "timetoprac"
Contains t, o, c → valid
minLen = 10
ans = "timetoprac"

i = 4 → "toprac"
Contains t, o, c → valid
minLen = 6
ans = "toprac"

No smaller valid window found

Final Answer:
"toprac"

-----------------------------------------------
*/
