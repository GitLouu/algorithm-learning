package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 难度 中等
 */
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal_Recursion {

    // 递归
    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            return buildTree(preorder, inorderMap,
                    0, preorder.length - 1,
                    0, preorder.length - 1);
        }

        private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
                                   int preorderLeft, int preorderRight,
                                   int inorderLeft, int inorderRight) {
            if (preorderLeft > preorderRight) {
                return null;
            }

            int inorderRoot = inorderMap.get(preorder[preorderLeft]);

            TreeNode root = new TreeNode(preorder[preorderLeft]);

            root.left = buildTree(preorder, inorderMap,
                    preorderLeft + 1, inorderRoot - inorderLeft + preorderLeft,
                    inorderLeft, inorderRoot - 1);

            root.right = buildTree(preorder, inorderMap,
                    inorderRoot - inorderLeft + preorderLeft + 1, preorderRight,
                    inorderRoot + 1, inorderRight);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        root.printAll();
    }

}
