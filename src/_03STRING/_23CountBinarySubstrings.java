package _03STRING;

/*
    LeetCode 696 - Count Binary Substrings

    Problem:
    Given a string s, count the number of non-empty substrings
    that have the same number of consecutive 0's and 1's.
*/

public class _23CountBinarySubstrings
{

    public static int countBinarySubstrings(String s)
    {
        int result = 0;

        int prevCount = 0;   // Previous group length
        int currCount = 1;   // Current group length (at least 1)

        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i - 1))
            {
                currCount++;
            }
            else
            {
                result = result + Math.min(prevCount, currCount);
                prevCount = currCount;
                currCount = 1;
            }
        }

        return result + Math.min(prevCount, currCount);
    }

    public static void main(String[] args)
    {
        String s = "00110011";

        System.out.println("Input:  " + s);
        System.out.println("Output: " + countBinarySubstrings(s));
    }
}


/*
=========================
        DRY RUN
=========================

Example: s = "00110011"

Step 1:
Groups formed:
"00"  -> length 2
"11"  -> length 2
"00"  -> length 2
"11"  -> length 2

So group lengths = [2, 2, 2, 2]

Now we calculate:
min(2,2) + min(2,2) + min(2,2)

= 2 + 2 + 2
= 6

Valid substrings:
"0011"
"01"
"1100"
"10"
"0011"
"01"

Final Answer = 6

Time Complexity  = O(n)
Space Complexity = O(1)
*/
