package _6BinaryTree;

import java.util.*;

/*
🧱 Working Steps:

1. Start with two stacks:
   - s1: for the current level
   - s2: for the next level

2. Push the root into s1

3. Use a variable direction (0 = left to right, 1 = right to left)

4. While s1 is not empty:
   - Pop nodes from s1
   - Print or store their values

   - Depending on direction:
     - If direction == 0 (left to right): push left child first, then right child into s2
     - If direction == 1 (right to left): push right child first, then left child into s2

5. Once s1 is empty:
   - All nodes of the current level are processed
   - Swap s1 and s2 using a temporary variable
   - Toggle direction (0 ↔ 1)

6. Repeat until both stacks are empty.
 */

public class _3ZigZagTraversal_UsingStacks
{
    // Node class defined inside
    static class Node
    {
        int val;
        Node left;
        Node right;

        Node(int x)
        {
            val = x;
        }
    }

    public List<Integer> zigzagTraversal(Node root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
        {
            return result;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);
        int direction = 0; // 0 = left to right, 1 = right to left

        while (!s1.isEmpty())
        {
            Node node = s1.pop();
            result.add(node.val);

            if (direction == 0)
            {
                if (node.left != null)
                {
                    s2.push(node.left);
                }
                if (node.right != null)
                {
                    s2.push(node.right);
                }
            }
            else
            {
                if (node.right != null)
                {
                    s2.push(node.right);
                }
                if (node.left != null)
                {
                    s2.push(node.left);
                }
            }

            if (s1.isEmpty())
            {
                Stack<Node> temp = s1;
                s1 = s2;
                s2 = temp;
                direction = 1 - direction;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        /*
             1
           /   \
          2     3
         / \   / \
        4  5  6  7

        Expected Zigzag Output: [1, 3, 2, 4, 5, 6, 7]
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        _3ZigZagTraversal_UsingStacks obj = new _3ZigZagTraversal_UsingStacks();
        List<Integer> result = obj.zigzagTraversal(root);

        System.out.println("Zigzag Traversal using direction flag: " + result);
    }

    /*
    ▶️ Initial Setup:
    Stack s1 = [1]
    Stack s2 = []
    direction = 0
    result = []

    🔄 Level 1 (Left to Right)
    Pop 1 from s1, add to result → result = [1]
    Since direction == 0, push:
    1.left (2) to s2 → s2 = [2]
    1.right (3) to s2 → s2 = [2, 3]
    s1 is now empty → swap s1 and s2, toggle direction = 1

    🔄 Level 2 (Right to Left)
    s1 = [2, 3]
    s2 = []
    direction = 1
    Pop 3, add to result → result = [1, 3]
    Push 3.right (7) → s2 = [7]
    Push 3.left (6) → s2 = [7, 6]
    Pop 2, add to result → result = [1, 3, 2]
    Push 2.right (5) → s2 = [7, 6, 5]
    Push 2.left (4) → s2 = [7, 6, 5, 4]
    s1 is empty → swap s1 and s2, toggle direction = 0

    🔄 Level 3 (Left to Right)
    s1 = [7, 6, 5, 4]
    direction = 0
    Pop 4, add to result → result = [1, 3, 2, 4]
    Pop 5, add → result = [1, 3, 2, 4, 5]
    Pop 6, add → result = [1, 3, 2, 4, 5, 6]
    Pop 7, add → result = [1, 3, 2, 4, 5, 6, 7]
     */
}
