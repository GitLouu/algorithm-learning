package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 难度 简单
 */
public class _257_BinaryTreePaths_Recursion_DFS {

    /*

                  1
               /    \
              2      3
            /   \   /  \
           4     5 6    7
            \          / \
             8        9   10
     */

    // T(n) = O(n^2) 其中 n 表示节点数目。在深度优先搜索中每个节点会被访问一次且只会被访问一次，每一次会对 path 变量进行拷贝构造，时间代价为 O(n)
    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            dfs(root, "", paths);
            return paths;
        }

        private void dfs(TreeNode node, String path, List<String> paths) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                paths.add(path + node.val);
            } else {
                path = path + node.val + "->";
                dfs(node.left, path, paths);
                dfs(node.right, path, paths);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lRight = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = lRight;
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(root));
    }

}
