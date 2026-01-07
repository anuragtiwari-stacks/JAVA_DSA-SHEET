package _1ARRAY_1D._10KthElement;

import java.util.*;

public class KthLargestOptimized
{
    public static int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : nums)
        {
            pq.offer(x);

            if (pq.size() > k)
            {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = findKthLargest(nums, k);

        System.out.println("k-th Largest Element: " + result);
    }
}

