package _7BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class _3BinaryTreeToBST
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

    public void inorderStore(Node root, ArrayList<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorderStore(root.left, list);
        list.add(root.value);
        inorderStore(root.right, list);
    }

    public Node buildBST(ArrayList<Integer> list, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = buildBST(list, start, mid - 1);
        root.right = buildBST(list, mid + 1, end);

        return root;
    }

    public Node binaryTreeToBST(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        inorderStore(root, list);

        Collections.sort(list);

        return buildBST(list, 0, list.size() - 1);
    }

    public void inorderPrint(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorderPrint(root.left);
        System.out.print(root.value + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args)
    {
        _3BinaryTreeToBST tree = new _3BinaryTreeToBST();

        Node root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        Node bstRoot = tree.binaryTreeToBST(root);

        tree.inorderPrint(bstRoot);
    }
}

/*
Original Binary Tree:

            10
           /  \
         30    15
        /        \
      20          5

Step 1: Inorder traversal (store)
20 30 10 15 5

Step 2: Collections.sort
[5, 10, 15, 20, 30]

Step 3: Build BST using mid

mid = 2 → root = 15

Left subtree:
mid = 0 → root = 5
right = 10

Right subtree:
mid = 3 → root = 20
right = 30

Final BST:

            15
           /  \
          5    20
           \     \
           10     30

Final inorder:
5 10 15 20 30
*/
