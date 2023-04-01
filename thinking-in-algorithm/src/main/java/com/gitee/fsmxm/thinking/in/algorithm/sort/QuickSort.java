package com.gitee.fsmxm.thinking.in.algorithm.sort;

/**
 * 快速排序
 * 快速排序的核心思想是，选择一个基准元素，
 * 将序列中所有小于基准元素的元素放在基准元素的左边，
 * 大于等于基准元素的元素放在基准元素的右边，
 * 这个过程称为分区（Partition）。
 * 然后对基准元素左右两个子序列进行递归排序，直到子序列长度为1或0，递归结束。
 */
public class QuickSort {

    // 平均时间复杂度O(nlogn) 空间复杂度O(1)
    // 最坏时间复杂度O(n^2)  比如一个已经有序的数组
    static void sort1(int[] data) {
        sortInternally1(data, 0, data.length - 1);
    }

    private static void sortInternally1(int[] data, int left, int right) {

        if (left >= right) {
            return;
        }

        int partitionIndex = partition1(data, left, right);

        sortInternally1(data, left, partitionIndex - 1);
        sortInternally1(data, partitionIndex + 1, right);
    }

    private static int partition1(int[] data, int left, int right) {
        int pivot = data[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (data[i] < pivot) {
                if (i != partitionIndex) {
                    int t = data[partitionIndex];
                    data[partitionIndex] = data[i];
                    data[i] = t;
                }
                partitionIndex++;
            }
        }
        data[right] = data[partitionIndex];
        data[partitionIndex] = pivot;
        return partitionIndex;
    }

    private static int partitionSwap(int[] data, int left, int right) {
        int pivot = data[right];
        int i = left, j = right;
        while (i < j) {
            while (i < j && data[i] <= pivot) {
                i++;
            }
            while (j > i && data[j] >= pivot) {
                j--;
            }
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        data[right] = data[j];
        data[j] = pivot;
        return j;
    }

    static void sort2(int[] data) {
        sortInternally2(data, 0, data.length - 1);
    }

    private static void sortInternally2(int[] data, int left, int right) {

        if (left >= right) {
            return;
        }

        int partitionIndex = partition2(data, left, right);

        sortInternally2(data, left, partitionIndex - 1);
        sortInternally2(data, partitionIndex + 1, right);
    }

    private static int partition2(int[] data, int left, int right) {
        int partitionIndex = left;
        // 三数取中
        int pivot = threeInTheMiddle(data, left, right);
        for (int j = partitionIndex; j < right; j++) {
            if (data[j] < pivot) {
                if (j != partitionIndex) {
                    int t = data[partitionIndex];
                    data[partitionIndex] = data[j];
                    data[j] = t;
                }
                partitionIndex++;
            }
        }
        data[right] = data[partitionIndex];
        data[partitionIndex] = pivot;

        return partitionIndex;
    }

    private static int threeInTheMiddle(int[] data, int left, int right) {
        if (right - left >= 2) {
            int middle = (right - left) / 2;
            if (data[left] > data[middle] && data[left] < data[right]) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            } else if (data[middle] > data[left] && data[middle] < data[right]) {
                int temp = data[middle];
                data[middle] = data[right];
                data[right] = temp;
            }
        }
        return data[right];
    }

}
