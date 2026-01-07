package _9SearchingSorting;

/*
 PROBLEM: 349. Intersection of Two Arrays

 CONCEPT: MAKE ARRAYS UNIQUE FIRST + TWO POINTERS

 IDEA:
 1. Dono arrays ko sort karo
 2. Sorting ke baad duplicates consecutive hote hain
 3. Duplicates skip karke UNIQUE arrays banao
 4. Ab dono unique arrays ka intersection nikalo using two pointers

 ADVANTAGE:
 - No Hashing
 - Logic clear aur readable
 - Duplicate handling easy

 TIME COMPLEXITY:
 O(n log n + m log m)

 SPACE COMPLEXITY:
 O(n + m) (unique arrays ke liye)
*/

import java.util.Arrays;
import java.util.ArrayList;

public class _4Intersection
{
    // Method to remove duplicates from sorted array
    public static int[] makeUnique(int[] arr)
    {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++)
        {
            if (i == 0 || arr[i] != arr[i - 1])
            {
                list.add(arr[i]);
            }
        }

        int[] unique = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            unique[i] = list.get(i);
        }

        return unique;
    }

    public static int[] intersection(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] unique1 = makeUnique(nums1);
        int[] unique2 = makeUnique(nums2);

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < unique1.length && j < unique2.length)
        {
            if (unique1[i] == unique2[j])
            {
                result.add(unique1[i]);
                i++;
                j++;
            }
            else if (unique1[i] < unique2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        int[] ans = new int[result.size()];

        for (int k = 0; k < result.size(); k++)
        {
            ans[k] = result.get(k);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ans = intersection(nums1, nums2);

        for (int i = 0; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
}

/*
 DRY RUN:

 nums1 = {1, 2, 2, 1}
 nums2 = {2, 2}

 Step 1: Sort
 nums1 = {1, 1, 2, 2}
 nums2 = {2, 2}

 Step 2: Make Unique
 unique1 = {1, 2}
 unique2 = {2}

 Step 3: Intersection
 i=0, j=0 → 1 < 2 → i++
 i=1, j=0 → 2 == 2 → add 2

 OUTPUT:
 {2}
*/
