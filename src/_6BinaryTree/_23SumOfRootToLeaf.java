package _6BinaryTree;

/*
LeetCode 1022
Sum of Root To Leaf Binary Numbers
*/

import java.util.*;

public class _23SumOfRootToLeaf
{

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public int sumRootToLeaf(TreeNode root)
    {
        List<String> list = new ArrayList<>();

        dfs(root, "", list);

        int sum = 0;

        for(String s : list)
        {
            sum = sum + Integer.parseInt(s, 2);
        }

        return sum;
    }

    public void dfs(TreeNode node, String path, List<String> list)
    {
        if(node == null)
        {
            return;
        }

        path = path + node.val;

        if(node.left == null && node.right == null)
        {
            list.add(path);
            return;
        }

        dfs(node.left, path, list);
        dfs(node.right, path, list);
    }

    public static void main(String[] args)
    {
        _23SumOfRootToLeaf sol = new _23SumOfRootToLeaf();

        /*
              1
             / \
            0   1
           / \   \
          0   1   1
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        int result = sol.sumRootToLeaf(root);

        System.out.println("Sum = " + result);
    }
}


/*
==================== DRY RUN ====================

Tree:

      1
     / \
    0   1
   / \   \
  0   1   1

Step 1:
dfs(1, "")

path = "1"

--------------------------------

Step 2:
Go Left → dfs(0, "1")

path = "10"

--------------------------------

Step 3:
Go Left → dfs(0, "10")

path = "100"

Leaf → add "100"

--------------------------------

Step 4:
Back → Go Right → dfs(1, "10")

path = "101"

Leaf → add "101"

--------------------------------

Step 5:
Back to root → Go Right → dfs(1, "1")

path = "11"

Go Right → dfs(1, "11")

path = "111"

Leaf → add "111"

--------------------------------

Binary List:

["100", "101", "111"]

Convert to Decimal:

100 → 4
101 → 5
111 → 7

Total Sum:

4 + 5 + 7 = 16

==================================================
*/