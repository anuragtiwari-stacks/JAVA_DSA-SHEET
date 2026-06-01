package _14Greedy;

import java.util.Arrays;

public class _4MinimumCostOfBuyingCandies
{

    /*
        🔗 LeetCode 2144 - Minimum Cost of Buying Candies With Discount

        A shop is selling candies.

        You can buy any two candies and get one additional candy
        for free.

        The free candy must have a cost less than or equal to the
        minimum cost of the two candies bought.

        Return the minimum cost needed to buy all candies.

        ---------------------------------------------------

        Example:

        Input:
        cost = [6,5,7,9,2,2]

        Output:
        23

        Explanation:

        Buy 9 and 7
        Get 6 free

        Buy 5 and 2
        Get 2 free

        Total = 9 + 7 + 5 + 2 = 23
    */

    public static void main(String[] args)
    {

        int[] cost = {6, 5, 7, 9, 2, 2};

        Arrays.sort(cost);

        int amount = 0;

        for (int i = cost.length - 1; i >= 0; i = i - 3)
        {

            int first = i;
            int second = i - 1;

            amount = amount + cost[first];

            if (second >= 0)
            {
                amount = amount + cost[second];
            }
        }

        System.out.println(amount);
    }
}