package _5BinaryTree;

import java.util.*;

public class _14BoundaryTraversal
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

    public static void printBoundary(Node root)
    {
        if (root == null)
            return;

        System.out.print(root.val + " ");

        // Print Left Boundary (excluding leaf nodes)
        printLeftBoundary(root.left);

        // Print All Leaf Nodes
        printLeaves(root.left);
        printLeaves(root.right);

        // Print Right Boundary in bottom-up order (excluding leaf nodes)
        printRightBoundary(root.right);
    }

    private static void printLeftBoundary(Node node)
    {
        while (node != null)
        {
            if (!isLeaf(node))
                System.out.print(node.val + " ");
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    private static void printRightBoundary(Node node)
    {
        Stack<Integer> stack = new Stack<>();
        while (node != null)
        {
            if (!isLeaf(node))
                stack.push(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        while (!stack.isEmpty())
        {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void printLeaves(Node node)
    {
        if (node == null)
            return;

        if (isLeaf(node))
        {
            System.out.print(node.val + " ");
            return;
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    private static boolean isLeaf(Node node)
    {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args)
    {
        /*
                  20
                 /  \
                8    22
               / \     \
              4  12     25
                 / \
                10 14

        Expected Output:
        20 8 4 10 14 25 22
        */

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        System.out.println("Boundary Traversal:");
        printBoundary(root);
    }
}

/*

Concept:
--------
Boundary traversal of a binary tree is the traversal of nodes in the following order:
1. Root node
2. Left boundary (excluding leaves)
3. All leaf nodes (left to right)
4. Right boundary (excluding leaves, printed in reverse)

Approach:
---------
- Print root
- Traverse and print left boundary (skip leaves)
- Traverse and print all leaf nodes (left to right)
- Traverse and print right boundary (skip leaves) using stack to reverse order

Example Tree:
-------------
          20
         /  \
        8    22
       / \     \
      4  12     25
         / \
        10 14

Boundary Output:
----------------
20 8 4 10 14 25 22

*/
