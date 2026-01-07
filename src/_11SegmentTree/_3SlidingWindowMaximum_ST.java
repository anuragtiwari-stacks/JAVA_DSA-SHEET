package _11SegmentTree;

import java.util.*;

public class _3SlidingWindowMaximum_ST
{

    private int[] tree;
    private int n;

    public _3SlidingWindowMaximum_ST(int[] nums)
    {
        n = nums.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, nums);
    }

    private void build(int node, int start, int end, int[] nums)
    {
        if (start == end)
        {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, nums);
        build(2 * node + 2, mid + 1, end, nums);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private int queryMax(int node, int start, int end, int l, int r)
    {
        if (r < start || end < l)
        {
            return Integer.MIN_VALUE;
        }

        if (l <= start && end <= r)
        {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(
                queryMax(2 * node + 1, start, mid, l, r),
                queryMax(2 * node + 2, mid + 1, end, l, r)
        );
    }

    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int[] result = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i + k - 1 < n; i++)
        {
            result[idx++] = queryMax(0, 0, n - 1, i, i + k - 1);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        _3SlidingWindowMaximum_ST obj =
                new _3SlidingWindowMaximum_ST(nums);

        int[] ans = obj.maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(ans));
    }
}// Based on QueryMax technique see PW_JAVA
