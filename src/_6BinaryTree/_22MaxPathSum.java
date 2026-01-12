package _6BinaryTree;

public class _22MaxPathSum
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

    int maxSum;

    public int solve(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int neeche_hi_milgaya_answer = l + r + root.val;
        int koi_ek_acha = Math.max(l, r) + root.val;
        int only_root_acha = root.val;

        maxSum = Math.max(maxSum, Math.max(neeche_hi_milgaya_answer, Math.max(koi_ek_acha, only_root_acha)));

        return Math.max(koi_ek_acha, only_root_acha);
    }

    public int maxPathSum(TreeNode root)
    {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public static void main(String[] args)
    {
        _22MaxPathSum obj = new _22MaxPathSum();

        /*
                Tree:
                      -10
                      /  \
                     9    20
                         /  \
                        15   7
         */

        TreeNode a = new TreeNode(-10);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        int result = obj.maxPathSum(a);
        System.out.println("Max Path Sum = " + result);
    }
}

/*
===============================
DRY RUN (For sample tree above)
===============================

Tree:
         -10
         /  \
        9    20
            /  \
           15   7

At Node 15:
l = 0, r = 0
neeche_hi_milgaya = 15
koi_ek_acha = 15
only_root = 15
maxSum = 15
return 15

At Node 7:
l = 0, r = 0
neeche_hi_milgaya = 7
koi_ek_acha = 7
only_root = 7
maxSum = 15
return 7

At Node 20:
l = 15, r = 7
neeche_hi_milgaya = 15 + 7 + 20 = 42
koi_ek_acha = max(15,7) + 20 = 35
only_root = 20
maxSum = max(15,42,35,20) = 42
return koi_ek_acha = 35

At Node 9:
l = 0, r = 0
neeche_hi_milgaya = 9
koi_ek_acha = 9
only_root = 9
maxSum = 42
return 9

At Node -10:
l = 9, r = 35
neeche_hi_milgaya = 9 + 35 + (-10) = 34
koi_ek_acha = max(9,35) + (-10) = 25
only_root = -10
maxSum = max(42,34,25,-10) = 42
return 25

-------------------------------
FINAL ANSWER:
Max Path Sum = 42
-------------------------------
Time Complexity: O(n)
Space Complexity: O(h)
*/
