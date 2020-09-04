package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.*;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 难度 简单
 */
public class _257_BinaryTreePaths_Loop_BFS {

    /*

                  1
               /    \
              2      3
            /   \   /  \
           4     5 6    7
            \          / \
             8        9   10
     */

    // T(n) = O(n^2)
    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }
            List<String> paths = new ArrayList<>();
            Queue<String> tPaths = new LinkedList<>();
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            tPaths.add(Integer.toString(root.val));

            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                String path = tPaths.poll();
                if (node.left == null && node.right == null) {
                    paths.add(path);
                    continue;
                }
                if (node.left != null) {
                    nodes.add(node.left);
                    tPaths.add(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                    tPaths.add(path + "->" + node.right.val);
                }
            }

            return paths;
        }
    }

    public static void main(String[] args) {
        // [2,1,6,null,null,5,null,4,null,3]
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(6);
        TreeNode rLeft = new TreeNode(5);
        TreeNode rlLeft = new TreeNode(4);
        TreeNode rllLeft = new TreeNode(3);
        root.left = left;
        root.right = right;
        right.left = rLeft;
        rLeft.left = rlLeft;
        rlLeft.left = rllLeft;
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(root));
    }

}
