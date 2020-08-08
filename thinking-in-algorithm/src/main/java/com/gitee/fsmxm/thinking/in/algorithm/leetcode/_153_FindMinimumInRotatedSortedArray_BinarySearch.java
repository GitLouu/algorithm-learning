package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 难度 中等
 */
public class _153_FindMinimumInRotatedSortedArray_BinarySearch {

    static class Solution {

        public int findMin(int[] nums) {
            return nums[findPos(nums)];
        }

        // T(n)=O(logn)
        // 写法不简洁
        int findPos(int[] nums) {
            int low = 0, high = nums.length - 1, mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > nums[high]) {
                    if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
                        return mid + 1;
                    }
                    low = mid + 1;
                } else {
                    if (mid > 0 && nums[mid - 1] > nums[mid]) {
                        return mid;
                    }
                    high = mid - 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
