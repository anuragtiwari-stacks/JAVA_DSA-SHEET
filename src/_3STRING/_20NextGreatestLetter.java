/*
LeetCode 744 – Find Smallest Letter Greater Than Target

You are given an array of characters letters that is sorted in non-decreasing order,
and a character target. There are at least two different characters in letters.

Task:
Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.

Example:
Input:  letters = ['c','f','j'], target = 'a'
Output: 'c'
Explanation:
The smallest character that is lexicographically greater than 'a' is 'c'.

Another Example:
Input:  letters = ['c','f','j'], target = 'j'
Output: 'c'
Explanation:
No character is greater than 'j', so return the first character (wrap-around case).

Approach Used:
Brute Force
- Compare target with each character starting from index 0
- Return the first character greater than target
- If none found, return letters[0]

Time Complexity: O(n)
Space Complexity: O(1)
*/

package _3STRING;

public class _20NextGreatestLetter
{
    public static char nextGreatestLetter(char[] letters, char target)
    {
        for (int i = 0; i < letters.length; i++)
        {
            if (letters[i] > target)
            {
                return letters[i];
            }
        }
        return letters[0];
    }

    // optional: testing main method
    public static void main(String[] args)
    {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';

        System.out.println(nextGreatestLetter(letters, target));
    }
}
