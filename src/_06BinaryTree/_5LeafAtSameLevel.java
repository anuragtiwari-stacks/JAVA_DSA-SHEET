package _06BinaryTree;

import java.util.*;

public class _5LeafAtSameLevel
{
    // Binary Tree Node class
    static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to check if all leaf nodes are at the same level
    public static boolean checkLeavesAtSameLevel(Node root)
    {
        List<Integer> leafLevels = new ArrayList<>();  // to store levels of leaf nodes
        dfs(root, 0, leafLevels);  // start DFS from root at level 0

        int expected = leafLevels.get(0);  // all leaves should match this level

        for (int level : leafLevels)
        {
            if (level != expected)
            {
                return false;  // if any leaf is at a different level, return false
            }
        }

        return true;  // all leaves at same level
    }

    // DFS helper to collect levels of all leaf nodes
    private static void dfs(Node node, int level, List<Integer> leafLevels)
    {
        if (node == null)
        {
            return;
        }

        if (node.left == null && node.right == null)
        {
            leafLevels.add(level);  // found a leaf, store its level
        }

        dfs(node.left, level + 1, leafLevels);  // go left
        dfs(node.right, level + 1, leafLevels); // go right
    }

    public static void main(String[] args)
    {
        // Constructing tree manually
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        // Check if all leaf nodes are at same level
        boolean result = checkLeavesAtSameLevel(root);
        System.out.println("All leaf nodes at same level: " + result);
    }

}

/*
Concept:
Use DFS to collect all leaf levels in a list.
Then check if all values in the list are the same.

Tree used:
        1
       / \
      2   3
     /     \
    4       5

Leaves (4 and 5) are at level 2 → returns true
*/
