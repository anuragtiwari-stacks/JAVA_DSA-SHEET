package _03STRING;

public class _28TransformString
{

    public static int transform(String A, String B)
    {
        int n = A.length();

        // Step 1: Check if transformation is possible by comparing frequencies
        if (n != B.length())
        {
            return -1;
        }

        // Frequency array for uppercase letters (assuming A-Z only)
        int[] count = new int[26];
        for (int i = 0; i < n; i++)
        {
            count[A.charAt(i) - 'A']++;
            count[B.charAt(i) - 'A']--;
        }

        for (int i = 0; i < 26; i++)
        {
            if (count[i] != 0)
            {
                return -1; // Not possible to transform
            }
        }

        // Step 2: Count minimum operations starting from the end
        int res = 0;
        int j = n - 1;

        for (int i = n - 1; i >= 0; i--)
        {
            if (A.charAt(i) == B.charAt(j))
            {
                j--;
            }
            else
            {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        // Example 1
        String A1 = "ABD";
        String B1 = "BAD";
        System.out.println("Input:  A = \"" + A1 + "\", B = \"" + B1 + "\"");
        System.out.println("Output: " + transform(A1, B1));
        System.out.println("Explanation: Pick 'B' from A and insert it at front to get B.\n");

        // Example 2
        String A2 = "EACBD";
        String B2 = "EABCD";
        System.out.println("Input:  A = \"" + A2 + "\", B = \"" + B2 + "\"");
        System.out.println("Output: " + transform(A2, B2));
        System.out.println("Explanation: Minimum 3 operations to transform A to B.\n");
    }

}
