package _6BinaryTree;

import java.util.*;

public class _15MinSwapsToBST
{

    static class Node
    {
        int val;
        Node left, right;

        Node(int val)
        {
            this.val = val;
            left = right = null;
        }
    }

    // Step 1: Inorder traversal to get elements in list
    public static void inorder(Node root, ArrayList<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // Step 2: Count minimum swaps using Bubble Sort
    public static int minSwaps(ArrayList<Integer> list)
    {
        int n = list.size();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = list.get(i);
        }

        int swaps = 0;

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        return swaps;
    }

    public static void main(String[] args)
    {
        /*
        Tree Used:

                 1
               /   \
              2     3
             / \   /
            4   5 6

        Inorder traversal: [4, 2, 5, 1, 6, 3]
        Sorted inorder (BST): [1, 2, 3, 4, 5, 6]
        Minimum swaps to sort inorder: 3
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);

        System.out.println("Inorder Traversal: " + inorderList);
        int swaps = minSwaps(inorderList);
        System.out.println("Minimum swaps to convert Binary Tree to BST: " + swaps);
    }

}

/*
Concept:
--------
- Inorder traversal of a BST is always sorted in ascending order.
- To convert a Binary Tree to a BST, we:
    1. Get inorder traversal of the tree.
    2. Count the minimum swaps required to sort the inorder traversal.

This gives us the minimum number of node swaps required to transform the tree into a BST.

Tree Used:
-----------
        1
      /   \
     2     3
    / \   /
   4   5 6

Inorder of Binary Tree: [4, 2, 5, 1, 6, 3]
Sorted (BST Inorder):   [1, 2, 3, 4, 5, 6]
Minimum Swaps: 3
*/
