package _6BinarySearchTree;

class BinarySearchTreeSearch
{
    public TreeNodes search(TreeNodes root, int key)
    {
        if (root == null)
        {
            return null;
        }

        if (root.value == key)
        {
            return root;
        }

        if (key < root.value)
        {
            return search(root.left, key);
        }

        return search(root.right, key);
    }
}

public class _2Search
{
    public TreeNodes insert(TreeNodes root, int key)
    {
        if (root == null)
        {
            return new TreeNodes(key);
        }

        if (key < root.value)
        {
            root.left = insert(root.left, key);
        }
        else if (key > root.value)
        {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static void main(String[] args)
    {
        _2Search tree = new _2Search();
        TreeNodes root = null;

        int[] keys =
                {
                        50, 30, 70, 20, 40, 60, 80
                };

        for (int i = 0; i < keys.length; i++)
        {
            root = tree.insert(root, keys[i]);
        }

        BinarySearchTreeSearch bstSearch = new BinarySearchTreeSearch();
        int keyToSearch = 60;
        TreeNodes result = bstSearch.search(root, keyToSearch);

        if (result != null)
        {
            System.out.println("Key " + keyToSearch + " found in the tree.");
        }
        else
        {
            System.out.println("Key " + keyToSearch + " not found in the tree.");
        }

        /*
         * Tree Diagram for the constructed BST with keys: {50, 30, 70, 20, 40, 60, 80}
         *
         * 50
         * /  \
         * 30   70
         * /  \  /  \
         * 20  40 60  80
         */
    }
}