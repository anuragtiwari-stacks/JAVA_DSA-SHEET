package _12Graph;

import java.util.*;

/*
================================================
LOGIC : COUNT UNREACHABLE PAIRS OF NODES
(LeetCode 2316)
================================================

1. We are given:
   - n nodes (0 to n-1)
   - edges of an undirected graph

2. Nodes that are connected (directly or indirectly)
   form a CONNECTED COMPONENT.

3. Any two nodes belonging to DIFFERENT components
   are UNREACHABLE from each other.

4. Steps:
   a) Build graph using adjacency list
   b) Use BFS to find size of each connected component
   c) If component sizes are s1, s2, s3...
      then unreachable pairs =
         s1*s2 + s1*s3 + s2*s3 + ...

5. To avoid double counting:
   - Maintain remainingNodes
   - For each component of size s:
       answer += s * (remainingNodes - s)
       remainingNodes -= s
*/

public class _7CountUnreachablePairs
{

    public static long countPairs(int n, int[][] edges)
    {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        long answer = 0;
        long remainingNodes = n;

        // Step 2: Find connected components using BFS
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                long componentSize = bfs(i, graph, visited);

                // Count unreachable pairs with remaining nodes
                answer += componentSize * (remainingNodes - componentSize);
                remainingNodes -= componentSize;
            }
        }

        return answer;
    }

    // BFS to calculate size of one connected component
    private static long bfs(int start, List<List<Integer>> graph, boolean[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        long size = 1;

        while (!queue.isEmpty())
        {
            int node = queue.remove();

            for (int neighbor : graph.get(node))
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    size++;
                }
            }
        }

        return size;
    }

    // Driver code for IDE
    public static void main(String[] args)
    {
        int n = 7;
        int[][] edges =
                {
                        {0, 2},
                        {0, 5},
                        {2, 4},
                        {1, 6},
                        {5, 4}
                };

        System.out.println("Unreachable pairs = " + countPairs(n, edges));
    }
}

/*
================================================
COMPLETE DRY RUN (GIVEN INPUT)
================================================

Input:
n = 7
edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]

-----------------------------------------------
Graph (Adjacency List):
-----------------------------------------------
0 -> 2, 5
1 -> 6
2 -> 0, 4
3 -> (no connection)
4 -> 2, 5
5 -> 0, 4
6 -> 1

-----------------------------------------------
Connected Components using BFS:
-----------------------------------------------

Component 1 (start from 0):
0 -> 2 -> 4 -> 5
Component = {0,2,4,5}
Size = 4

Component 2 (start from 1):
1 -> 6
Component = {1,6}
Size = 2

Component 3 (start from 3):
3 (isolated)
Component = {3}
Size = 1

-----------------------------------------------
Component Sizes:
[4, 2, 1]
-----------------------------------------------

Calculation:
remainingNodes = 7
answer = 0

Component size = 4
answer += 4 * (7 - 4) = 12
remainingNodes = 3

Component size = 2
answer += 2 * (3 - 2) = 2
remainingNodes = 1

Component size = 1
answer += 1 * (1 - 1) = 0

-----------------------------------------------
Final Answer:
Unreachable pairs = 14
================================================
*/
