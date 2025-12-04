package _6BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class _14MedianOfBST
{
    static class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void inorder(Node root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    public static double findMedian(Node root)
    {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);

        int n = list.size();

        if (n % 2 == 1)
        {
            return list.get(n / 2);
        }
        else
        {
            int a = list.get(n / 2 - 1);
            int b = list.get(n / 2);
            return (a + b) / 2.0;
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        double median = findMedian(root);

        System.out.println("Median of BST: " + median);
    }
}
