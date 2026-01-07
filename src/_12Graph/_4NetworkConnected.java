package _12Graph;

import java.util.*;

public class _4NetworkConnected
{

    /*
        LeetCode 1319
        Number of Operations to Make Network Connected

        Idea:
        - Same as Number of Provinces
        - Count connected components using BFS
        - If edges < n - 1 → return -1
        - Else answer = components - 1
    */

    public static void main(String[] args)
    {
        int n = 4;

        int[][] connections =
                {
                        {0, 1},
                        {0, 2},
                        {1, 2}
                };

        System.out.println("Minimum Operations: " + makeConnected(n, connections));
    }

    public static int makeConnected(int n, int[][] connections)
    {
        // ❌ Not enough cables
        if (connections.length < n - 1)
        {
            return -1;
        }

        // Build graph (Adjacency List)
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : connections)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        // SAME LOOP AS NUMBER OF PROVINCES
        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                bfs(graph, visited, i);
                provinceCount++;
            }
        }

        // Only difference from provinces
        return provinceCount - 1;
    }

    public static void bfs(List<List<Integer>> graph, boolean[] visited, int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty())
        {
            int node = queue.remove();

            for (int neighbor : graph.get(node))
            {
                if (!visited[neighbor])
                {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
