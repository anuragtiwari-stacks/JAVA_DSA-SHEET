package _12Graph;
/*
Question:
3650. Minimum Cost Path with Edge Reversals

Given a directed graph, each edge (u -> v) with weight w.
We can reverse an edge at a cost of 2*w.
Find the minimum cost path from source to destination.
*/

import java.util.*;

public class _12MinimumCostPathWithEdgeReversals
{

    static class Pair
    {
        int node;
        int dist;

        Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }


    public static int minCost(int n, int[][] edges, int src, int dest)
    {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
        }

        // build graph with original + reversed edges
        for (int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, 2 * w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty())
        {
            Pair curr = pq.poll();
            int node = curr.node;
            int currDist = curr.dist;

            if (currDist > dist[node])
            {
                continue;
            }

            for (Pair nei : adj.get(node))
            {
                if (currDist + nei.dist < dist[nei.node])
                {
                    dist[nei.node] = currDist + nei.dist;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        return dist[dest];
    }


    public static void main(String[] args)
    {
        int n = 4;

        int[][] edges =
                {
                        {0, 1, 3},
                        {3, 1, 1},
                        {2, 3, 4},
                        {0, 2, 2}
                };

        int src = 0;
        int dest = 3;

        int ans = minCost(n, edges, src, dest);
        System.out.println(ans);
    }
}


/*
DRY RUN:

Input:
n = 4
edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
src = 0
dest = 3

Graph after updating connections:

0 -> 1 (3)
1 -> 0 (6)

3 -> 1 (1)
1 -> 3 (2)

2 -> 3 (4)
3 -> 2 (8)

0 -> 2 (2)
2 -> 0 (4)

Initial:
dist = [0, INF, INF, INF]
PQ = (0,0)

Step 1:
pop (0,0)
update:
1 -> dist = 3
2 -> dist = 2
PQ = (2,2), (1,3)

Step 2:
pop (2,2)
update:
3 -> dist = 6
PQ = (1,3), (3,6)

Step 3:
pop (1,3)
update:
3 -> min(6, 3 + 2) = 5
PQ = (3,5)

Step 4:
pop (3,5)
destination reached

Final dist:
[0, 3, 2, 5]

Answer = 5
*/
