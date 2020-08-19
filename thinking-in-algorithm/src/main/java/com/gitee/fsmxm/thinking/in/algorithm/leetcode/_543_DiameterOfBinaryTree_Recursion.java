package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 难度 简单
 */
public class _543_DiameterOfBinaryTree_Recursion {

    // 递归
    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;
            int[] ans = new int[1];
            maxDep(root, ans);
            return ans[0] - 1;
        }

        private int maxDep(TreeNode node, int[] ans) {
            if (node == null) {
                return 0;
            }
            int ld = maxDep(node.left, ans);
            int rd = maxDep(node.right, ans);
            ans[0] = Math.max(ans[0], ld + rd + 1);
            return Math.max(ld, rd) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lLeft = new TreeNode(4);
        TreeNode lRight = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = lLeft;
        left.right = lRight;
        root.printAll();
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(root));
    }

}
