package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    // 平均时间复杂度O(nlogn) 空间复杂度O(1)
    // 最坏时间复杂度O(n^2)  比如一个已经有序的数组
    static void sort(int[] data) {
        sortInternally(data, 0, data.length - 1);
    }

    private static void sortInternally(int[] data, int q, int r) {

        if (q >= r) {
            return;
        }

        int p = partition(data, q, r);

        sortInternally(data, q, p - 1);
        sortInternally(data, p + 1, r);
    }

    private static int partition(int[] data, int q, int r) {
        int i = q;
        int pivot = data[r];
        for (int j = i; j < r; j++) {
            if (data[j] < pivot) {
                if (j != i) {
                    int t = data[i];
                    data[i] = data[j];
                    data[j] = t;
                }
                i++;
            }
        }
        data[r] = data[i];
        data[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
//        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        int[] a = {1, 3, 6, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
