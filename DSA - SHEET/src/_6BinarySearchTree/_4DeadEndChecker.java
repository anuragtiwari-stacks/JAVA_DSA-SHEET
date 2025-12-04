package _6BinarySearchTree;

import java.util.HashSet;

public class _4DeadEndChecker
{
    TreeNodes root;

    // Insert a value into the BST
    public TreeNodes insert(TreeNodes root, int value)
    {
        if (root == null)
        {
            return new TreeNodes(value);
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

    // Collect all node values in a HashSet
    public void collectNodes(TreeNodes root, HashSet<Integer> set)
    {
        if (root == null)
        {
            return;
        }

        set.add(root.value);
        collectNodes(root.left, set);
        collectNodes(root.right, set);
    }

    // Check if a dead end exists
    public boolean hasDeadEnd(TreeNodes root)
    {
        HashSet<Integer> set = new HashSet<>();
        collectNodes(root, set);
        return checkDeadEnd(root, set);
    }

    private boolean checkDeadEnd(TreeNodes node, HashSet<Integer> set)
    {
        if (node == null)
        {
            return false;
        }

        if (node.left == null && node.right == null)
        {
            boolean leftBlocked = set.contains(node.value - 1) || (node.value - 1 == 0);
            boolean rightBlocked = set.contains(node.value + 1);

            return leftBlocked && rightBlocked;
        }

        return checkDeadEnd(node.left, set) || checkDeadEnd(node.right, set);
    }

    public static void main(String[] args)
    {
        _4DeadEndChecker tree1 = new _4DeadEndChecker();
        int[] values1 = {8, 7, 10, 2, 9, 13};
        for (int val : values1)
        {
            tree1.root = tree1.insert(tree1.root, val);
        }

        System.out.print("Does BST 1 have a dead end? ");
        System.out.println(tree1.hasDeadEnd(tree1.root) ? "Yes" : "No");

        _4DeadEndChecker tree2 = new _4DeadEndChecker();
        int[] values2 = {5, 4, 12, 3, 10, 13};
        for (int val : values2)
        {
            tree2.root = tree2.insert(tree2.root, val);
        }

        System.out.print("Does BST 2 have a dead end? ");
        System.out.println(tree2.hasDeadEnd(tree2.root) ? "Yes" : "No");

        /*
         * Tree Diagram for BST 1 (Dead End):
         *
         *        8
         *       / \
         *      7   10
         *     /   /  \
         *    2   9    13
         */
    }
}
