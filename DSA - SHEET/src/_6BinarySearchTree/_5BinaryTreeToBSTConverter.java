package _6BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _5BinaryTreeToBSTConverter
{
    // Step 1: Perform inorder traversal to store elements in a list
    public void inorderTraversal(TreeNodes node, List<Integer> list)
    {
        if (node == null)
        {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.value);
        inorderTraversal(node.right, list);
    }

    // Step 3: Construct BST from the sorted list
    public TreeNodes sortedListToBST(List<Integer> list, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNodes node = new TreeNodes(list.get(mid));

        node.left = sortedListToBST(list, start, mid - 1);
        node.right = sortedListToBST(list, mid + 1, end);

        return node;
    }

    // Orchestration method to convert Binary Tree to BST
    public TreeNodes convert(TreeNodes root)
    {
        if (root == null)
        {
            return null;
        }

        List<Integer> nodeValues = new ArrayList<>();
        inorderTraversal(root, nodeValues); // Get all node values

        Collections.sort(nodeValues); // Step 2: Sort the array (list)

        return sortedListToBST(nodeValues, 0, nodeValues.size() - 1); // Construct BST
    }

    // Helper method to print inorder traversal of a tree (for verification)
    public void printInorder(TreeNodes node)
    {
        if (node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

    public static void main(String[] args)
    {
        _5BinaryTreeToBSTConverter converter = new _5BinaryTreeToBSTConverter();

        // Example Binary Tree (not a BST initially)
        //       10
        //      /  \
        //     2    7
        //    / \
        //   8   4
        TreeNodes root = new TreeNodes(10);
        root.left = new TreeNodes(2);
        root.right = new TreeNodes(7);
        root.left.left = new TreeNodes(8);
        root.left.right = new TreeNodes(4);

        System.out.print("Inorder traversal of original Binary Tree: ");
        converter.printInorder(root);
        System.out.println();

        TreeNodes bstRoot = converter.convert(root);

        System.out.print("Inorder traversal of converted BST: ");
        converter.printInorder(bstRoot);
        System.out.println();

        /*
         * Tree Diagram for Example 1 (Original Binary Tree):
         *
         * 10
         * /  \
         * 2    7
         * / \
         * 8   4
         *
         * Sorted values after inorder traversal: {2, 4, 7, 8, 10}
         *
         * Converted BST:
         *
         * 7
         * / \
         * 4   10
         * /   /
         * 2   8
         */
    }
}