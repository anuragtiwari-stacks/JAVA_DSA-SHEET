package _3STRING;

public class _27PatternSearch
{

    // Function to search for all occurrences of pattern[] in text[]
    public static void search(char[] text, char[] pattern)
    {
        int n = text.length;     // Length of text
        int m = pattern.length;  // Length of pattern

        // Loop through each possible starting index in text
        for (int i = 0; i <= n - m; i++)
        {
            int j;

            // Check character-by-character
            for (j = 0; j < m; j++)
            {
                if (text[i + j] != pattern[j])
                {
                    break;  // Mismatch found, break inner loop
                }
            }

            // If full pattern matched
            if (j == m)
            {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    // Main method to run test cases
    public static void main(String[] args)
    {
        char[] T1 = "THIS IS A TEST TEXT".toCharArray();
        char[] P1 = "TEST".toCharArray();

        char[] T2 = "AABAACAADAABAABA".toCharArray();
        char[] P2 = "AABA".toCharArray();

        System.out.println("Test Case 1:");
        search(T1, P1);

        System.out.println("\nTest Case 2:");
        search(T2, P2);
    }
}

/*
Step-by-step Dry Run:
Let’s break it down for the first few iterations of the loop:

i = 0
Compare:
T[0] = A and P[0] = A ✅
T[1] = A and P[1] = A ✅
T[2] = B and P[2] = B ✅
T[3] = A and P[3] = A ✅
➡️ Match found! ✅
Output: Pattern found at index 0

i = 1
Compare:
T[1] = A and P[0] = A ✅
T[2] = B and P[1] = A ❌
➡️ No match

i = 2
Compare:
T[2] = B and P[0] = A ❌
➡️ No match

i = 3
Compare:
T[3] = A and P[0] = A ✅
T[4] = A and P[1] = A ✅
T[5] = C and P[2] = B ❌
➡️ No match

i = 9
Compare:
T[9] = A and P[0] = A ✅
T[10] = A and P[1] = A ✅
T[11] = B and P[2] = B ✅
T[12] = A and P[3] = A ✅
➡️ Match found! ✅
Output: Pattern found at index 9

i = 12
Compare:
T[12] = A and P[0] = A ✅
T[13] = A and P[1] = A ✅
T[14] = B and P[2] = B ✅
T[15] = A and P[3] = A ✅
➡️ Match found! ✅
Output: Pattern found at index 12
*/