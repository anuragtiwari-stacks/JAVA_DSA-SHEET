package _07BinarySearchTree;

public class _4DeadEndInBST
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    public boolean isDeadEnd(Node root)
    {
        return check(root, 1, Integer.MAX_VALUE);
    }

    public boolean check(Node root, int min, int max)
    {
        if (root == null)
        {
            return false;
        }

        if (min == max)
        {
            return true;
        }

        return check(root.left, min, root.value - 1)
                || check(root.right, root.value + 1, max);
    }

    public static void main(String[] args)
    {
        _4DeadEndInBST tree = new _4DeadEndInBST();

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.left.left.right = new Node(3);

        boolean ans = tree.isDeadEnd(root);
        System.out.println("Dead End Present: " + ans);
    }
}

/*
BST:

            8
           / \
          5   11
         / \
        2   7
         \
          3

Start range: (1, ∞)

Node 8 → range (1, ∞)
Left → (1, 7)
Right → (9, ∞)

Node 5 → range (1, 7)
Left → (1, 4)
Right → (6, 7)

Node 2 → range (1, 4)
Right → (3, 4)

Node 3 → range (3, 3)
min == max → DEAD END FOUND

Output:
Dead End Present: true
*/
