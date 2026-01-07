package _6BinaryTree;

public class _7CheckIsomorphicTrees
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

    // Function to check if two trees are isomorphic
    public static boolean isIsomorphic(Node n1, Node n2)
    {
        if (n1 == null && n2 == null)
        {
            return true;  // both null → isomorphic
        }

        if (n1 == null || n2 == null)
        {
            return false; // one null, one not → not isomorphic
        }

        if (n1.val != n2.val)
        {
            return false; // values mismatch → not isomorphic
        }

        // Check if children are isomorphic
        boolean a = isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right);  // no swap
        boolean b = isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left);  // swap

        return a || b;
    }

    public static void main(String[] args)
    {
        // Example 1: Output: false
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);

        Node t2 = new Node(1);
        t2.left = new Node(3);
        t2.right = new Node(2);
        t2.left.left = new Node(4);

        System.out.println("Example 1: Isomorphic? " + isIsomorphic(t1, t2)); // false

        // Example 2: Output: true
        Node x1 = new Node(1);
        x1.left = new Node(2);
        x1.right = new Node(3);
        x1.left.left = new Node(4);

        Node x2 = new Node(1);
        x2.left = new Node(3);
        x2.right = new Node(2);
        x2.right.right = new Node(4);

        System.out.println("Example 2: Isomorphic? " + isIsomorphic(x1, x2)); // true
    }

}

/*
Concept:
Two trees are isomorphic if they are structurally the same
OR can become same by swapping left and right children at any number of nodes.

Input 1:
T1:        1        T2:        1
          / \                /   \
         2   3             3     2
        /                       /
       4                       4
Output: false

Input 2:
T1:        1        T2:        1
          / \                /   \
         2   3             3     2
        /                          \
       4                            4
Output: true
*/
