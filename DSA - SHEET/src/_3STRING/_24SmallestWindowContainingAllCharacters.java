package _3STRING;
public class _24SmallestWindowContainingAllCharacters
{

    // Function to check if current window has all characters of pattern
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

        int[] c2 = new int[26];  // frequency of characters in pattern P

        // Fill frequency array for P
        for (int i = 0; i < m; i++)
        {
            c2[P.charAt(i) - 'a']++;
        }

        int minLen = Integer.MAX_VALUE;
        String ans = "";

        // Try every substring starting from index i
        for (int i = 0; i < n; i++)
        {
            int[] c1 = new int[26];  // frequency of characters in current window

            for (int j = i; j < n; j++)
            {
                c1[S.charAt(j) - 'a']++;

                // Check if current window is valid
                if (check(c1, c2))
                {
                    int windowLen = j - i + 1;

                    if (windowLen < minLen)
                    {
                        minLen = windowLen;
                        ans = S.substring(i, j + 1);
                    }

                    break; // Break because we want the smallest from this start
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

        System.out.println("Input: s1 = \"timetopractice\", s2 = \"toc\"");
        System.out.println("Output: " + findSmallestWindow(S1, P1));
        System.out.println();

        System.out.println("Input: s1 = \"zoomlazapzo\", s2 = \"oza\"");
        System.out.println("Output: " + findSmallestWindow(S2, P2));
        System.out.println();

        System.out.println("Input: s1 = \"zoom\", s2 = \"zooe\"");
        System.out.println("Output: " + findSmallestWindow(S3, P3));
    }
}

/*
Dry Run for:
S = "timetopractice"
P = "toc"

Step 1: Build frequency array for P
P = "toc"
c2['t' - 'a'] = 1 → c2[19] = 1
c2['o' - 'a'] = 1 → c2[14] = 1
c2['c' - 'a'] = 1 → c2[2] = 1

So c2 = frequency array with:
  c2[2] = 1 (c)
  c2[14] = 1 (o)
  c2[19] = 1 (t)

Step 2: Loop i from 0 to S.length()
Try to find smallest window starting from each i

i = 0:
  j = 0: 't' → c1[19]++
  j = 1: 'i' → c1[8]++
  j = 2: 'm' → c1[12]++
  j = 3: 'e' → c1[4]++
  j = 4: 't' → c1[19]++
  j = 5: 'o' → c1[14]++
  j = 6: 'p' → c1[15]++
  j = 7: 'r' → c1[17]++
  j = 8: 'a' → c1[0]++
  j = 9: 'c' → c1[2]++
  Now c1 contains all of c2 → valid window from i=0 to j=9 → "timetoprac"
  windowLen = 10 → minLen updated to 10, ans = "timetoprac"
  break

i = 1, 2, ..., loop continues and eventually a smaller window is found:
i = 8:
  j = 8: 'a'
  j = 9: 'c'
  j = 10: 't'
  j = 11: 'i'
  j = 12: 'c'
  j = 13: 'e'
→ check at j=10 (window = "act") contains 't', 'o', 'c'? ❌ No 'o'

i = 10:
  j = 10: 't'
  j = 11: 'i'
  j = 12: 'c'
  j = 13: 'e'
→ still no 'o'

Eventually at:
i = 4:
  j = 4: 't'
  j = 5: 'o'
  j = 9: 'c'
→ window = "toprac" → still contains all 't', 'o', 'c'
windowLen = 6 → minLen updated to 6, ans = "toprac"

Final answer: "toprac"
*/
