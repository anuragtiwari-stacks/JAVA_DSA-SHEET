package _11SegmentTree;

public class _1NumArray
{

    private int[] prefix;

    public _1NumArray(int[] nums)
    {
        prefix = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
        {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right)
    {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 5};

        _1NumArray obj = new _1NumArray(nums);

        System.out.println(obj.sumRange(0, 2)); // 9
        System.out.println(obj.sumRange(1, 2)); // 8
    }
}
