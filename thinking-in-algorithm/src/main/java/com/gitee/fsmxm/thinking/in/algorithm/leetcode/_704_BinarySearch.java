package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 * 难度 简单
 */
public class _704_BinarySearch {

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = right - (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums, 9));
        System.out.println(solution.search(nums, 2));
    }

}
