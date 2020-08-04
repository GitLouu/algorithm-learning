package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 * T(n) = O(dn) d是维度
 */
public class RadixSort {

    static void sort(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }

        // 找到最大值
        int maxVal = data[0];
        int minVal = maxVal;
        for (int val : data) {
            if (maxVal < val) {
                maxVal = val;
            } else if (minVal > val) {
                minVal = val;
            }
        }

        if (maxVal == minVal) {
            return;
        }

        if (minVal < 0) {
            for (int i = 0; i < data.length; i++) {
                data[i] -= minVal;
            }
        }

        int mv = maxVal;
        if (minVal < 0) {
            mv -= minVal;
        }

        // 从个位数开始遍历，遍历次数依据最大值 / exp
        for (int exp = 1; mv / exp > 0; exp *= 10) {
            countSort(data, exp);
        }

        if (minVal < 0) {
            for (int i = 0; i < data.length; i++) {
                data[i] += minVal;
            }
        }
    }

    private static void countSort(int[] data, int exp) {
        if (data.length < 2) {
            return;
        }

        // 数字计数器 0 - 9
        int[] counter = new int[10];
        for (int val : data) {
            counter[val / exp % 10]++;
        }

        // 计算排序后的位置
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        int[] newArr = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            newArr[--counter[data[i] / exp % 10]] = data[i];
        }

        System.arraycopy(newArr, 0, data, 0, data.length);
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 144, 44, 44, -33};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
