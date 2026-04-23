package _01ARRAY_1D._8BuySell;

public class StockProfit
{
    // Method to calculate max profit using rightMax array approach
    public static int maxProfit(int[] prices)
    {
        // Edge case: agar array null ya size <= 1
        if (prices == null || prices.length <= 1)
        {
            return 0;
        }

        int n = prices.length;

        // Step 1: rightMax array create karo
        int[] rightMax = new int[n];

        // Last element same rahega
        rightMax[n - 1] = prices[n - 1];

        // Right se left traverse karke max fill karo
        for (int i = n - 2; i >= 0; i--)
        {
            rightMax[i] = Math.max(prices[i], rightMax[i + 1]);
        }

        // Step 2: max profit calculate karo
        int maxProfit = 0;

        for (int i = 0; i < n; i++)
        {
            int profit = rightMax[i] - prices[i];
            if (profit > maxProfit)
            {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    // Main method
    public static void main(String[] args)
    {
        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit (Example 1): " + maxProfit(prices1));
        // Expected Output: 5

        // Example 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit (Example 2): " + maxProfit(prices2));
        // Expected Output: 0
    }
}