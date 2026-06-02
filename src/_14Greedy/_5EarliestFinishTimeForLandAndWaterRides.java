package _14Greedy;

// LeetCode 3642 - Earliest Finish Time for Land and Water Rides

public class _5EarliestFinishTimeForLandAndWaterRides
{
    public int solve(int[] start1, int[] duration1, int[] start2, int[] duration2)
    {
        int n = duration1.length;
        int m = duration2.length;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            int finish1 = start1[i] + duration1[i];

            for(int j = 0; j < m; j++)
            {
                int startSecond = Math.max(finish1, start2[j]);
                ans = Math.min(ans, startSecond + duration2[j]);
            }
        }
        return ans;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
    {
        int landFirst = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int waterFirst = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(landFirst, waterFirst);
    }

    public static void main(String[] args)
    {
        _5EarliestFinishTimeForLandAndWaterRides obj = new _5EarliestFinishTimeForLandAndWaterRides();

        // Example-1
        int[] landStartTime1 = {2, 8};
        int[] landDuration1 = {4, 1};

        int[] waterStartTime1 = {6};
        int[] waterDuration1 = {3};

        int ans1 = obj.earliestFinishTime(landStartTime1, landDuration1, waterStartTime1, waterDuration1);

        System.out.println("Example-1 Answer : " + ans1);

        // Example-2
        int[] landStartTime2 = {99};
        int[] landDuration2 = {59};

        int[] waterStartTime2 = {99, 54};
        int[] waterDuration2 = {85, 20};

        int ans2 = obj.earliestFinishTime(landStartTime2, landDuration2, waterStartTime2, waterDuration2);

        System.out.println("Example-2 Answer : " + ans2);
    }
}