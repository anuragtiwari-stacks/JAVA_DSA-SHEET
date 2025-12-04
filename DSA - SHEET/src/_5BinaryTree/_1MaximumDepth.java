package _5BinaryTree;

// ❌ No import for Node

public class _1MaximumDepth {

    // Inner Node class
    static class Node {
        int val;
        Node left, right;

        Node(int x) {
            val = x;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        _1MaximumDepth tree = new _1MaximumDepth();
        System.out.println("Maximum depth: " + tree.maxDepth(root));  // Output: 3
    }
}
