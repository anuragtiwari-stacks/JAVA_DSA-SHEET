package _5BinaryTree;

public class _6TransformToSumTree
{
    // Binary Tree Node class
    static class Node
    {
        int val;
        Node left, right;

        Node(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Function to convert the tree to a sum tree
    public static int toSumTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int oldValue = node.val;

        int leftSum = toSumTree(node.left);   // convert left subtree
        int rightSum = toSumTree(node.right); // convert right subtree

        node.val = leftSum + rightSum;  // set current node value to sum of left and right

        return node.val + oldValue;     // return sum including old value for parent's calculation
    }

    // Utility function for in-order traversal
    public static void printInOrder(Node root)
    {
        if (root == null)
        {
            return;
        }

        printInOrder(root.left);            // visit left
        System.out.print(root.val + " ");   // print node
        printInOrder(root.right);           // visit right
    }

    public static void main(String[] args)
    {
        // Build the tree
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        // Transform to sum tree
        toSumTree(root);

        System.out.print("In-order traversal of Sum Tree: ");
        printInOrder(root);
    }

}

/*
Concept:
Convert binary tree to sum tree.
Each node becomes the sum of values of its left and right subtrees.
Leaf nodes become 0.

Original Tree:
        10
       /  \
     -2    6
     / \   / \
    8  -4 7   5

Sum Tree:
        20
       /  \
      4    12
     / \   / \
    0   0 0   0
*/
