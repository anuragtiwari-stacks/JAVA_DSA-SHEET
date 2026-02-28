package _06BinaryTree;

import java.util.*;

public class _11BottomView
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

    public static void printBottomView(Node root)
    {
        if (root == null)
        {
            return;
        }

        Map<Integer, Integer> bottomViewMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair curr = queue.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Overwrite the map value for the horizontal distance
            // so the last node at this hd in level order remains
            bottomViewMap.put(hd, node.val);

            if (node.left != null)
            {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : bottomViewMap.values())
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

        System.out.print("Bottom View: ");
        printBottomView(root);
    }
}

/*

Concept:
--------
Bottom View of a binary tree is the set of nodes visible when the tree is viewed from the bottom.

Approach:
---------
- Perform level-order traversal (BFS) maintaining horizontal distance (hd) from root.
- Root's hd = 0.
- Left child hd = hd(parent) - 1.
- Right child hd = hd(parent) + 1.
- For each hd, update the map with the current node's value (overwrite previous).
- After traversal, the map contains the last node at each hd (bottom view).
- Print nodes sorted by hd.

Example Tree:
-------------
        1
      /   \
     2     3
      \   / \
       4 5   6
            /
           7

Bottom View Output:
-------------------
2 4 5 7 6

*/
