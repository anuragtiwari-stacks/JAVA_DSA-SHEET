/*
Given an array arr[] of size n, which is sorted and then rotated around an unknown pivot,
the task is to check whether there exists a pair of elements in the array whose sum is equal to a given target value.

Examples :
Input: arr[] = [11, 15, 6, 8, 9, 10], target = 16
Output: true
Explanation: There is a pair (6, 10) with sum 16.

Input: arr[] = [11, 11, 15, 26, 38, 9, 10], target = 35
Output: true
Explanation: There is a pair (26, 9) with sum 35.

Input: arr[] = [9, 10, 10, 11, 15, 26, 38], target = 45
Output: false
Explanation: There is no pair with sum 45.
*/
package _01ARRAY_1D._18SumProblems;

public class _1PairSumSortedRotated
{
    public static boolean pairInSortedRotated(int[] arr, int target)
    {
        int n = arr.length;

        // Step 1: Find pivot (index of the smallest element)
        int pivot = -1;
        for (int i = 0; i < n - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                pivot = i + 1;
                break;
            }
        }

        if (pivot == -1)
        {
            pivot = 0; // Not rotated
        }

        // Step 2: Use two pointers
        int l = pivot; // smallest
        int r = (pivot - 1 + n) % n; // largest

        // Step 3: Search for the pair
        while (l != r)
        {
            int sum = arr[l] + arr[r];

            if (sum == target)
            {
                return true;
            }

            if (sum < target)
            {
                l = (l + 1) % n;
            }
            else if (sum > target)
            {
                r = (r - 1 + n) % n;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;

        System.out.println(pairInSortedRotated(arr, target)); // Output: true
    }
}


/*
⚙️ How It Works
🔑 Step 1: Find the pivot point
Pivot = index of the smallest element in the rotated array.

This also gives you:
The smallest element → arr[pivot]
The largest element → arr[(pivot - 1 + n) % n]

🔑 Step 2: Use Two Pointers (Circular)
l = pivot → start at the smallest
r = (pivot - 1 + n) % n → start at the largest

Now use a circular two-pointer approach:

While l != r:
If arr[l] + arr[r] == target → return true
If the sum is less, move l forward: l = (l + 1) % n
If the sum is greater, move r backward: r = (n + r - 1) % n

⛔ Stop When:
l == r → no more unique pairs to check
*/

/*
Step 1: Find the pivot (smallest element)
We scan the array to find where the order breaks:

i	arr[i]	arr[i+1]	arr[i] > arr[i+1]?
0	11	        15	    No
1	15 	         6	    ✅ Yes → Pivot at i+1 = 2

Now we know:
l = pivot = 2 → arr[2] = 6 (smallest)
r = (pivot - 1 + n) % n = (2 - 1 + 6) % 6 = 7 % 6 = 1 → arr[1] = 15 (largest)

| Iteration | l (index) | arr\[l] | r (index) | arr\[r] | Sum         | Action                     |
| --------- | --------- | ------- | --------- | ------- | ----------- | -------------------------- |
| 1         | 2         | 6       | 1         | 15      | 6 + 15 = 21 | > 16 → move r back         |
| 2         | 2         | 6       | 0         | 11      | 6 + 11 = 17 | > 16 → move r back         |
| 3         | 2         | 6       | 5         | 10      | 6 + 10 = 16 | ✅ Found pair → return true |
*/