package _6BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class _6
{
    public void inorderTraversal(TreeNodes node, List<Integer> list)
    {
        if (node == null)
        {
            return;
        }
        inorderTraversal(node.left, list);
        list.add(node.value);
        inorderTraversal(node.right, list);
    }

    public boolean isValidBST(TreeNodes root)
    {
        if (root == null)
        {
            return true;
        }

        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        for (int i = 0; i < inorderList.size() - 1; i++)
        {
            if (inorderList.get(i) >= inorderList.get(i + 1))
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        _6 validator = new _6();

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