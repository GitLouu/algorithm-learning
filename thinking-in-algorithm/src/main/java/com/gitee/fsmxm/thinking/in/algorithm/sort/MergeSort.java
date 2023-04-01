package com.gitee.fsmxm.thinking.in.algorithm.sort;

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

    private static void sortInternally(int[] data, int left, int right) {

        // 终止条件
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sortInternally(data, left, mid);
        sortInternally(data, mid + 1, right);

        merge(data, left, mid, right);

    }

    private static void merge(int[] data, int left, int mid, int right) {
        // 申请q...r个空间的数组
        int[] temp = new int[right + 1 - left];
        int i = left;
        int j = mid + 1;
        int pos = 0;
        // 将数据有序的放入临时数组
        while (i <= mid && j <= right) {
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
        while (j <= right) {
            temp[pos++] = data[j++];
        }

        // 将临时数组数据复制给原数组
        for (i = 0; i < temp.length; i++) {
            data[i + left] = temp[i];
        }

    }

}
