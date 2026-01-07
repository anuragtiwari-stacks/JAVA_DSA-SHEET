package _6BinaryTree;

import java.util.*;

public class _10TopView
{
    static class Node
    {
        int val;
        Node left, right;

        Node(int val)
        {
            this.val = val;
            this.left = this.right = null;
        }
    }

    static class Pair
    {
        Node node;
        int hd;

        Pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void printTopView(Node root)
    {
        if (root == null)
        {
            return;
        }

        // TreeMap to keep horizontal distances sorted
        Map<Integer, Integer> topViewMap = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair curr = queue.poll();
            int hd = curr.hd;
            Node node = curr.node;

            // Insert if first time seeing this horizontal distance
            if (!topViewMap.containsKey(hd))
            {
                topViewMap.put(hd, node.val);
            }

            if (node.left != null)
            {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print the top view nodes sorted by horizontal distance
        for (int val : topViewMap.values())
        {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        /*
               1
             /   \
            2     3
             \   / \
              4 5   6
                   /
                  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        System.out.print("Top View: ");
        printTopView(root);
    }
}

/*

Concept:
--------
Top View of a binary tree is the set of nodes visible when the tree is viewed from the top.

Approach:
---------
- Perform level-order traversal (BFS) while maintaining horizontal distance (hd) from root.
- Root has hd = 0.
- Left child has hd = hd(parent) - 1.
- Right child has hd = hd(parent) + 1.
- Use a map to record the first node encountered at each hd during BFS.
- The first node at each hd corresponds to the top view node at that vertical line.
- Finally, print nodes in the sorted order of hd.

Example Tree:
-------------
        1
      /   \
     2     3
      \   / \
       4 5   6
            /
           7

Top View Output:
----------------
2 1 3 6

*/
