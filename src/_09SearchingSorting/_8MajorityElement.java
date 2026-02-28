package _09SearchingSorting;

/*
 PROBLEM: 169. Majority Element

 CONCEPT: FREQUENCY COUNT USING HASHMAP (WITHOUT getOrDefault)

 IDEA:
 - Majority element ka count > n/2 hota hai
 - Pehle threshold = n/2 nikal lo
 - HashMap me har element ka frequency store karo
 - Agar kisi element ka count threshold se zyada ho jaye,
   turant usko return kar do

 TIME COMPLEXITY:
 O(n)

 SPACE COMPLEXITY:
 O(n)
*/

import java.util.HashMap;

public class _8MajorityElement
{
    public static int majorityElement(int[] nums)
    {
        int n = nums.length;
        int threshold = n / 2;

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            if (freq.containsKey(nums[i]))
            {
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
            else
            {
                freq.put(nums[i], 1);
            }

            if (freq.get(nums[i]) > threshold)
            {
                return nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {3, 2, 3};
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(nums1)); // 3
        System.out.println(majorityElement(nums2)); // 2
    }
}

/*
 DRY RUN:

 nums = {2, 2, 1, 1, 1, 2, 2}

 n = 7
 threshold = 3

 i=0 → 2 not in map → freq(2)=1
 i=1 → 2 exists → freq(2)=2
 i=2 → 1 not in map → freq(1)=1
 i=3 → 1 exists → freq(1)=2
 i=4 → 1 exists → freq(1)=3
 i=5 → 2 exists → freq(2)=3
 i=6 → 2 exists → freq(2)=4 → 4 > 3 → RETURN 2

 OUTPUT:
 2
*/
