package _11SegmentTree;

public class _2RangeSumQueryMutable
{

    private int[] nums;

    public _2RangeSumQueryMutable(int[] nums)
    {
        this.nums = nums;
    }

    public void update(int index, int val)
    {
        nums[index] = val;
    }

    public int sumRange(int left, int right)
    {
        int sum = 0;

        for (int i = left; i <= right; i++)
        {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5};

        _2RangeSumQueryMutable obj = new _2RangeSumQueryMutable(nums);

        System.out.println(obj.sumRange(0, 2)); // 9
        obj.update(1, 2);
        System.out.println(obj.sumRange(0, 2)); // 8
    }
}
