package _6BinarySearchTree;

public class _3PredecessorSuccessor
{
    public static TreeNodes pre;
    public static TreeNodes suc;

    public static void findPreSuc(TreeNodes root, int key)
    {
        pre = null;
        suc = null;
        TreeNodes current = root;

        while (current != null)
        {
            if (key < current.value)
            {
                suc = current;
                current = current.left;
            }
            else if (key > current.value)
            {
                pre = current;
                current = current.right;
            }
            else
            {
                if (current.left != null)
                {
                    TreeNodes temp = current.left;
                    while (temp.right != null)
                    {
                        temp = temp.right;
                    }
                    pre = temp;
                }

                if (current.right != null)
                {
                    TreeNodes temp = current.right;
                    while (temp.left != null)
                    {
                        temp = temp.left;
                    }
                    suc = temp;
                }
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        TreeNodes root = new TreeNodes(8);
        root.left = new TreeNodes(1);
        root.right = new TreeNodes(9);
        root.left.right = new TreeNodes(4);
        root.left.right.left = new TreeNodes(3);
        root.right.right = new TreeNodes(10);

        int keyToFind = 8;
        findPreSuc(root, keyToFind);

        System.out.print("For key = " + keyToFind + ":");
        System.out.print("Predecessor: ");
        if (pre != null)
        {
            System.out.println(pre.value);
        }
        else
        {
            System.out.println("-1");
        }

        System.out.print("Successor: ");
        if (suc != null)
        {
            System.out.println(suc.value);
        }
        else
        {
            System.out.println("-1");
        }

        TreeNodes root2 = new TreeNodes(10);
        root2.left = new TreeNodes(2);
        root2.right = new TreeNodes(11);
        root2.left.left = new TreeNodes(1);
        root2.left.right = new TreeNodes(5);
        root2.left.right.left = new TreeNodes(3);
        root2.left.right.right = new TreeNodes(6);
        root2.left.right.left.right = new TreeNodes(4);

        keyToFind = 11;
        findPreSuc(root2, keyToFind);

        System.out.print("For key = " + keyToFind + ":");
        System.out.print("Predecessor: ");
        if (pre != null)
        {
            System.out.println(pre.value);
        }
        else
        {
            System.out.println("-1");
        }

        System.out.print("Successor: ");
        if (suc != null)
        {
            System.out.println(suc.value);
        }
        else
        {
            System.out.println("-1");
        }

        TreeNodes root3 = new TreeNodes(2);
        root3.left = new TreeNodes(1);
        root3.right = new TreeNodes(3);

        keyToFind = 3;
        findPreSuc(root3, keyToFind);

        System.out.print("For key = " + keyToFind + ":");
        System.out.print("Predecessor: ");
        if (pre != null)
        {
            System.out.println(pre.value);
        }
        else
        {
            System.out.println("-1");
        }

        System.out.print("Successor: ");
        if (suc != null)
        {
            System.out.println(suc.value);
        }
        else
        {
            System.out.println("-1");
        }

        /*
         * Tree Diagram for the first example (keys: 8, 1, 9, 4, 10, 3)
         *
         * 8
         * / \
         * 1   9
         * \   \
         * 4   10
         * /
         * 3
         */
    }
}