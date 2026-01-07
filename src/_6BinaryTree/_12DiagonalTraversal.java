package _6BinaryTree;

import java.util.*;

public class _12DiagonalTraversal
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
        int slope; // diagonal level

        Pair(Node node, int slope)
        {
            this.node = node;
            this.slope = slope;
        }
    }

    public static void printDiagonalTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }

        Map<Integer, List<Integer>> diagonalMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair curr = queue.poll();
            Node node = curr.node;
            int slope = curr.slope;

            diagonalMap.putIfAbsent(slope, new ArrayList<>());
            diagonalMap.get(slope).add(node.val);

            // left child goes to next diagonal
            if (node.left != null)
            {
                queue.add(new Pair(node.left, slope + 1));
            }

            // right child stays on same diagonal
            if (node.right != null)
            {
                queue.add(new Pair(node.right, slope));
            }
        }

        // Print diagonals
        for (List<Integer> diag : diagonalMap.values())
        {
            for (int val : diag)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        /*
               8
             /   \
            3     10
           / \      \
          1   6      14
             / \     /
            4   7   13
        */

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        System.out.println("Diagonal Traversal:");
        printDiagonalTraversal(root);
    }
}

/*

Concept:
--------
In Diagonal Traversal, all nodes having the same diagonal slope are grouped together.
Think of diagonals from top-right to bottom-left.

Approach:
---------
- Perform level-order traversal while tracking diagonal slope:
  - Root starts at slope = 0.
  - Right child stays on the same slope.
  - Left child goes to the next slope (slope + 1).
- Store nodes in a map: slope → list of node values.
- Print the diagonals in increasing order of slope.

Example Tree:
-------------
        8
      /   \
     3     10
    / \      \
   1   6      14
      / \     /
     4   7   13

Diagonal Output:
----------------
8 10 14
3 6 7 13
1 4

*/
