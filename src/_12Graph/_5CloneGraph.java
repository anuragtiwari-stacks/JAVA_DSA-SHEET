package _12Graph;

import java.util.*;

/*
========================================
LOGIC : CLONE GRAPH (SIMPLE VERSION)
========================================

1. Graph nodes may form cycles.
2. We must create a DEEP COPY (new nodes).
3. Use BFS to traverse the graph.
4. Use a HashMap:
      original node -> cloned node
   (this also works as visited)
5. For each node:
   - clone its neighbors
   - connect cloned nodes
6. Return the cloned start node.
*/

public class _5CloneGraph
{
    static class Node
    {
        int val;
        List<Node> neighbors;

        Node(int val)
        {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node)
    {
        if (node == null)
        {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        // clone first node
        map.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty())
        {
            Node curr = queue.remove();

            for (Node nei : curr.neighbors)
            {
                // if neighbor not cloned
                if (!map.containsKey(nei))
                {
                    map.put(nei, new Node(nei.val));
                    queue.add(nei);
                }

                // connect clone nodes
                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }

    // IDE test
    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node clone = cloneGraph(n1);
        System.out.println("Cloned start node value = " + clone.val);
    }
}

/*
========================================
DRY RUN (EASY)
========================================

Graph:
1 -- 2
|    |
4 -- 3

Step 1:
Clone node 1
map = {1 -> 1'}
queue = [1]

Step 2:
Process 1
neighbors: 2, 4
clone 2, clone 4
connect 1' -> 2', 4'
queue = [2, 4]

Step 3:
Process 2
neighbors: 1, 3
1 already cloned
clone 3
connect 2' -> 1', 3'
queue = [4, 3]

Step 4:
Process 4
neighbors: 1, 3
already cloned
connect 4' -> 1', 3'

Step 5:
Process 3
neighbors: 2, 4
already cloned
connect 3' -> 2', 4'

Graph fully cloned.
========================================
*/
