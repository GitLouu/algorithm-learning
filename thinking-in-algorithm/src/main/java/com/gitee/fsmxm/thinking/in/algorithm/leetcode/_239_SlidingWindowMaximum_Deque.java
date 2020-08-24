package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 难度 困难
 */
public class _239_SlidingWindowMaximum_Deque {
    // T(n) = O(n)
    // S(n) = O(k)
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length * k == 0) return new int[0];
            if (k == 1) return nums;
            Deque<Integer> deq = new ArrayDeque<>();

            // init deque and output
            for (int i = 0; i < k; i++) {
                cleanDeque(deq, nums, i, k);
                deq.addLast(i);
            }
            int[] output = new int[nums.length - k + 1];
            output[0] = nums[deq.getFirst()];

            // build output
            for (int i = k; i < nums.length; i++) {
                // remove indexes of elements not from sliding window
                if (deq.getFirst() == i - k) {
                    deq.removeFirst();
                }
                cleanDeque(deq, nums, i, k);
                deq.addLast(i);
                output[i - k + 1] = nums[deq.getFirst()];
            }
            return output;
        }

        private void cleanDeque(Deque<Integer> deq, int[] nums, int i, int k) {
            // remove from deq indexes of all elements
            // which are smaller than current element nums[i]
            while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
                deq.removeLast();
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }
}
