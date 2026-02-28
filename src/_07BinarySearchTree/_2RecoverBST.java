package _07BinarySearchTree;

import java.util.ArrayList;

public class _2RecoverBST
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    // to store inorder traversal
    ArrayList<Node> inorderNodes = new ArrayList<>();

    // Recover BST
    public void recoverBST(Node root)
    {
        // Step 1: inorder traversal → node list
        inorder(root);

        Node first = null;
        Node second = null;

        // Step 2: find two nodes violating BST property
        for (int i = 0; i < inorderNodes.size() - 1; i++)
        {
            if (inorderNodes.get(i).value > inorderNodes.get(i + 1).value)
            {
                if (first == null)
                {
                    first = inorderNodes.get(i);
                    second = inorderNodes.get(i + 1);
                }
                else
                {
                    second = inorderNodes.get(i + 1);
                    break;
                }
            }
        }

        // Step 3: swap values directly
        if (first != null && second != null)
        {
            int temp = first.value;
            first.value = second.value;
            second.value = temp;
        }
    }

    // Inorder traversal (store node references)
    private void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);
        inorderNodes.add(root);
        inorder(root.right);
    }

    // Print inorder (for checking)
    public void printInorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        printInorder(root.left);
        System.out.print(root.value + " ");
        printInorder(root.right);
    }

    public static void main(String[] args)
    {
        _2RecoverBST tree = new _2RecoverBST();

        /*
                WRONG BST (two nodes swapped)

                      3
                     / \
                    1   4
                       /
                      2
        */

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);

        System.out.print("Before Recovery (Inorder): ");
        tree.printInorder(root);   // 1 3 2 4

        tree.recoverBST(root);

        System.out.print("\nAfter Recovery (Inorder): ");
        tree.printInorder(root);   // 1 2 3 4
    }
}

/*
====================== DRY RUN ======================

Inorder traversal (nodes):
[1, 3, 2, 4]

Check:
3 > 2  ❌ violation

first  = node(3)
second = node(2)

Swap:
first.value  = 2
second.value = 3

Final inorder:
1 2 3 4

BST Recovered ✅
====================================================
*/
