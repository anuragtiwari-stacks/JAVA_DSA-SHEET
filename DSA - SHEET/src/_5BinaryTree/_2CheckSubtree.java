package _5BinaryTree;

public class _2CheckSubtree
{
    // Inner Node class
    static class Node
    {
        int val;
        Node left;
        Node right;

        Node(int x)
        {
            val = x;
        }
    }

    public StringBuilder inorderTraversal(Node node, StringBuilder sb)
    {
        if (node == null)
        {
            sb.append("N ");
            return sb;
        }

        inorderTraversal(node.left, sb);
        sb.append(node.val).append(" ");
        inorderTraversal(node.right, sb);

        return sb;
    }

    public boolean isSubtree(Node root, Node subRoot)
    {
        StringBuilder inorderRoot = new StringBuilder();
        StringBuilder inorderSubRoot = new StringBuilder();

        inorderTraversal(root, inorderRoot);
        inorderTraversal(subRoot, inorderSubRoot);

        return inorderRoot.toString().contains(inorderSubRoot.toString());
    }

    public static void main(String[] args)
    {
        // Constructing main tree (root)
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        // Constructing subtree (subRoot)
        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        _2CheckSubtree obj = new _2CheckSubtree();
        boolean result = obj.isSubtree(root, subRoot);

        System.out.println("Is subRoot a subtree of root? " + result);
    }

    /*
     Tree:               Subtree:

         3                   4
        / \                 / \
       4   5               1   2
      / \
     1   2

     Inorder of root:    1 4 2 3 5
     Inorder of subRoot: 1 4 2

     Output: true
    */
}
