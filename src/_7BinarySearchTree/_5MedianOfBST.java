package _7BinarySearchTree;

import java.util.ArrayList;

public class _5MedianOfBST
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

    public void inorder(Node root, ArrayList<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    public double findMedian(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root, list);

        int n = list.size();

        if (n % 2 == 1)
        {
            return list.get(n / 2);
        }
        else
        {
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }

    public static void main(String[] args)
    {
        _5MedianOfBST tree = new _5MedianOfBST();

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        double median = tree.findMedian(root);
        System.out.println("Median of BST = " + median);
    }
}

/*
BST:

            6
           / \
          3   8
         / \  / \
        1  4 7  9

Step 1: Inorder traversal (BST gives sorted order)
Inorder list:
[1, 3, 4, 6, 7, 8, 9]

Step 2: Size of list
n = 7 (odd)

Step 3: Median
median = list[n/2] = list[3] = 6

Output:
Median of BST = 6.0
*/
