package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 难度 简单
 */
public class _104_MaximumDepthOfBinaryTree_Recursion {

    // 递归
    // T(n) = O(n)
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
