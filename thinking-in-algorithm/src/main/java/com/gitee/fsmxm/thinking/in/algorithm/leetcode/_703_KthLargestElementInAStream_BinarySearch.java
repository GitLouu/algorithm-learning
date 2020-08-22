package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 703. 数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 难度 简单
 */
public class _703_KthLargestElementInAStream_BinarySearch {

    static class KthLargest {

        private final int[] data;
        private int size;

        public KthLargest(int k, int[] nums) {
            data = new int[k];
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (size < data.length) {
                int i = indexOf(data, size, val);
                if (i < size - 1) {
                    System.arraycopy(data, i + 1, data, i + 2, size - i - 1);
                }
                data[i + 1] = val;
                size++;
            } else if (data[0] < val) {
                int i = indexOf(data, size, val);
                if (i > 0) {
                    System.arraycopy(data, 1, data, 0, i);
                }
                data[i] = val;
            }
            return data[0];
        }

        /**
         * 小于val的最大的数的下标 (最后一个小于val的数）
         *
         * @param data 有序数组
         * @param size 有效数据个数
         * @param val  val
         */
        private int indexOf(int[] data, int size, int val) {
            int left = 0, right = size - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (data[mid] < val) {
                    if (mid == size - 1 || data[mid + 1] >= val) {
                        return mid;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        KthLargest kthLargest = new KthLargest(2, arr);
        System.out.println(kthLargest.add(-1));
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(-2));
        System.out.println(kthLargest.add(-4));
        System.out.println(kthLargest.add(3));
    }

}
