package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 难度 简单
 */
public class _101_SymmetricTree_Recursion {

    static class Solution {
        public boolean isSymmetric(TreeNode root) {

            if (root == null) {
                return true;
            }

            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null) {
                return false;
            }
            if (node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
        }
    }

    public static void main(String[] args) {
        // [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);
        TreeNode node41 = new TreeNode(4);
        TreeNode node42 = new TreeNode(4);
        root1.left = node21;
        root1.right = node22;
        node21.left = node31;
        node21.right = node41;
        node22.left = node42;
        node22.right = node32;
        root1.printAll();

        Solution solution = new Solution();
        boolean symmetric = solution.isSymmetric(root1);
        System.out.println(symmetric);

        // 1,2,2,null,3,null,3
        TreeNode root2 = new TreeNode(1);
        TreeNode nod21 = new TreeNode(2);
        TreeNode nod22 = new TreeNode(2);
        TreeNode nod31 = new TreeNode(3);
        TreeNode nod32 = new TreeNode(3);
        root2.left = nod21;
        root2.right = nod22;
        nod21.right = nod31;
        nod22.right = nod32;
        root2.printAll();
        System.out.println(solution.isSymmetric(root2));
    }

}
