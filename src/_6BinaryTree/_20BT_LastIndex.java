package _6BinaryTree;

public class _20BT_LastIndex
{

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args)
    {

        /*
                    0
                  /   \
                 1     3
                  \
                   2
        */

        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(3);
        root.left.right = new Node(2);

        int maxIndex = findMaxIndex(root, 0);

        int[] arr = new int[maxIndex + 1];

        for(int i = 0; i <= maxIndex; i++)
        {
            arr[i] = -1;
        }

        fillArray(root, arr, 0);

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == -1)
            {
                System.out.print("null ");
            }
            else
            {
                System.out.print(arr[i] + " ");
            }
        }
    }

    static int findMaxIndex(Node node, int index)
    {
        if(node == null)
        {
            return -1;
        }

        int left = findMaxIndex(node.left, 2 * index + 1);
        int right = findMaxIndex(node.right, 2 * index + 2);

        return Math.max(index, Math.max(left, right));
    }

    static void fillArray(Node node, int[] arr, int index)
    {
        if(node == null || index >= arr.length)
        {
            return;
        }

        arr[index] = node.data;

        fillArray(node.left, arr, 2 * index + 1);
        fillArray(node.right, arr, 2 * index + 2);
    }

}
