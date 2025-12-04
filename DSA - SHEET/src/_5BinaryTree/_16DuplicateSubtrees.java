package _5BinaryTree;

public class _16DuplicateSubtrees {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    // Check if two trees are identical
    public static boolean isSameTree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    // Count nodes in a subtree
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Check if subtree rooted at n1 has duplicate subtree elsewhere starting from root
    public static boolean checkDuplicate(Node root, Node n1) {
        if (root == null) {
            return false;
        }

        // Different node but identical subtree of size >= 2
        if (root != n1 && isSameTree(root, n1) && countNodes(root) >= 2) {
            return true;
        }

        return checkDuplicate(root.left, n1) || checkDuplicate(root.right, n1);
    }

    // Traverse tree and check duplicate for every subtree
    public static boolean hasDuplicateSubtree(Node root) {
        if (root == null) {
            return false;
        }

        // Check if duplicate subtree for current subtree exists
        if (checkDuplicate(root, root)) {
            return true;
        }

        // Check recursively for left and right subtree
        return hasDuplicateSubtree(root.left) || hasDuplicateSubtree(root.right);
    }

    public static void main(String[] args) {
        /*
        Input Tree:

               1
             /   \
           2       3
         /   \       \
        4     5       2
                     /  \
                    4    5

        Duplicate subtree: 2->(4,5) appears twice.
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.right = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(5);

        boolean result = hasDuplicateSubtree(root);

        System.out.println("Has Duplicate Subtrees? " + result);  // Output: true
    }

}

/*
Concept:
--------
- For each subtree rooted at a node, compare it with every other subtree.
- If any identical subtree of size >= 2 is found, return true.
- This approach is simple but inefficient (high time complexity).
*/
