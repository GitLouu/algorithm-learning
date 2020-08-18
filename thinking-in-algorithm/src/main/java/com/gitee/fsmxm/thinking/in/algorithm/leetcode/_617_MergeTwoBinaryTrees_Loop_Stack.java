package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Stack;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 难度 简单
 */
public class _617_MergeTwoBinaryTrees_Loop_Stack {

    // 循环  栈
    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }

            Stack<TreeNode[]> stack = new Stack<>();
            stack.push(new TreeNode[]{t1, t2});

            while (!stack.isEmpty()) {
                TreeNode[] nodes = stack.pop();
                nodes[0].val += nodes[1].val;

                if (nodes[0].left != null && nodes[1].left != null) {
                    stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
                } else if (nodes[1].left != null) {
                    nodes[0].left = nodes[1].left;
                }

                if (nodes[0].right != null && nodes[1].right != null) {
                    stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
                } else if (nodes[1].right != null) {
                    nodes[0].right = nodes[1].right;
                }
            }

            return t1;
        }
    }

    public static void main(String[] args) {

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
//        node7.left = node6;
//        node7.right = node9;
        root.printAll();

        TreeNode root2 = new TreeNode(4);
        TreeNode node22 = new TreeNode(2);
        TreeNode node72 = new TreeNode(7);
        TreeNode node12 = new TreeNode(1);
        TreeNode node32 = new TreeNode(3);
        TreeNode node62 = new TreeNode(6);
        TreeNode node92 = new TreeNode(9);
        root2.left = node22;
        root2.right = node72;
        node22.left = node12;
        node22.right = node32;
        node72.left = node62;
        node72.right = node92;
        root2.printAll();

        Solution solution = new Solution();
        TreeNode node = solution.mergeTrees(root, root2);
        node.printAll();

    }

}
