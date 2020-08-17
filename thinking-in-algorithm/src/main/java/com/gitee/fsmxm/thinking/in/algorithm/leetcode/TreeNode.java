package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    void printAll() {
        List<TreeNode> list = new ArrayList<>();
        list.add(this);
        int count = list.size();
        int i = 0;
        while (i < count) {
            TreeNode treeNode = list.get(i);
            if (treeNode != null) {
                if (treeNode.left != null) {
                    list.add(treeNode.left);
                    count++;
                }
                if (treeNode.right != null) {
                    list.add(treeNode.right);
                    count++;
                }
            }
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for (TreeNode node : list) {
            builder.append(node.val).append(", ");
        }
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }
}