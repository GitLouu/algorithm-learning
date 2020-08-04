package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 桶排序
 * T(n) = O(n)
 * S(n) = O(n)
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        sort(a, 2);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4, -100, 1000};

        sort(b, 1000);
        System.out.println(Arrays.toString(b));
    }

    static void sort(int[] data, int bucketSize) {

        if (data == null || data.length < 2) {
            return;
        }

        if (bucketSize <= 0) {
            bucketSize = 16;
        }

        int maxVal = data[0];
        int minVal = maxVal;

        // 找到最小值和最大值
        for (int val : data) {
            if (val > maxVal) {
                maxVal = val;
            } else if (val < minVal) {
                minVal = val;
            }
        }

        if (minVal == maxVal) {
            return;
        }

        // 桶数量
        int bucketCount = maxVal - minVal + 1;
        bucketCount = bucketCount % bucketSize == 0 ? bucketCount / bucketSize : bucketCount / bucketSize + 1;

        // 初始化桶
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indices = new int[bucketCount]; // 记录每个桶的索引

        for (int val : data) {
            int i = (val - minVal) / bucketSize;
            if (indices[i] == buckets[i].length) { // 第i个桶已满，则扩容
                ensureCapacity(buckets, i, bucketSize);
            }
            buckets[i][indices[i]] = val;
            indices[i]++;
        }

        for (int i = 0, j = 0; j < bucketCount; i += indices[j], j++) {
            if (indices[j] < 1) {
                continue;
            }
            quickSort(buckets[j], indices[j]);
            System.arraycopy(buckets[j], 0, data, i, indices[j]);
        }

    }

    private static void quickSort(int[] data, int length) {
        if (data.length < 2) {
            return;
        }
        internallyQuickSort(data, 0, length - 1);
    }

    private static void internallyQuickSort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(data, left, right);
        internallyQuickSort(data, left, p - 1);
        internallyQuickSort(data, p + 1, right);
    }

    private static int partition(int[] data, int left, int right) {

        int val = data[right];
        int i = left;
        for (int j = i; j < right; j++) {
            if (data[j] < val) {
                if (j != i) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
                i++;
            }
        }

        data[right] = data[i];
        data[i] = val;

        return i;
    }

    private static void ensureCapacity(int[][] buckets, int index, int bucketSize) {
        int[] newArr = new int[buckets[index].length + bucketSize];
        System.arraycopy(buckets[index], 0, newArr, 0, buckets[index].length);
        buckets[index] = newArr;
    }

}
