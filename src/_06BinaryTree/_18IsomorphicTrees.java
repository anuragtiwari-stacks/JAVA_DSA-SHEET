package _06BinaryTree;

/*
QUESTION:
Two binary trees are said to be ISOMORPHIC if one tree
can be transformed into the other by swapping left and
right children of some nodes.

The data at corresponding nodes must be same.
*/

public class _18IsomorphicTrees
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
        Tree 1:              Tree 2:
              1                   1
             / \                 / \
            2   3               3   2
           /                     \
          4                       4

        These two trees are ISOMORPHIC
        (swap children of root)
        */

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(3);
        root2.right = new Node(2);
        root2.right.right = new Node(4);

        boolean ans = isIsomorphic(root1, root2);

        System.out.println(ans);   // expected output: true
    }

    static boolean isIsomorphic(Node root1, Node root2)
    {
        // Both null → isomorphic
        if (root1 == null && root2 == null)
        {
            return true;
        }

        // One null, one not → not isomorphic
        if (root1 == null || root2 == null)
        {
            return false;
        }

        // Data mismatch → not isomorphic
        if (root1.data != root2.data)
        {
            return false;
        }

        // Case 1: No swap
        boolean noSwap =
                isIsomorphic(root1.left, root2.left)
                        && isIsomorphic(root1.right, root2.right);

        // Case 2: Swap children
        boolean swap =
                isIsomorphic(root1.left, root2.right)
                        && isIsomorphic(root1.right, root2.left);

        return noSwap || swap;
    }
}

/*
==================== BEGINNER FRIENDLY DRY RUN ====================

Tree 1:              Tree 2:
      1                   1
     / \                 / \
    2   3               3   2
   /                     \
  4                       4

------------------------------------------------------------------
STEP 1:
isIsomorphic(1, 1)
data same → check children

------------------------------------------------------------------
STEP 2:
NO SWAP case:
compare (2,3) and (3,2)
data mismatch → false

------------------------------------------------------------------
STEP 3:
SWAP case:
compare (2,2) and (3,3)

------------------------------------------------------------------
STEP 4:
isIsomorphic(2,2)
data same

Check children:
left(4,null) & right(null,4)

Again SWAP works:
4 matches with 4 → true

------------------------------------------------------------------
STEP 5:
isIsomorphic(3,3)
Both leaf nodes → true

------------------------------------------------------------------
FINAL RESULT:
true (Trees are Isomorphic)

------------------------------------------------------------------
IMPORTANT POINTS:
- Left–Right swap is allowed
- At every node, check TWO cases:
  1) Without swap
  2) With swap
- If any one case is true → trees are isomorphic
- Time Complexity: O(n)
- Space Complexity: O(height of tree)

==================================================================
*/
