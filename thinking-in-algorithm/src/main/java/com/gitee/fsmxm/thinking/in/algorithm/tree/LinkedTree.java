package com.gitee.fsmxm.thinking.in.algorithm.tree;

import com.gitee.fsmxm.thinking.in.algorithm.TNode;

/**
 * 链式 二叉树 （二叉搜索树）
 */
public class LinkedTree<T extends Comparable<T>> {

    private TNode<T> root;

    public LinkedTree() {

    }

    public void add(T val) {
        if (root == null) {
            root = new TNode<>(val);
            return;
        }
        TNode<T> p = root;
        TNode<T> pp = null;
        boolean left = true;
        while (p != null) {
            pp = p;
            if (val.compareTo(p.val) >= 0) {
                p = p.right;
                left = false;
            } else {
                p = p.left;
                left = true;
            }
        }
        if (left) {
            pp.left = new TNode<>(val);
        } else {
            pp.right = new TNode<>(val);
        }
    }

    // 中序遍历
    public void printIn() {
        StringBuilder builder = new StringBuilder();
        printIn(root, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printIn(TNode<T> root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        printIn(root.left, builder);
        builder.append(root.val).append(", ");
        printIn(root.right, builder);
    }

    // 前序遍历
    public void printPre() {
        StringBuilder builder = new StringBuilder();
        printPre(root, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printPre(TNode<T> root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        builder.append(root.val).append(", ");
        printPre(root.left, builder);
        printPre(root.right, builder);
    }

    // 后序遍历
    public void printPost() {
        StringBuilder builder = new StringBuilder();
        printPost(root, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printPost(TNode<T> root, StringBuilder builder) {
        if (root == null) {
            return;
        }
        printPost(root.left, builder);
        printPost(root.right, builder);
        builder.append(root.val).append(", ");
    }

    public TNode<T> find(T val) {
        TNode<T> p = root;
        while (p != null) {
            if (val.compareTo(p.val) > 0) {
                p = p.right;
            } else if (val.compareTo(p.val) < 0) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<>();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(6);
        tree.add(3);

        tree.printIn();
        tree.printPre();
        tree.printPost();
        System.out.println(tree.find(6).val);
        System.out.println(tree.find(1));
    }

}
