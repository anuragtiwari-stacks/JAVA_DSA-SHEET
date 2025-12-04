package _6BinarySearchTree;

public class _7CountNodesInRange
{
    TreeNodes root;

    // Insert a node into the BST
    public TreeNodes insert(TreeNodes root, int value)
    {
        if (root == null)
        {
            root = new TreeNodes(value);
            return root;
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

    // Count nodes within a given range
    public int countInRange(TreeNodes root, int low, int high)
    {
        if (root == null)
        {
            return 0;
        }

        if (root.value >= low && root.value <= high)
        {
            return 1 + countInRange(root.left, low, high) + countInRange(root.right, low, high);
        }
        else if (root.value < low)
        {
            return countInRange(root.right, low, high);
        }
        else // root.value > high
        {
            return countInRange(root.left, low, high);
        }
    }

    // In-order traversal to print the BST
    public void inorder(TreeNodes root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args)
    {
        _7CountNodesInRange tree = new _7CountNodesInRange();

        int[] values = {10, 5, 50, 1, 40, 100};

        for (int val : values)
        {
            tree.root = tree.insert(tree.root, val);
        }

        int low = 5, high = 45;
        int count = tree.countInRange(tree.root, low, high);

        System.out.println("In-order Traversal of BST:");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Count of nodes in range [" + low + ", " + high + "] is: " + count);
    }
}

/*
BST Structure:

          10
         /  \
        5    50
       /     / \
      1     40 100

Nodes in range [5, 45]: 5, 10, 40
Count: 4
*/
