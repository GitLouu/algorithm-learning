package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 965. 单值二叉树
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 * 难度 简单
 */
public class _965_UnivaluedBinaryTree_Recursion2 {

    // T(n) = O(n)
    static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean[] res = new boolean[]{true};
            isUnivalTree(root, root.val, res);
            return res[0];
        }

        private void isUnivalTree(TreeNode node, int rootVal, boolean[] res) {
            if (!res[0] || node == null) {
                return;
            }
            if (node.left != null && node.left.val != rootVal || node.right != null && node.right.val != rootVal) {
                res[0] = false;
                return;
            }

            isUnivalTree(node.left, rootVal, res);
            isUnivalTree(node.right, rootVal, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1,1,1,1,1,null,1
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(1);
        TreeNode ll = new TreeNode(1);
        TreeNode lr = new TreeNode(1);
        TreeNode rr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        root.printAll();
        System.out.println(solution.isUnivalTree(root));

        // 2,2,2,5,2
        TreeNode root2 = new TreeNode(2);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode ll2 = new TreeNode(5);
        TreeNode lr2 = new TreeNode(2);
        root2.left = l2;
        root.right = r2;
        l2.left = ll2;
        l2.right = lr2;
        root2.printAll();
        System.out.println(solution.isUnivalTree(root2));
    }

}
