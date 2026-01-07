package _12Graph;

import java.util.*;

public class _10WaterJug
{
    static class State
    {
        int x; // water in jug1
        int y; // water in jug2

        State(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean canMeasureWater(int jug1, int jug2, int target)
    {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // start from (0,0)
        queue.add(new State(0, 0));
        visited.add("0,0");

        while (!queue.isEmpty())
        {
            State curr = queue.poll();
            int x = curr.x;
            int y = curr.y;

            // check target
            if (x == target || y == target || x + y == target)
            {
                return true;
            }

            // -------- POSSIBLE OPERATIONS --------

            // +jug1 (fill jug1)
            addState(jug1, y, queue, visited);

            // +jug2 (fill jug2)
            addState(x, jug2, queue, visited);

            // -jug1 (empty jug1)
            addState(0, y, queue, visited);

            // -jug2 (empty jug2)
            addState(x, 0, queue, visited);

            // pour jug1 -> jug2
            int pour1 = Math.min(x, jug2 - y);
            addState(x - pour1, y + pour1, queue, visited);

            // pour jug2 -> jug1
            int pour2 = Math.min(y, jug1 - x);
            addState(x + pour2, y - pour2, queue, visited);
        }

        return false;
    }

    // helper to add state safely
    private static void addState(int x, int y,
                                 Queue<State> queue,
                                 Set<String> visited)
    {
        String key = x + "," + y;
        if (!visited.contains(key))
        {
            visited.add(key);
            queue.add(new State(x, y));
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int jug1 = 3;
        int jug2 = 5;
        int target = 4;

        System.out.println(canMeasureWater(jug1, jug2, target));
    }
}

/*
Input:
jug1 = 3, jug2 = 5, target = 4

Start:
queue = [(0,0)]

--------------------------------
From (0,0)
Operations:
+jug1 -> (3,0)
+jug2 -> (0,5)

queue = [(3,0), (0,5)]

--------------------------------
From (3,0)
pour jug1 -> jug2
(3,0) -> (0,3)

queue = [(0,5), (0,3)]

--------------------------------
From (0,5)
pour jug2 -> jug1
(0,5) -> (3,2)

queue = [(0,3), (3,2)]

--------------------------------
From (3,2)
pour jug1 -> jug2
(3,2) -> (0,5) [already visited]

empty jug2
(3,2) -> (3,0)

--------------------------------
From (0,3)
+jug1 -> (3,3)

queue = [(3,3)]

--------------------------------
From (3,3)
pour jug1 -> jug2
(3,3) -> (1,5)

queue = [(1,5)]

--------------------------------
From (1,5)
empty jug2
(1,5) -> (1,0)

--------------------------------
From (1,0)
pour jug1 -> jug2
(1,0) -> (0,1)

--------------------------------
Eventually reach:
(4,0) or (0,4) or (1,3)

Target achieved → TRUE
*/

