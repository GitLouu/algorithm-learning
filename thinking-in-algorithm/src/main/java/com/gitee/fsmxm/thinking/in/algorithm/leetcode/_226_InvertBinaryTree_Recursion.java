package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 难度 简单
 */

public class _226_InvertBinaryTree_Recursion {

    static class Solution {

        // 分治
        // T(n)=O(n)
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        private void invert(TreeNode node) {
            if (node == null) {
                return;
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            invert(node.left);
            invert(node.right);
        }

    }

    public static void main(String[] args) {
        // [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        root.left = node2;
        root.right = node7;
        node2.left = node1;
        node2.right = node3;
        node7.left = node6;
        node7.right = node9;
        root.printAll();

        Solution solution = new Solution();
        TreeNode node = solution.invertTree(root);
        node.printAll();
    }

}
