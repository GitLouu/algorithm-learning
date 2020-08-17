package com.gitee.fsmxm.thinking.in.algorithm.tree;

import com.gitee.fsmxm.thinking.in.algorithm.TNode;

/**
 * 链式 二叉树 （二叉搜索树）
 */
public class LinkedTree<T extends Comparable<T>> {

    private TNode<T> root;

    public LinkedTree() {

    }

    public void insert(T val) {
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

    public void delete(T val) {
        if (root == null) {
            return;
        }

        TNode<T> p = root;
        TNode<T> pp = null;
        while (p != null && !p.val.equals(val)) {
            pp = p;
            if (val.compareTo(p.val) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        // 找不到要删除的节点
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点
            TNode<T> minP = p.right;
            TNode<T> minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }

        // 要删除的节点只有一个子节点
        TNode<T> pChild;
        if (p.left != null) {
            pChild = p.left;
        } else if (p.right != null) {
            pChild = p.right;
        } else {
            pChild = null;
        }

        // 要删除的是根节点
        //  这里说明代码没有走 要删除的节点有两个子节点 的判断语句
        //  因此，只有一个子节点或者没有子节点
        if (pp == null) {
            root = pChild;
        } else if (pp.left == p) { // 如果父节点的左子节点等于要删除的节点
            pp.left = pChild;
        } else { // 如果父节点的右子节点等于要删除的节点
            pp.right = pChild;
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

    public TNode<T> findMax() {
        if (root == null) {
            return null;
        }
        TNode<T> p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public TNode<T> findMin() {
        if (root == null) {
            return null;
        }
        TNode<T> p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public static void main(String[] args) {
        LinkedTree<Integer> tree = new LinkedTree<>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(3);

        tree.printIn();
        tree.printPre();
        tree.printPost();
        System.out.println(tree.find(6).val);
        System.out.println(tree.find(1));
        System.out.println(tree.findMax().val);
        System.out.println(tree.findMin().val);

        tree.delete(1);
        tree.printIn();
        tree.delete(6);
        tree.printIn();
    }

}
