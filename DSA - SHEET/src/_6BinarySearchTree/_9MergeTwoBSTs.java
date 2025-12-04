package _6BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class MyNode
{
    int value;
    MyNode left, right;

    MyNode(int value)
    {
        this.value = value;
        left = right = null;
    }
}

public class _9MergeTwoBSTs
{
    // Insert node into BST
    public MyNode insert(MyNode root, int value)
    {
        if (root == null)
        {
            return new MyNode(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Inorder traversal to array
    public void inorder(MyNode root, List<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    // Merge two sorted arrays
    public List<Integer> mergeArrays(List<Integer> a, List<Integer> b)
    {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size())
        {
            if (a.get(i) < b.get(j))
            {
                merged.add(a.get(i));
                i++;
            }
            else
            {
                merged.add(b.get(j));
                j++;
            }
        }

        while (i < a.size())
        {
            merged.add(a.get(i));
            i++;
        }

        while (j < b.size())
        {
            merged.add(b.get(j));
            j++;
        }

        return merged;
    }

    // Build BST from sorted array
    public MyNode sortedArrayToBST(List<Integer> arr, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;
        MyNode root = new MyNode(arr.get(mid));

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    // Print inorder to verify
    public void printInorder(MyNode root)
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
        _9MergeTwoBSTs obj = new _9MergeTwoBSTs();

        // First BST
        MyNode root1 = null;
        int[] bst1 = {10, 5, 1, 7, 40};
        for (int val : bst1)
        {
            root1 = obj.insert(root1, val);
        }

        // Second BST
        MyNode root2 = null;
        int[] bst2 = {15, 12, 20, 30};
        for (int val : bst2)
        {
            root2 = obj.insert(root2, val);
        }

        // Get inorder arrays
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        obj.inorder(root1, list1);
        obj.inorder(root2, list2);

        // Merge arrays
        List<Integer> merged = obj.mergeArrays(list1, list2);

        // Build final BST
        MyNode mergedRoot = obj.sortedArrayToBST(merged, 0, merged.size() - 1);

        // Print merged tree
        System.out.println("Inorder of merged BST:");
        obj.printInorder(mergedRoot);
    }
}

/*
Tree 1:        Tree 2:
    10             15
   /  \           /  \
  5   40        12   20
 / \                   \
1   7                 30

Merged Inorder:
1 5 7 10 12 15 20 30 40
*/
