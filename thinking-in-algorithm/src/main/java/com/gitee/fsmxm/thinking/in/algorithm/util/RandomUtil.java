package com.gitee.fsmxm.thinking.in.algorithm.util;

import java.util.Arrays;
import java.util.Random;

/**
 * 随机工具, 生成 或 打乱 数据
 */
public class RandomUtil {

    /**
     * 生成 0 - {@code len}(不包含) 的自然顺序的数组
     *
     * @param len 长度
     * @return 0 - {@code len}(不包含) 的自然顺序的数组
     */
    public static int[] create(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * 洗牌算法, 拷贝一份数组, 然后打乱并返回
     *
     * @param origins 原数组
     * @return 打乱的新数组
     */
    public static int[] copyAndShuffle(int[] origins) {
        int[] newArray = Arrays.copyOf(origins, origins.length);
        shuffle(newArray);
        return newArray;
    }

    /**
     * 洗牌算法, 将数组 {@code numbs} 进行打乱
     *
     * @param numbs 将要打乱的数组
     */
    public static void shuffle(int[] numbs) {
        shuffle(numbs, 0, numbs.length);
    }

    /**
     * 洗牌算法, 将数组 {@code numbs} 进行打乱, 打乱的数组索引起始位置为 {@code start}(包含) 到 {@code end}(不包含)
     *
     * @param numbs 将要打乱的数组
     * @param start 开始打乱的位置(包含)
     * @param end   结束打乱的位置(不包含)
     * @throws ArrayIndexOutOfBoundsException 如果 {@code start < 0} 或 {@code start >= numbs.length}
     *                                        或 {@code end < 0} 或 {@code end > numbs.length}
     * @throws IllegalArgumentException       如果 {@code start > end}
     */
    public static void shuffle(int[] numbs, int start, int end) {
        int len = numbs.length;
        if (start < 0 || start >= len || end < 0 || end > len) {
            throw new ArrayIndexOutOfBoundsException("start or end out of range.");
        }
        if (start > end) {
            throw new IllegalArgumentException("start should less than or equal end");
        }
        Random random = new Random();
        for (int i = end - 1; i > start; i--) {
            int pos = start + random.nextInt(i + 1);
            int temp = numbs[i];
            numbs[i] = numbs[pos];
            numbs[pos] = temp;
        }
    }

}
