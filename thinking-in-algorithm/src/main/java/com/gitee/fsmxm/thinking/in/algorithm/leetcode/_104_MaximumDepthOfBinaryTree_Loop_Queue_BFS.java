package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 难度 简单
 */
public class _104_MaximumDepthOfBinaryTree_Loop_Queue_BFS {

    // 广度优先搜索
    // T(n) = O(n)
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int depth = 0;
            while (!queue.isEmpty()) {

                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        break;
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    size--;
                }
                depth++;
            }

            return depth;
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
