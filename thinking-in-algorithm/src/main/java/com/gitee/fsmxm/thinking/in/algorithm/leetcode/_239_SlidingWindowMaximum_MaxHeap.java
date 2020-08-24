package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 难度 困难
 */
public class _239_SlidingWindowMaximum_MaxHeap {
    // T(n) = O(nlogk)  // 如果n k 足够大，还是很慢的
    // S(n) = O(k)
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            if (nums == null || nums.length < 2) {
                return nums;
            }
            if (k < 1) {
                return new int[0];
            }

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < k; i++) {
                maxHeap.add(nums[i]);
            }
            res[0] = maxHeap.peek();
            for (int i = k; i < nums.length; i++) {
                maxHeap.remove(nums[i - k]);
                maxHeap.add(nums[i]);
                res[i - k + 1] = maxHeap.peek();
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
