package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序   插入排序的变化
 * n个数字
 * 将其按间隔分为几组，每组进行插入排序
 * 缩小间隔，再进行插入排序
 * 直到间隔为1，整体再进行一次插入排序，
 * 至此，完成。
 */
public class ShellSort {

    static int[] sort1(int[] data) {

        // 初始间隔 按 n / 2
        for (int gap = data.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < data.length; i++) {
                int temp = data[i];
                int j = i;

                for (; j > gap - 1 && data[j - gap] > temp ; j -= gap) {
                    data[j] = data[j - gap];
                }

                data[j] = temp;
            }

        }

        return data;
    }

    static int[] sort2(int[] data) {

        // 初始间隔 按 n / 2
        for (int gap = data.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < data.length; i++) {
                int temp = data[i];

                int j = i - gap;
                for (; j >= 0 && data[j] > temp ; j -= gap) {
                    data[j + gap] = data[j];
                }

                data[j + gap] = temp;
            }

        }

        return data;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        System.out.println(Arrays.toString(sort2(a)));
    }

}
