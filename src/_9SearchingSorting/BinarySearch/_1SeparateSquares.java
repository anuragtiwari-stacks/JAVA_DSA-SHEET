package _9SearchingSorting.BinarySearch;
// LeetCode 3453 - Separate Squares I

public class _1SeparateSquares
{
    public double separateSquares(int[][] squares)
    {
        double totalArea = 0.0;
        double low = 2e9;
        double high = 0.0;

        // STEP 1: compute total area + Y bounds
        for (int[] sq : squares)
        {
            double y = sq[1];
            double l = sq[2];

            totalArea += l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        // STEP 2: binary search for line where below_area == top_area
        while (high - low > 1e-5)
        {
            double mid = low + (high - low) / 2.0;

            double below_area = calculateAreaBelow(squares, mid);
            double top_area   = totalArea - below_area;

            // ========= 3 CASE LOGIC =========

            // CASE 1: equal (within tolerance)
            if (Math.abs(below_area - top_area) <= 1e-9)
            {
                high = mid;
                break;
            }
            // CASE 2: bottom area > top area → shift mid downward
            else if (below_area > top_area)
            {
                high = mid;
            }
            // CASE 3: bottom area < top area → shift mid upward
            else
            {
                low = mid;
            }
        }

        return high; // converged position
    }

    // Compute area below Y = currentY
    private double calculateAreaBelow(int[][] squares, double currentY)
    {
        double area = 0.0;

        for (int[] sq : squares)
        {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            // Case A: Entire square above line
            if (currentY <= y)
            {
                continue;
            }
            // Case B: Entire square below line
            else if (currentY >= top)
            {
                area += l * l;
            }
            // Case C: Intersection
            else
            {
                double height = currentY - y;
                area += l * height;
            }
        }

        return area;
    }

    // MAIN for IDE testing
    public static void main(String[] args)
    {
        _1SeparateSquares obj = new _1SeparateSquares();


        int[][] squares =
                {
                        {0, 0, 2},   // bottom=0, top=2, area=4
                        {1, 1, 1}    // bottom=1, top=2, area=1
                };

        double ans = obj.separateSquares(squares);
        System.out.println("Cut height (Y) = " + ans);
    }
}

/*
========================== DRY RUN ==========================

Given:
Square A: y=0, l=2, top=2 → area = 4
Square B: y=1, l=1, top=2 → area = 1

totalArea = 5
halfArea = 2.5

Initial bounds:
low = 0
high = 2

--------------------------------------------------------------
Iteration 1:
mid = (0 + 2)/2 = 1.0

calculateBelow(1.0):
 Square A: 0 < 1 < 2 → partial → area += 2 * (1 - 0) = 2
 Square B: 1 >= mid? (1 <= 1.0) → square fully above → +0

below_area = 2
top_area   = totalArea - below_area = 5 - 2 = 3

Comparison:
below_area (2) < top_area (3) → shift upward
low = mid = 1.0

--------------------------------------------------------------
Iteration 2:
mid = (1.0 + 2)/2 = 1.5

calculateBelow(1.5):
 Square A: partial → 2 * (1.5 - 0) = 3
 Square B: partial → 1 * (1.5 - 1) = 0.5
below_area = 3.5
top_area   = 5 - 3.5 = 1.5

Comparison:
below_area (3.5) > top_area (1.5) → shift downward
high = mid = 1.5

--------------------------------------------------------------
Iteration 3:
mid = (1.0 + 1.5)/2 = 1.25

calculateBelow(1.25):
 Square A: partial → 2 * 1.25 = 2.5
 Square B: partial → 1 * (1.25 - 1) = 0.25
below_area = 2.75
top_area   = 5 - 2.75 = 2.25

Comparison:
below_area (2.75) > top_area (2.25) → shift downward
high = mid = 1.25

--------------------------------------------------------------
Iteration 4:
mid = (1.0 + 1.25)/2 = 1.125

calculateBelow(1.125):
 Square A: 2 * 1.125 = 2.25
 Square B: 1 * (1.125 - 1) = 0.125
below_area = 2.375
top_area   = 5 - 2.375 = 2.625

Comparison:
below_area (2.375) < top_area (2.625) → shift upward
low = mid = 1.125

--------------------------------------------------------------
Binary search continues...
Finally converges near:

low ≈ 1.1666667
high ≈ 1.1666667

This value makes:
below_area ≈ 2.5
top_area ≈ 2.5

So cut height Y = 1.1666667 is final answer.

==============================================================
*/
