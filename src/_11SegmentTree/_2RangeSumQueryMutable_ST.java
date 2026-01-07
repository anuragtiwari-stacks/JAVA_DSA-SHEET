package _11SegmentTree;

public class _2RangeSumQueryMutable_ST
{

    private int[] tree;
    private int n;

    public _2RangeSumQueryMutable_ST(int[] nums)
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

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public void update(int index, int val)
    {
        update(0, 0, n - 1, index, val);
    }

    private void update(int node, int start, int end, int index, int val)
    {
        if (start == end)
        {
            tree[node] = val;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid)
        {
            update(2 * node + 1, start, mid, index, val);
        }
        else
        {
            update(2 * node + 2, mid + 1, end, index, val);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int sumRange(int left, int right)
    {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int l, int r)
    {
        if (r < start || end < l)
        {
            return 0;
        }

        if (l <= start && end <= r)
        {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return query(2 * node + 1, start, mid, l, r)
                + query(2 * node + 2, mid + 1, end, l, r);
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5};

        _2RangeSumQueryMutable_ST obj =
                new _2RangeSumQueryMutable_ST(nums);

        System.out.println(obj.sumRange(0, 2)); // 9
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2)); // 8
    }
}
