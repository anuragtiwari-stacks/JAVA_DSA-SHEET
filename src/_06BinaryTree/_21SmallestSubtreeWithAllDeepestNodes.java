package _06BinaryTree;

// LeetCode 865

import java.util.*;

public class _21SmallestSubtreeWithAllDeepestNodes
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
        }
    }

    public static void main(String[] args)
    {
        Integer[] arr={3,5,1,6,2,0,8,null,null,7,4};
        Node root=buildTree(arr,0);
        List<Node> last=getLastLevel(root);
        Node ans=last.get(0);
        for(int i=1;i<last.size();i++)
        {
            ans=lca(root,ans,last.get(i));
        }
        printSubtree(ans);
    }

    static Node buildTree(Integer[] arr,int i)
    {
        if(i>=arr.length || arr[i]==null)
        {
            return null;
        }
        Node root=new Node(arr[i]);
        root.left=buildTree(arr,2*i+1);
        root.right=buildTree(arr,2*i+2);
        return root;
    }

    static List<Node> getLastLevel(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        List<Node> last=new ArrayList<>();
        while(!q.isEmpty())
        {
            int size=q.size();
            last=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                Node n=q.poll();
                last.add(n);
                if(n.left!=null)
                {
                    q.add(n.left);
                }
                if(n.right!=null)
                {
                    q.add(n.right);
                }
            }
        }
        return last;
    }

    static Node lca(Node root,Node a,Node b)
    {
        if(root==null)
        {
            return null;
        }
        if(root==a || root==b)
        {
            return root;
        }
        Node left=lca(root.left,a,b);
        Node right=lca(root.right,a,b);
        if(left!=null && right!=null)
        {
            return root;
        }
        if(left!=null)
        {
            return left;
        }
        return right;
    }

    static void printSubtree(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node n=q.poll();
            System.out.print(n.data+" ");
            if(n.left!=null)
            {
                q.add(n.left);
            }
            if(n.right!=null)
            {
                q.add(n.right);
            }
        }
    }
}

/*
Tree Diagram (from input: [3,5,1,6,2,0,8,null,null,7,4])

                3
            /       \
           5         1
         /   \     /   \
        6     2   0     8
             / \
            7   4

Deepest Level Nodes = 7, 4

Dry Run:

arr = [3,5,1,6,2,0,8,null,null,7,4]

buildTree(...) constructs above tree

getLastLevel(root):
level1 -> 3
level2 -> 5,1
level3 -> 6,2,0,8
level4 -> 7,4     => last = [7,4]

ans = 7
i=1 -> ans = lca(root,7,4) = 2

printSubtree(2) -> prints: 2 7 4

Output:
2 7 4
*/
