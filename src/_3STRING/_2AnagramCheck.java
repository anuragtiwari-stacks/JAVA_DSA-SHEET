//🔤 What are Anagram Strings
//        Anagram strings are two or more strings that contain the same characters,
//        with the same frequency, but arranged in a different order.
package _3STRING;

import java.util.Arrays;

public class _2AnagramCheck
{
    // Function to check if two strings are anagrams
    static boolean areAnagrams(String str1, String str2)
    {
        // First, check if lengths are equal
        if (str1.length() != str2.length())
        {
            return false;
        }

        // Convert both strings to character arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args)
    {
        // Anagram case
        String s1 = "listen";
        String s2 = "silent";

        // Not anagram case
        String s3 = "hello";
        String s4 = "world";

        System.out.println("Is \"" + s1 + "\" and \"" + s2 + "\" anagram? " + areAnagrams(s1, s2)); // true
        System.out.println("Is \"" + s3 + "\" and \"" + s4 + "\" anagram? " + areAnagrams(s3, s4)); // false
    }
}
