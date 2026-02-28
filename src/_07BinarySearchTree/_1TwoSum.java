package _07BinarySearchTree;

import java.util.ArrayList;

public class _1TwoSum
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

    // Insert into BST
    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Inorder traversal (BST → Sorted List)
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

    // Two Sum IV
    public boolean findTarget(Node root, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right)
        {
            int sum = list.get(left) + list.get(right);

            if (sum == k)
            {
                return true;
            }
            else if (sum < k)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        _1TwoSum tree = new _1TwoSum();
        Node root = null;

        int[] values = {5, 3, 6, 2, 4, 7};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        int k = 9;
        System.out.println(tree.findTarget(root, k)); // true
    }
}

/*
====================== DRY RUN ======================

BST:
        5
       / \
      3   6
     / \   \
    2   4   7

Target k = 9

STEP 1: Inorder Traversal (Left → Root → Right)

Traversal:
2 → 3 → 4 → 5 → 6 → 7

List = [2, 3, 4, 5, 6, 7]

----------------------------------------------------

STEP 2: Two Pointer

left = 0  (2)
right = 5 (7)

sum = 2 + 7 = 9
sum == k → return true

----------------------------------------------------

FINAL OUTPUT:
true
====================================================
*/
