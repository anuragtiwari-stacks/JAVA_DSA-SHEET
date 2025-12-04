package _6BinarySearchTree;

class Node
{
    int value;
    TreeNodes left, right;

    public Node(int value)
    {
        this.value = value;
        left = right = null;
    }
}

class LowestCommonAncestorBST
{
    public TreeNodes lowestCommonAncestor(TreeNodes root, TreeNodes p, TreeNodes q)
    {
        while (root != null)
        {
            if (p.value < root.value && q.value < root.value)
            {
                root = root.left;
            }
            else if (p.value > root.value && q.value > root.value)
            {
                root = root.right;
            }
            else
            {
                return root;
            }
        }
        return null;
    }
}

public class _1LowestCommonAncestor
{
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

    public static void main(String[] args)
    {
        _1LowestCommonAncestor tree = new _1LowestCommonAncestor();
        TreeNodes root = null;

        int[] values = {6, 2, 8, 0, 4, 7, 9, 3, 5};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        TreeNodes p = root.left;           // Node with value 2
        TreeNodes q = root.right;          // Node with value 8

        LowestCommonAncestorBST lcaFinder = new LowestCommonAncestorBST();
        TreeNodes lca = lcaFinder.lowestCommonAncestor(root, p, q);

        if (lca != null)
        {
            System.out.println("LCA of " + p.value + " and " + q.value + " is: " + lca.value);
        }
        else
        {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }
}

/*

          6
        /   \
       2     8
      / \   / \
     0   4 7   9
        / \
       3   5

*/
