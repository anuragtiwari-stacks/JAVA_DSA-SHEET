package _11SegmentTree;

import java.util.*;

public class _4CreateSortedArray
{

    public int createSortedArray(int[] instructions)
    {
        List<Integer> nums = new ArrayList<>();
        long cost = 0;

        for (int x : instructions)
        {
            int less = 0;
            int greater = 0;

            for (int val : nums)
            {
                if (val < x)
                {
                    less++;
                }
                else if (val > x)
                {
                    greater++;
                }
            }

            cost = cost + Math.min(less, greater);

            nums.add(x);
            Collections.sort(nums);
        }

        return (int) cost;
    }

    public static void main(String[] args)
    {
        _4CreateSortedArray obj = new _4CreateSortedArray();

        int[] instructions = {1, 5, 6, 2};

        System.out.println(obj.createSortedArray(instructions)); // 1
    }
}

/*
instructions = [1, 5, 6, 2]

Insert 1 → less=0, greater=0 → cost=0 → nums=[1]
Insert 5 → less=1, greater=0 → cost=0 → nums=[1,5]
Insert 6 → less=2, greater=0 → cost=0 → nums=[1,5,6]
Insert 2 → less=1, greater=2 → cost=1 → nums=[1,2,5,6]

Total cost = 1
*/