/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
*/
package _01ARRAY_1D._8BuySell;

public class StockProfitCalculator
{
    // Method to calculate the maximum profit
    public static int maxProfit(int[] prices)
    {
        // If prices array is empty or has only one day, profit is 0
        if (prices == null || prices.length <= 1)
        {
            return 0;
        }

        // Initialize minimum price to the first day price
        int minPrice = prices[0];

        // Initialize maxProfit to 0 (no transaction yet)
        int maxProfit = 0;

        // Loop through the prices array starting from day 1
        for (int i = 1; i < prices.length; i++)
        {
            // If current price is lower than minPrice, update minPrice
            if (prices[i] < minPrice)
            {
                minPrice = prices[i];
            }
            else if(prices[i] > minPrice)
            {
                // Else, calculate profit and update maxProfit if higher
                int profit = prices[i] - minPrice;
                if (profit > maxProfit)
                {
                    maxProfit = profit;
                }
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }

    // Main method to test the program
    public static void main(String[] args)
    {
        // Example 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Maximum Profit (Example 1): " + maxProfit(prices1));
        // Expected Output: 5

        // Example 2
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Maximum Profit (Example 2): " + maxProfit(prices2));
        // Expected Output: 0
    }

}


/*
Day 1 (price = 1):
Is 1 < 7? 👉 Yes → Update minPrice = 1
No profit calculated yet because we updated the buying price.

Day 2 (price = 5):
Is 5 < 1? 👉 No
Profit = 5 - 1 = 4
Is 4 > 0? 👉 Yes → Update maxProfit = 4

Day 3 (price = 3):
Is 3 < 1? 👉 No
Profit = 3 - 1 = 2
Is 2 > 4? 👉 No → maxProfit remains 4

Day 4 (price = 6):
Is 6 < 1? 👉 No
Profit = 6 - 1 = 5
Is 5 > 4? 👉 Yes → Update maxProfit = 5

Day 5 (price = 4):
Is 4 < 1? 👉 No
Profit = 4 - 1 = 3
Is 3 > 5? 👉 No → maxProfit remains 5
*/