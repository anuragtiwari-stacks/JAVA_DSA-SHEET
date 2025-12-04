package _6BinarySearchTree;

class TreeNodes
{
    int value;
    TreeNodes left, right, next;

    TreeNodes(int value)
    {
        this.value = value;
        left = right = next = null;
    }
}

public class _8InorderSuccessorPopulator
{
    TreeNodes root;
    static TreeNodes prev = null;

    // Insert method to build BST
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

    // Populate inorder successors
    public void populateNext(TreeNodes root)
    {
        prev = null;
        reverseInorder(root);
    }

    private void reverseInorder(TreeNodes node)
    {
        if (node == null)
        {
            return;
        }

        reverseInorder(node.right);

        if (prev != null)
        {
            node.next = prev;
        }
        else
        {
            node.next = null;
        }

        prev = node;

        reverseInorder(node.left);
    }

    // Print inorder traversal with next pointers
    public void printInorderWithNext(TreeNodes node)
    {
        if (node == null)
        {
            return;
        }

        printInorderWithNext(node.left);

        System.out.print(node.value + "->");
        if (node.next != null)
        {
            System.out.print(node.next.value);
        }
        else
        {
            System.out.print(-1);
        }
        System.out.print(" ");

        printInorderWithNext(node.right);
    }

    public static void main(String[] args)
    {
        _8InorderSuccessorPopulator tree = new _8InorderSuccessorPopulator();

        int[] values = {10, 8, 12, 3};

        for (int value : values)
        {
            tree.root = tree.insert(tree.root, value);
        }

        tree.populateNext(tree.root);

        System.out.println("Inorder successors:");
        tree.printInorderWithNext(tree.root);
    }
}

/*
Tree Structure:

        10
       /  \
      8    12
     /
    3

Inorder Traversal:       3 8 10 12
Inorder Successors:      3->8 8->10 10->12 12->-1
*/
