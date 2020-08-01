package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * n个数字
 * 每轮从无序数字中找到最小的，放到前面的有序区末尾
 * 循环n次
 */
public class SelectionSort {

    // 时间复杂度O(n^2) 空间复杂度O(1)
    // 最好时间复杂度 最坏时间复杂度 均是O(n^2)
    static int[] sort(int[] data) {

        for (int i = 0; i < data.length; i++) {

            int pos = i;

            for (int j = i; j < data.length - 1; j++) {

                if (data[pos] > data[j + 1]) {
                    pos = j + 1;
                }

            }

            int temp = data[i];
            data[i] = data[pos];
            data[pos] = temp;

        }

        return data;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        System.out.println(Arrays.toString(sort(a)));
    }

}
