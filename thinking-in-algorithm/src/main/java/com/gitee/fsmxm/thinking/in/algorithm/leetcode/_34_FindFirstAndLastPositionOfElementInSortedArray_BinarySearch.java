package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 难度 中等
 */
public class _34_FindFirstAndLastPositionOfElementInSortedArray_BinarySearch {

    // 二分查找左右边界值
    // T(n)=O(logn)*2=O(logn)
    static class Solution {
        public int[] searchRange(int[] nums, int target) {

            if (nums == null) {
                return null;
            }

            int posL = -1, posR = -1;

            int left = 0, right = nums.length - 1, mid;
            // 找左边界 等于target的第一个值
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (mid == 0 || nums[mid - 1] != target) {
                        posL = mid;
                        break;
                    }
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            left = 0;
            right = nums.length - 1;
            // 找右边界 等于target的最后一个值
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        posR = mid;
                        break;
                    }
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return new int[]{posL, posR};
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(arr, 8)));
        System.out.println(Arrays.toString(solution.searchRange(arr, 6)));
    }

}
