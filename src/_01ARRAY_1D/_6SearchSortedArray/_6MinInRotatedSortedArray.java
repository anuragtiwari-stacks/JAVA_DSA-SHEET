package _01ARRAY_1D._6SearchSortedArray;

public class _6MinInRotatedSortedArray
{
    public static int findMin(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while (start < end)
        {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[end])
            {
                // Minimum is in right half
                start = mid + 1;
            }
            else
            {
                // Minimum is in left half including mid
                end = mid;
            }
        }

        return arr[start];
    }

    public static void main(String[] args)
    {
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {3,4,5,1,2};
        int[] nums3 = {11,13,15,17};

        System.out.println(findMin(nums1)); // 0
        System.out.println(findMin(nums2)); // 1
        System.out.println(findMin(nums3)); // 11
    }
}

/*
DRY RUN

Example:
arr = {4,5,6,7,0,1,2}

Initial

start = 0
end = 6


Iteration 1

mid = 0 + (6-0)/2 = 3
arr[mid] = 7
arr[end] = 2

arr[mid] > arr[end]
7 > 2 → TRUE

Minimum lies in right half

start = mid + 1
start = 4


Iteration 2

start = 4
end = 6

mid = 4 + (6-4)/2
mid = 5

arr[mid] = 1
arr[end] = 2

arr[mid] > arr[end] ?
1 > 2 → FALSE

Minimum lies in left half (including mid)

end = mid
end = 5


Iteration 3

start = 4
end = 5

mid = 4 + (5-4)/2
mid = 4

arr[mid] = 0
arr[end] = 1

arr[mid] > arr[end] ?
0 > 1 → FALSE

end = mid
end = 4


Loop stops because

start = 4
end = 4


Minimum element = arr[start] = 0
*/