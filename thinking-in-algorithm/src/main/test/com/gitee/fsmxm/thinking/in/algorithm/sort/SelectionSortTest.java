package com.gitee.fsmxm.thinking.in.algorithm.sort;

import com.gitee.fsmxm.thinking.in.algorithm.util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    int[] origins = RandomUtil.create(20);

    @Test
    void sort1() {
        for (int i = 0; i < 50; i++) {
            System.out.println("原始: " + Arrays.toString(origins));
            int[] arr = RandomUtil.copyAndShuffle(origins);
            System.out.println("打乱: " + Arrays.toString(arr));
            //assertFalse(Arrays.equals(arr, origins)); // 如果数组长度太小,比如3,那么这里是有可能相等的,因为随机的结果集变小了
            SelectionSort.sort(arr);
            assertArrayEquals(arr, origins);
            System.out.println("排序: " + Arrays.toString(arr));
            System.out.println("---");
        }
    }

}