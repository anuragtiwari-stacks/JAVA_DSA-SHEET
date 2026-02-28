package _03STRING;

public class _29WordWrap
{

    public static int solveWordWrap(int[] arr, int k)
    {
        return helper(arr, k, 0);
    }

    // Recursive helper method to find minimum cost starting from word 'start'
    private static int helper(int[] arr, int k, int start)
    {
        int n = arr.length;

        // Base case: no words left to arrange
        if (start == n)
        {
            return 0;
        }

        int length = -1;  // length of current line (-1 to offset first word's space)
        int minCost = Integer.MAX_VALUE;

        // Try to fit words from start to end in one line
        for (int end = start; end < n; end++)
        {
            length += arr[end] + 1;  // add word length and one space

            if (length > k)
            {
                break;  // line width exceeded
            }

            int cost;
            if (end == n - 1)
            {
                cost = 0;  // no cost for last line
            }
            else
            {
                int extraSpaces = k - length;
                cost = extraSpaces * extraSpaces;
            }

            // Recur for rest of the words and calculate total cost
            int totalCost = cost + helper(arr, k, end + 1);

            if (totalCost < minCost)
            {
                minCost = totalCost;
            }
        }

        return minCost;
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 2, 2, 5};
        int k = 6;

        System.out.println("Minimum cost: " + solveWordWrap(arr, k));  // Output: 10
    }

}
