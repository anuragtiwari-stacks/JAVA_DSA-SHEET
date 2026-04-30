package _03STRING;

public class _16Optimized_LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];   // frequency of A-Z

        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // update max frequency
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // shrink window if invalid
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Output 1: " + characterReplacement(s1, k1)); // 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Output 2: " + characterReplacement(s2, k2)); // 4
    }
}