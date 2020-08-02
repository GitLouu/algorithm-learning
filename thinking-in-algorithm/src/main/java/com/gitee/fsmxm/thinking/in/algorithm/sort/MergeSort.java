package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    // 时间复杂度O(nlogn)  空间复杂度O(n)
    static void sort(int[] data) {
        if (data == null) {
            return;
        }
        sortInternally(data, 0, data.length - 1);
    }

    private static void sortInternally(int[] data, int q, int r) {

        // 终止条件
        if (q >= r) {
            return;
        }

        int mid = (q + r) / 2;
        sortInternally(data, q, mid);
        sortInternally(data, mid + 1, r);

        merge(data, q, mid, r);

    }

    private static void merge(int[] data, int q, int mid, int r) {
        // 申请q...r个空间的数组
        int[] temp = new int[r + 1 - q];
        int i = q;
        int j = mid + 1;
        int pos = 0;
        // 将数据有序的放入临时数组
        while (i <= mid && j <= r) {
            if (data[i] > data[j]) { // 保证数据稳定性（相同数值数据前后位置不变）
                temp[pos++] = data[j];
                j++;
            } else {
                temp[pos++] = data[i];
                i++;
            }
        }

        // 如果有剩余数据，将剩余数据压入数组
        while (i <= mid) {
            temp[pos++] = data[i++];
        }

        // 如果有剩余数据，将剩余数据压入数组
        while (j <= r) {
            temp[pos++] = data[j++];
        }

        // 将临时数组数据复制给原数组
        for (i = 0; i < temp.length; i++) {
            data[i + q] = temp[i];
        }

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
