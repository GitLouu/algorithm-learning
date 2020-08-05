package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 难度 中等
 */
public class _15_3Sum_DoublePointer {
    // T(n)=O(n^2)
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            // 先排序 （这是基础）
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 前后指针
                for (int front = i + 1, end = nums.length - 1; front < end; front++) {
                    if (front > i + 1 && nums[front] == nums[front - 1]) {
                        continue;
                    }

                    // end 用来快速移动来使三数之和接近0，end越靠近右边，三数之和越>0 (数组已经排序)
                    while (end > front && nums[front] + nums[end] > -nums[i]) {
                        end--;
                    }

                    if (front == end) {
                        break;
                    }

                    if (nums[front] + nums[end] + nums[i] == 0) {
                        res.add(Arrays.asList(nums[i], nums[front], nums[end]));
                    }

                }

            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
