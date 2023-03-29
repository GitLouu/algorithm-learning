package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 难度 简单
 */
public class _110_BalancedBinaryTree_Recursion2 {

    // 递归 自底至顶
    // T(n) = O(n)
    static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return depth(root) != -1;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            if (left == -1 || right == -1 || left - right > 1 || left - right < -1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        // 3,9,20,null,null,15,7
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rLeft = new TreeNode(15);
        TreeNode rRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rLeft;
        right.right = rRight;
        root.printAll();

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));

        // 1,2,2,3,3,null,null,4,4
        TreeNode root2 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode right2 = new TreeNode(2);
        TreeNode lLeft = new TreeNode(3);
        TreeNode lRight = new TreeNode(3);
        TreeNode llLeft = new TreeNode(4);
        TreeNode llRight = new TreeNode(4);
        root2.left = left2;
        root2.right = right2;
        left2.left = lLeft;
        left2.right = lRight;
        lLeft.left = llLeft;
        lLeft.right = llRight;
        root2.printAll();
        System.out.println(solution.isBalanced(root2));
    }

}
