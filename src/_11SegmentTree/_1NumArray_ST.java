package _11SegmentTree;

public class _1NumArray_ST
{

    private int[] tree;
    private int n;

    public _1NumArray_ST(int[] nums)
    {
        n = nums.length;
        tree = new int[4 * n];
        build(nums, 1, 0, n - 1);
    }

    private void build(int[] nums, int node, int start, int end)
    {
        if (start == end)
        {
            tree[node] = nums[start];
            return;
        }

        int mid = (start + end) / 2;

        build(nums, node * 2, start, mid);
        build(nums, node * 2 + 1, mid + 1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int sumRange(int left, int right)
    {
        return query(1, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right)
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

        return query(node * 2, start, mid, left, right)
                + query(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5};

        _1NumArray_ST obj = new _1NumArray_ST(nums);

        System.out.println(obj.sumRange(0, 2)); // 9
        System.out.println(obj.sumRange(1, 2)); // 8
    }
}
