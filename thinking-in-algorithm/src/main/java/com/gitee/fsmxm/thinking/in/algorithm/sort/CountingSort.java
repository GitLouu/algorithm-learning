package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * T(n) = O(n)
 * S(n) = O(n)
 */
public class CountingSort {

    // 如果data数据量太大，就不太适合
    static void sort(int[] data) {

        if (data == null || data.length < 2) {
            return;
        }

        // 找到最大值 和 最小值
        int maxVal = data[0];
        int minVal = maxVal;
        for (int val : data) {
            if (maxVal < val) {
                maxVal = val;
            } else if (minVal > val) {
                minVal = val;
            }
        }

        // 计数数组
        int[] counter = new int[maxVal - minVal + 1];
        for (int val : data) {
            counter[val - minVal]++;
        }

        // 向后计算总数
        for (int i = 1; i <= counter.length - 1; i++) {
            counter[i] += counter[i - 1];
        }

        int[] newArr = new int[data.length];
        // 从后向前遍历data
        for (int i = data.length - 1; i >= 0; i--) {
            // counter[data[i] - minVal] - 1 就是该数据的排序位置
            newArr[--counter[data[i] - minVal]] = data[i];
        }

        System.arraycopy(newArr, 0, data, 0, data.length);

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4, -100, 1000};
        sort(b);
        System.out.println(Arrays.toString(b));
    }

}
