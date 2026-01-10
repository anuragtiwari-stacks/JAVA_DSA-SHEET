package _6BinaryTree;

// Maximum Product of Splitted Binary Tree
public class _19MaxProductSplitBinaryTree
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    long SUM = 0;     // total sum of tree
    long maxP = 0;    // maximum product

    // Step 1: Calculate total sum of tree
    public long totalSum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        long leftSum = totalSum(root.left);
        long rightSum = totalSum(root.right);

        return root.val + leftSum + rightSum;
    }

    // Step 2: Calculate subtree sums & update max product
    public long find(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        long leftSum = find(root.left);
        long rightSum = find(root.right);

        long subTreeSum = root.val + leftSum + rightSum;   // S1
        long remainingSum = SUM - subTreeSum;             // S2

        maxP = Math.max(maxP, subTreeSum * remainingSum);

        return subTreeSum;
    }

    public long maxProduct(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        SUM = totalSum(root);   // Step 1
        find(root);             // Step 2

        return maxP;
    }

    public static void main(String[] args)
    {
        _19MaxProductSplitBinaryTree obj = new _19MaxProductSplitBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(obj.maxProduct(root));
    }
}

/*
==================== PROPER DRY RUN ====================

Tree Structure:

            1
           / \
          2   3
         / \  /
        4  5 6


---------------- STEP 1: totalSum(root) ----------------

We calculate sum using postorder traversal.

Node 4:
left = 0, right = 0
sum = 4

Node 5:
left = 0, right = 0
sum = 5

Node 2:
leftSum = 4
rightSum = 5
sum = 2 + 4 + 5 = 11

Node 6:
left = 0, right = 0
sum = 6

Node 3:
leftSum = 6
rightSum = 0
sum = 3 + 6 = 9

Node 1 (root):
leftSum = 11
rightSum = 9
SUM = 1 + 11 + 9 = 21

TOTAL TREE SUM = 21


---------------- STEP 2: find(root) ----------------

At each node:
S1 = subtree sum
S2 = SUM - S1
product = S1 * S2

Node 4:
S1 = 4
S2 = 21 - 4 = 17
product = 4 * 17 = 68
maxP = 68

Node 5:
S1 = 5
S2 = 16
product = 5 * 16 = 80
maxP = 80

Node 2:
S1 = 11
S2 = 10
product = 11 * 10 = 110
maxP = 110   <-- maximum so far

Node 6:
S1 = 6
S2 = 15
product = 6 * 15 = 90
maxP remains 110

Node 3:
S1 = 9
S2 = 12
product = 9 * 12 = 108
maxP remains 110

Node 1:
S1 = 21
S2 = 0
product = 0
maxP remains 110


---------------- FINAL ANSWER ----------------

Maximum Product = 110

Best split:
Cut edge between node 1 and node 2

Subtree 1 sum = 11
Subtree 2 sum = 10
Product = 110

=======================================================
*/
