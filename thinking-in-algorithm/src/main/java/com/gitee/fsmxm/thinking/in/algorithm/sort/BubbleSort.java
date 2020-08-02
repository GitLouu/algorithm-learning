package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * n个数字
 * 每一轮，挨个比较，大的向后交换，这样每一轮最大的都会换到后面
 * 只要比较n轮就能完成排序
 */
public class BubbleSort {

    // 最初写法
    // 时间复杂度O(n^2)  空间复杂度O(1)
    // 最好时间复杂度 最坏时间复杂度 均是O(n^2)
    static int[] sort1(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    // 优化 第二次循环 没必要每次都循环n-1遍
    //     只要比较没有排过序的数据就行了
    // 时间复杂度O(n^2)  空间复杂度O(1)
    // 最好时间复杂度 最坏时间复杂度 均是O(n^2)
    static int[] sort2(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    // 最终优化
    // 时间复杂度O(n^2)  空间复杂度O(1)
    // 最好时间复杂度O(n) 最坏时间复杂度O(n^2)
    static int[] sort3(int[] data) {
        int pos = data.length - 1; // 记录上一次有效的交换位置
        for (int i = 0; i < data.length; i++) {
            boolean sorted = true; // 已经有序了
            int tempPos = pos;
            for (int j = 0; j < pos; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    sorted = false; // 只要一次遍历有数据交换，就不是有序的
                    tempPos = j; // 记录上一次有效的交换位置，该位置后面的已经是有序的
                }
            }
            pos = tempPos;
            if (sorted) {
                break;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        System.out.println(Arrays.toString(sort3(a)));
    }

}
