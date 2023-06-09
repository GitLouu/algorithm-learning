package com.gitee.fsmxm.thinking.in.algorithm.tree;

/**
 * 数组 二叉树 （搜索树）
 */
public class ArrayTree<T extends Comparable<T>> {

    private final T[] data;

    @SuppressWarnings("unchecked")
    public ArrayTree(int capacity) {
        int size = 1;
        for (int i = 0; i < capacity; i++) {
            size += Math.pow(2, i);
        }
        data = (T[]) new Comparable[size];
    }

    public void insert(T val) {
        if (data[1] == null) {
            data[1] = val;
            return;
        }
        int i = 1;
        while (true) {
            if (val.compareTo(data[i]) >= 0) {
                i = i * 2 + 1;
            } else {
                i = i * 2;
            }
            if (i >= data.length) {
                throw new IndexOutOfBoundsException("超出范围");
            }
            if (data[i] == null) {
                data[i] = val;
                break;
            }
        }
    }

    public void printIn() {
        StringBuilder builder = new StringBuilder();
        printIn(1, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printIn(int i, StringBuilder builder) {
        if (data[i] == null) {
            return;
        }
        printIn(2 * i, builder);
        builder.append(data[i]).append(", ");
        printIn(2 * i + 1, builder);
    }

    public void printPre() {
        StringBuilder builder = new StringBuilder();
        printPre(1, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printPre(int i, StringBuilder builder) {
        if (data[i] == null) {
            return;
        }
        builder.append(data[i]).append(", ");
        printPre(2 * i, builder);
        printPre(2 * i + 1, builder);
    }

    public void printPost() {
        StringBuilder builder = new StringBuilder();
        printPost(1, builder);
        System.out.println(builder.delete(builder.length() - 2, builder.length()).toString());
    }

    private void printPost(int i, StringBuilder builder) {
        if (data[i] == null) {
            return;
        }
        printPost(2 * i, builder);
        printPost(2 * i + 1, builder);
        builder.append(data[i]).append(", ");
    }

    public int find(T val) {
        int i = 1;
        while (i < data.length) {
            if (data[i] == null) {
                return 0;
            }
            if (val.compareTo(data[i]) > 0) {
                i = i * 2 + 1;
            } else if (val.compareTo(data[i]) < 0) {
                i = i * 2;
            } else {
                return i;
            }
        }
        return 0;
    }

    public int findMax() {
        int i = 1;
        int j = i;
        while (i < data.length && data[i] != null) {
            j = i;
            i = i * 2 + 1;
        }
        return j;
    }

    public int findMin() {
        int i = 1;
        int j = i;
        while (i < data.length && data[i] != null) {
            j = i;
            i = i * 2;
        }
        return j;
    }

    public T getVal(int i) {
        return data[i];
    }

    public static void main(String[] args) {
        ArrayTree<Integer> tree = new ArrayTree<>(5);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(3);
        tree.printIn();
        tree.printPre();
        tree.printPost();

        System.out.println(tree.getVal(tree.find(1)));
        System.out.println(tree.getVal(tree.find(5)));
        System.out.println(tree.getVal(tree.findMax()));
        System.out.println(tree.getVal(tree.findMin()));
    }

}
