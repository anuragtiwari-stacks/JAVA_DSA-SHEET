package _5BinaryTree;

public class _8SameTree
{
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

    public static boolean isSameTree(Node p, Node q)
    {
        // Both nodes are null -> trees are the same
        if (p == null && q == null)
        {
            return true;
        }

        // One node is null -> trees are different
        if (p == null || q == null)
        {
            return false;
        }

        // Values must match, and left and right subtrees must be the same
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args)
    {
        // Example 1: Same trees
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);

        Node t2 = new Node(1);
        t2.left = new Node(2);
        t2.right = new Node(3);

        System.out.println("Example 1: Are trees the same? " + isSameTree(t1, t2)); // true

        // Example 2: Different structure
        Node t3 = new Node(1);
        t3.left = new Node(2);

        Node t4 = new Node(1);
        t4.right = new Node(2);

        System.out.println("Example 2: Are trees the same? " + isSameTree(t3, t4)); // false
    }
}

/*
Concept:
Two binary trees are the same if they are structurally identical and
each node has the same value.

Example 1:
Tree A:        Tree B:
    1              1
   / \            / \
  2   3          2   3

Output: true

Example 2:
Tree A:        Tree B:
    1              1
   /                \
  2                  2

Output: false
*/
