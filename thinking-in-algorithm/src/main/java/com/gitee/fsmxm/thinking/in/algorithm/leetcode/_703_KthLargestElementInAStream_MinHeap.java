package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.PriorityQueue;

/**
 * 703. 数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 难度 简单
 */
public class _703_KthLargestElementInAStream_MinHeap {

    static class KthLargest {

        private final PriorityQueue<Integer> queue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            for (int n : nums) {
                add(n);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

}
