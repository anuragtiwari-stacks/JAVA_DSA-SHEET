package _6BinarySearchTree;

import java.util.Arrays;

public class _12ReplaceWithLeastGreaterBst
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

    static Node root = null;

    public static int insertAndGetSuccessor(int key)
    {
        Node current = root;
        Node parent = null;
        Node successor = null;

        while (current != null)
        {
            parent = current;

            if (key < current.value)
            {
                successor = current;
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }

        Node newNode = new Node(key);

        if (root == null)
        {
            root = newNode;
        }
        else if (key < parent.value)
        {
            parent.left = newNode;
        }
        else
        {
            parent.right = newNode;
        }

        if (successor != null)
        {
            return successor.value;
        }
        else
        {
            return -1;
        }
    }

    public static void replaceWithLeastGreater(int[] arr)
    {
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--)
        {
            int succ = insertAndGetSuccessor(arr[i]);
            arr[i] = succ;
        }
    }

    public static void main(String[] args)
    {
        int[] arr =
                {
                        8, 58, 71, 18, 31, 32, 63, 92,
                        43, 3, 91, 93, 25, 80, 28
                };

        replaceWithLeastGreater(arr);

        System.out.println(Arrays.toString(arr));
    }
}
