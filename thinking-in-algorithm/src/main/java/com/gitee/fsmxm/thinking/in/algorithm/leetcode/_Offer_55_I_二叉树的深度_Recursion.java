package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 难度 简单
 */
public class _Offer_55_I_二叉树的深度_Recursion {

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            }
            return rightDepth + 1;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

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

        System.out.println(solution.maxDepth(root));
    }

}
