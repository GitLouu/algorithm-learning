package com.gitee.fsmxm.thinking.in.algorithm.sort;

import com.gitee.fsmxm.thinking.in.algorithm.util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    int[] origins = RandomUtil.create(20);

    @Test
    void sort1() {
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomUtil.copyAndShuffle(origins);
//            assertFalse(Arrays.equals(arr, origins)); // 如果数组长度太小,比如3,那么这里是有可能相等的,因为随机的结果集变小了
            BubbleSort.sort1(arr);
            assertArrayEquals(arr, origins);
        }
    }

    @Test
    void sort2() {
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomUtil.copyAndShuffle(origins);
//            assertFalse(Arrays.equals(arr, origins));
            BubbleSort.sort2(arr);
            assertArrayEquals(arr, origins);
        }
    }

    @Test
    void sort3() {
        for (int i = 0; i < 50; i++) {
            int[] arr = RandomUtil.copyAndShuffle(origins);
            System.out.println(Arrays.toString(arr));
//            assertFalse(Arrays.equals(arr, origins));
            BubbleSort.sort3(arr);
            assertArrayEquals(arr, origins);
        }
    }
}