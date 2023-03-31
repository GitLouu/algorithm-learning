package com.gitee.fsmxm.thinking.in.algorithm.sort;

/**
 * 希尔排序   插入排序的变化
 * n个数字
 * 将其按间隔分为几组，每组进行插入排序
 * 缩小间隔，再进行插入排序
 * 直到间隔为1，整体再进行一次插入排序，
 * 至此，完成。
 */
public class ShellSort {

    static void sort(int[] data) {
        if (data == null) {
            return;
        }
        // 初始间隔 按 n / 2
        for (int gap = data.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < data.length; i++) {
                int j = i;
                int temp = data[j];

                for (; j > gap - 1 && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }

                data[j] = temp;
            }
        }
    }

}
