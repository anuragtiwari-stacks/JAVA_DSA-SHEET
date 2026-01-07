package _12Graph;

import java.util.*;

/*
================================================
LOGIC : POSSIBLE BIPARTITION (LeetCode 886)
================================================

1. We are given:
   - n people (1 to n)
   - dislikes array where dislikes[i] = [a, b]
     means person a and b dislike each other.

2. We need to divide people into TWO groups such that:
   - No two people in the SAME group dislike each other.

3. This is exactly the BIPARTITE GRAPH problem.

4. Graph idea:
   - Each person = node
   - Each dislike = edge
   - We try to color nodes using 2 colors (0 and 1)

5. Rules:
   - If a person is color 0, all neighbors must be color 1
   - If conflict happens → return false

6. Use BFS (same as Provinces):
   - Graph may be disconnected
   - So run BFS from every unvisited node

7. If BFS finishes without conflict → return true
*/

public class _8PossibleBipartition
{

    public static boolean possibleBipartition(int n, int[][] dislikes)
    {
        // Step 1: Build graph (1-based indexing)
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] d : dislikes)
        {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        // color array: -1 = uncolored, 0 and 1 are two groups
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        // Step 2: Check each component using BFS
        for (int i = 1; i <= n; i++)
        {
            if (color[i] == -1)
            {
                if (!bfsCheck(i, graph, color))
                {
                    return false;
                }
            }
        }

        return true;
    }

    // BFS to check bipartite
    private static boolean bfsCheck(int start, List<List<Integer>> graph, int[] color)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;   // assign first group

        while (!queue.isEmpty())
        {
            int person = queue.remove();

            for (int neighbor : graph.get(person))
            {
                // If neighbor not colored, assign opposite color
                if (color[neighbor] == -1)
                {
                    color[neighbor] = 1 - color[person];
                    queue.add(neighbor);
                }
                // If neighbor has same color → conflict
                else if (color[neighbor] == color[person])
                {
                    return false;
                }
            }
        }

        return true;
    }

    // Driver code for IDE
    public static void main(String[] args)
    {
        int n = 4;
        int[][] dislikes =
                {
                        {1, 2},
                        {1, 3},
                        {2, 4}
                };

        System.out.println("Possible Bipartition = " +
                possibleBipartition(n, dislikes));
    }
}

/*
================================================
COMPLETE DRY RUN (SIMPLE)
================================================

Input:
n = 4
dislikes = [[1,2],[1,3],[2,4]]

Graph:
1 -> 2, 3
2 -> 1, 4
3 -> 1
4 -> 2

-----------------------------------------------
Start:
color = [-1, -1, -1, -1, -1]

-----------------------------------------------
Start BFS from node 1
Assign color[1] = 0
queue = [1]

-----------------------------------------------
Process 1:
neighbors = 2, 3

Assign:
color[2] = 1
color[3] = 1
queue = [2, 3]

-----------------------------------------------
Process 2:
neighbors = 1, 4

1 already colored (ok)
Assign:
color[4] = 0
queue = [3, 4]

-----------------------------------------------
Process 3:
neighbors = 1
No conflict

-----------------------------------------------
Process 4:
neighbors = 2
No conflict

-----------------------------------------------
All nodes colored without conflict

Final Answer:
true
================================================
*/
