package _6BinarySearchTree;

public class _6BSTValidator
{
    public boolean isValidBST(TreeNodes root)
    {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRecursive(TreeNodes node, long min, long max)
    {
        if (node == null)
        {
            return true;
        }

        if (node.value <= min || node.value >= max)
        {
            return false;
        }

        return isValidBSTRecursive(node.left, min, node.value) &&
                isValidBSTRecursive(node.right, node.value, max);
    }

    public static void main(String[] args)
    {
        _6BSTValidator validator = new _6BSTValidator();

        // Example: Valid BST
        //      4
        //     / \
        //    2   5
        //   / \
        //  1   3
        TreeNodes validRoot = new TreeNodes(4);
        validRoot.left = new TreeNodes(2);
        validRoot.right = new TreeNodes(5);
        validRoot.left.left = new TreeNodes(1);
        validRoot.left.right = new TreeNodes(3);

        System.out.print("Is this a valid BST? ");
        if (validator.isValidBST(validRoot))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }

        /*
         * Tree Diagram for Example:
         *
         * 4
         * / \
         * 2   5
         * / \
         * 1   3
         */
    }
}