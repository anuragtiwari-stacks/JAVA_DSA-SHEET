package _11SegmentTree;

import java.util.*;

public class _5CountOfSmallerNumbersAfterSelf_ST
{

    static class SegmentTree
    {
        int[] tree;
        int n;

        SegmentTree(int n)
        {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int index, int node, int start, int end)
        {
            if (start == end)
            {
                tree[node]++;
                return;
            }

            int mid = (start + end) / 2;

            if (index <= mid)
            {
                update(index, node * 2, start, mid);
            }
            else
            {
                update(index, node * 2 + 1, mid + 1, end);
            }

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        int query(int left, int right, int node, int start, int end)
        {
            if (right < start || end < left)
            {
                return 0;
            }

            if (left <= start && end <= right)
            {
                return tree[node];
            }

            int mid = (start + end) / 2;

            return query(left, right, node * 2, start, mid)
                    + query(left, right, node * 2 + 1, mid + 1, end);
        }
    }

    public static List<Integer> countSmaller(int[] nums)
    {
        int n = nums.length;
        Integer[] answer = new Integer[n];

        // Coordinate compression
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;

        for (int num : sorted)
        {
            if (!map.containsKey(num))
            {
                map.put(num, idx++);
            }
        }

        SegmentTree tree = new SegmentTree(map.size());

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--)
        {
            int pos = map.get(nums[i]);

            if (pos == 0)
            {
                answer[i] = 0;
            }
            else
            {
                answer[i] = tree.query(0, pos - 1, 1, 0, tree.n - 1);
            }

            tree.update(pos, 1, 0, tree.n - 1);
        }

        return Arrays.asList(answer);
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
}
