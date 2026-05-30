package _06BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
QUESTION:
Check whether all leaf nodes of a binary tree
are present at the same level or not.

Use QUEUE (Level Order Traversal).
*/

public class _1LeavesAtSameLevelQueueFailCase
{
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
                1
               / \
              2   3
             /
            4

        Leaves:
        4 → level 2
        3 → level 1

        NOT at same level → false
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        boolean ans = checkLeavesSameLevel(root);

        System.out.println(ans);   // expected output: false
    }

    static boolean checkLeavesSameLevel(Node root)
    {
        if (root == null)
        {
            return true;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);   // STEP 1: root insert

        int level = 0;
        int leafLevel = -1;

        while (!q.isEmpty())
        {
            int size = q.size();   // nodes at current level

            for (int i = 0; i < size; i++)
            {
                Node curr = q.poll();   // STEP 2: remove element

                // STEP 3: check leaf
                if (curr.left == null && curr.right == null)
                {
                    if (leafLevel == -1)
                    {
                        leafLevel = level;   // first leaf level set
                    }
                    else if (leafLevel != level)
                    {
                        return false;   // NOT OK (logic matched)
                    }
                }

                // STEP 4: add children if possible
                if (curr.left != null)
                {
                    q.add(curr.left);
                }

                if (curr.right != null)
                {
                    q.add(curr.right);
                }
            }

            level++;   // move to next level
        }

        return true;   // OK
    }
}

/*
==================== SIMPLE DRY RUN ====================

Tree:
        1
       / \
      2   3
     /
    4

------------------------------------------------------------------
STEP 1:
Queue = [1]
level = 0
leafLevel = -1

1 is NOT leaf
Add 2, 3

------------------------------------------------------------------
STEP 2:
Queue = [2, 3]
level = 1

Node 2 → not leaf → add 4
Node 3 → LEAF

leafLevel = 1 (first leaf found)

------------------------------------------------------------------
STEP 3:
Queue = [4]
level = 2

Node 4 → LEAF
Compare:
leafLevel = 1
current level = 2

Mismatch ❌
RETURN false

------------------------------------------------------------------
FINAL OUTPUT:
false

------------------------------------------------------------------
KEY IDEA (TUMHARI LANGUAGE):
- Root queue me daala
- Ek-ek karke remove kiya
- Leaf ka level note kiya
- Ek bhi leaf alag level pe mila → NOT OK

==================================================================
*/
