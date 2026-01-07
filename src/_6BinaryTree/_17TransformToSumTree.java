package _6BinaryTree;

/*
QUESTION:
Transform the given binary tree into a Sum Tree.

Definition:
Each node contains the sum of values of its left and right subtrees
in the original tree.

- Original node value is NOT included
- Leaf nodes become 0

Example:
Input Tree:
        10
       /  \
      5    3

Output Sum Tree:
        8
       / \
      0   0
*/

public class _17TransformToSumTree
{
    // Binary Tree Node
    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args)
    {
        /*
                10
               /  \
              5    3
             / \
            2   1
        */

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);

        transformToSumTree(root);

        System.out.println("Inorder of Sum Tree:");
        inorder(root);
    }

    // Core Logic (Postorder Traversal)
    static int transformToSumTree(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftSum = transformToSumTree(root.left);
        int rightSum = transformToSumTree(root.right);

        int oldValue = root.data;

        root.data = leftSum + rightSum;

        return root.data + oldValue;
    }

    static void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

/*
==================== BEGINNER FRIENDLY DRY RUN ====================

Original Tree:
                10
               /  \
              5    3
             / \
            2   1

---------------------------------------------------------------
STEP 1:
Go to leftmost node (2)

Node 2:
leftSum = 0
rightSum = 0
root.data = 0
return 2

---------------------------------------------------------------
STEP 2:
Node 1:
leftSum = 0
rightSum = 0
root.data = 0
return 1

---------------------------------------------------------------
STEP 3:
Node 5:
leftSum = 2
rightSum = 1
root.data = 3
return 3 + 5 = 8

---------------------------------------------------------------
STEP 4:
Node 3:
leftSum = 0
rightSum = 0
root.data = 0
return 3

---------------------------------------------------------------
STEP 5:
Node 10:
leftSum = 8
rightSum = 3
root.data = 11
return 11 + 10 = 21

---------------------------------------------------------------
Final Sum Tree:
                11
               /  \
              3    0
             / \
            0   0

Inorder Traversal Output:
0 3 0 11 0

---------------------------------------------------------------
KEY POINTS:
- Postorder traversal is mandatory
- Leaf nodes become 0
- Function returns original subtree sum
- Time Complexity: O(n)
- Space Complexity: O(height of tree)

================================================================
*/
