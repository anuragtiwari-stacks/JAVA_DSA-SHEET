package _2ARRAY_2D;

public class _24MaxArea_Histogram
{
    // Brute force method to find max area in a histogram
    public static int maxHistogram(int[] heights)
    {
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++)
        {
            int height = heights[i];

            // Expand left
            int left = i;
            while (left >= 0 && heights[left] >= height)
            {
                left--;
            }

            // Expand right
            int right = i;
            while (right < n && heights[right] >= height)
            {
                right++;
            }

            int width = right - left - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        int[] histogram = {2,1,5,6,2,3};
        int maxArea = maxHistogram(histogram);
        System.out.println("Maximum area in histogram: " + maxArea);
    }
}
