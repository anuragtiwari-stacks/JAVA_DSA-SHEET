package _6BinarySearchTree;

public class _13LargestBST
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

    public static boolean isValid(Node node, int min, int max)
    {
        if (node == null)
        {
            return true;
        }

        if (node.value <= min || node.value >= max)
        {
            return false;
        }

        boolean leftValid = isValid(node.left, min, node.value);
        boolean rightValid = isValid(node.right, node.value, max);

        return leftValid && rightValid;
    }

    public static int size(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return 1 + leftSize + rightSize;
    }

    public static int largestBST(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        {
            return size(root);
        }

        int leftLargest = largestBST(root.left);
        int rightLargest = largestBST(root.right);

        if (leftLargest > rightLargest)
        {
            return leftLargest;
        }
        else
        {
            return rightLargest;
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        int result = largestBST(root);

        System.out.println("Size of largest BST is: " + result);
    }
}
