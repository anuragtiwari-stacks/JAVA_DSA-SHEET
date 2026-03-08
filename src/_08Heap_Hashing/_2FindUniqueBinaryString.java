package _08Heap_Hashing;

import java.util.*;

/*
LeetCode 1980
Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n,
return a binary string of length n that does not appear in nums. If there are multiple
answers, you may return any of them.

Example 1:
Input: nums = ["01","10"]
Output: "00"
Explanation: "00" does not appear in nums. "11" would also be correct.

Example 2:
Input: nums = ["00","01"]
Output: "10"

Example 3:
Input: nums = ["111","011","001"]
Output: "101"

Constraints:
n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] is either '0' or '1'
All the strings of nums are unique.
*/

public class _2FindUniqueBinaryString
{
    public static String findDifferentBinaryString(String[] nums)
    {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        // convert binary strings to integers
        for(String s : nums)
        {
            int val = Integer.parseInt(s, 2);
            set.add(val);
        }

        // find first missing number
        for(int i = 0; i < (1 << n); i++)
        {
            if(!set.contains(i))
            {
                String res = Integer.toBinaryString(i);

                // add leading zeros
                while(res.length() < n)
                {
                    res = "0" + res;
                }

                return res;
            }
        }

        return "";
    }

    public static void main(String[] args)
    {
        String[] nums = {"01","10"}; // sample input

        String ans = findDifferentBinaryString(nums);

        System.out.println("Unique Binary String: " + ans);
    }

}

/*
DRY RUN

Input:
nums = ["01","10"]

Step 1: Convert binary strings to integers
"01" -> 1
"10" -> 2

Set = {1,2}

n = 2
Possible numbers = 0 to 3

i = 0
0 not in set

Binary of 0 = "0"
Add leading zero -> "00"

Return "00"

Output:
Unique Binary String: 00
*/