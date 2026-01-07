package _6BinaryTree;

public class _4MirrorBinaryTree
{
    // 📌 Node class defined inside the same file
    static class Node
    {
        int val;
        Node left;
        Node right;

        Node(int val)
        {
            this.val = val;
        }
    }

    // 🔁 Mirror the binary tree
    public Node mirror(Node root)
    {
        if (root == null)
        {
            return null;
        }

        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // ➕ Insert node into BST
    public Node insert(Node root, int val)
    {
        if (root == null)
        {
            return new Node(val);
        }

        if (val < root.val)
        {
            root.left = insert(root.left, val);
        }
        else
        {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // 🌿 Inorder traversal
    public void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args)
    {
        _4MirrorBinaryTree tree = new _4MirrorBinaryTree();

        Node root = null;

        // 🔨 Inserting nodes to form BST
        root = tree.insert(root, 5);
        root = tree.insert(root, 3);
        root = tree.insert(root, 6);
        root = tree.insert(root, 2);
        root = tree.insert(root, 4);

        /*
            Original BST:

                  5
                 / \
                3   6
               / \
              2   4

            Inorder (LNR): 2 3 4 5 6

            Mirror Tree:

                  5
                 / \
                6   3
                   / \
                  4   2

            Inorder of Mirror (LNR): 6 5 4 3 2
        */

        System.out.print("Inorder of original tree: ");
        tree.inorder(root);
        System.out.println();

        tree.mirror(root); // 🔁 Mirror operation

        System.out.print("Inorder of mirror tree: ");
        tree.inorder(root);
    }
}
