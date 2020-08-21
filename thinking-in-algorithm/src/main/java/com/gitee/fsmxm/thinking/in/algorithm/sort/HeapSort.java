package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    // T(n) = O(nlogn)
    // S(n) = O(1)
    static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        buildHeap(data);
        for (int i = data.length-1; i > 0; i--) {
            int val = data[0];
            data[0] = data[i];
            data[i] = val;
            shiftDown(data, 0, i);
        }
    }

    private static void buildHeap(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            shiftDown(data, i, data.length);
        }
    }

    private static void shiftDown(int[] data, int i, int len) {
        int val = data[i];
        while (true) {
            int j = i;
            if (2 * i + 1 < len && val < data[2 * i + 1]) {
                j = 2 * i + 1;
            }
            if (2 * i + 2 < len && data[j] < data[2 * i + 2]) {
                j = 2 * i + 2;
            }
            if (j == i) {
                break;
            }
            data[i] = data[j];
            i = j;
        }
        data[i] = val;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
