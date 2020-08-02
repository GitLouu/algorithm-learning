package com.gitee.fsmxm.thinking.in.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 每一轮，从前到后一次选择一个数字(可以从第2个数字开始，第1个数字无法跟前面比较)，
 * 跟依次前面的比较，如果前面的数字大于该数字，则将前面的数字向后移，
 * 直到不满足条件的位置，最终将该数字插入
 * 效果就是 把一个数字插入到前面的有序区里面去使其仍然有序
 */
public class InsertionSort {

    // 时间复杂度O(n^2)  空间复杂度O(1)
    // 最好时间复杂度O(n)  最坏时间复杂度O(n^2)
    static void sort1(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];

            int j = i;
            for (; j > 0 && data[j - 1] > temp; j--) {
                data[j] = data[j - 1]; // 往后移
            }
            data[j] = temp;

        }
    }

    // 另一种写法
    static void sort2(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];

            int j = i - 1;
            for (; j >= 0 && data[j] > temp; j--) {
                data[j + 1] = data[j]; // 往后移
            }
            data[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        sort2(a);
        System.out.println(Arrays.toString(a));
    }

}
