package _16Maths;

// LeetCode 1266 — Minimum Time Visiting All Points

public class _1MinimumTimeVisitingAllPoints
{
    public int minTimeToVisitAllPoints(int[][] points)
    {
        int time = 0;

        for(int i = 0; i < points.length - 1; i = i + 1)
        {
            int x1 = points[i][0];
            int y1 = points[i][1];

            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            time = time + Math.max(dx, dy);
        }

        return time;
    }

    public static void main(String[] args)
    {
        _1MinimumTimeVisitingAllPoints obj = new _1MinimumTimeVisitingAllPoints();

        int[][] points1 = { {1,1}, {3,4}, {-1,0} };
        System.out.println(obj.minTimeToVisitAllPoints(points1)); // Output: 7

        int[][] points2 = { {3,2}, {-2,2} };
        System.out.println(obj.minTimeToVisitAllPoints(points2)); // Output: 5
    }
}

/*
---------------- DRY RUN ----------------

Input:
points = [[1,1], [3,4], [-1,0]]

Loop steps:

i = 0:
 (x1, y1) = (1, 1)
 (x2, y2) = (3, 4)
 dx = |3 - 1| = 2
 dy = |4 - 1| = 3
 time += max(2, 3) = 3

i = 1:
 (x1, y1) = (3, 4)
 (x2, y2) = (-1, 0)
 dx = |(-1) - 3| = 4
 dy = |0 - 4| = 4
 time += max(4, 4) = 4

Total time = 3 + 4 = 7

-----------------------------------------

Input:
points = [[3,2], [-2,2]]

i = 0:
 (x1, y1) = (3, 2)
 (x2, y2) = (-2, 2)
 dx = |(-2) - 3| = 5
 dy = |2 - 2| = 0
 time += max(5,0) = 5

Total time = 5

-----------------------------------------
*/
