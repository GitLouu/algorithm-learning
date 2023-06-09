package com.gitee.fsmxm.thinking.in.algorithm.sort;

/**
 * 插入排序
 * 每一轮，从前到后一次选择一个数字(可以从第2个数字开始，第1个数字无法跟前面比较)，
 * 依次跟前面的比较，如果前面的数字大于该数字，则将前面的数字向后移一位，
 * 直到不满足条件的位置，最终将该数字插入
 * 效果就是 把一个数字插入到前面的有序区里面去使其仍然有序
 */
public class InsertionSort {

    // 时间复杂度O(n^2)  空间复杂度O(1)
    // 最好时间复杂度O(n)  最坏时间复杂度O(n^2)
    static void sort(int[] data) {
        if (data == null) {
            return;
        }
        for (int i = 1; i < data.length; i++) {
            int j = i;
            int temp = data[j];
            for (; j > 0 && data[j - 1] > temp; j--) {
                data[j] = data[j - 1]; // 往后移
            }
            data[j] = temp;
        }
    }

}
