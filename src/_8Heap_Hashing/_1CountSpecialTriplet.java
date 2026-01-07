// 3583. Count Special Triplets
package _8Heap_Hashing;
import java.util.*;

public class _1CountSpecialTriplet
{
    public static int specialTriplets(int[] nums)
    {
        int MOD = 1000000007;

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        for (int x : nums)
        {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        long count = 0;

        for (int x : nums)
        {
            right.put(x, right.get(x) - 1);

            int need = x * 2;

            int leftCount = left.getOrDefault(need, 0);
            int rightCount = right.getOrDefault(need, 0);

            count = (count + (long) leftCount * rightCount) % MOD;

            left.put(x, left.getOrDefault(x, 0) + 1);
        }

        return (int) count;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {4, 2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {8, 4, 8, 2, 8};

        System.out.println(specialTriplets(nums1));
        System.out.println(specialTriplets(nums2));
        System.out.println(specialTriplets(nums3));
    }
}
