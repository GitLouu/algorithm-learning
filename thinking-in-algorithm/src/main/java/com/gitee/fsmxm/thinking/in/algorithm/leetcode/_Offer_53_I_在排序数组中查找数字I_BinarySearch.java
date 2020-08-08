package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 难度 简单
 */
public class _Offer_53_I_在排序数组中查找数字I_BinarySearch {

    // 普通二分查找
    // 先找到target位置，再前后遍历找与target相等的值，统计个数
    // T(n) = O(logn)+O(n)*2 = O(n)
    static class Solution {

        public int search(int[] nums, int target) {
            int index = binarySearch(nums, target);
            if (index == -1) {
                return 0;
            }
            int count = 1;
            for (int i = index + 1; i < nums.length && nums[i] == target; i++) {
                count++;
            }
            for (int i = index - 1; i >= 0 && nums[i] == target; i--) {
                count++;
            }
            return count;
        }

        int binarySearch(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }
            int left = 0, right = nums.length - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
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
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(solution.search(array, 8));
        System.out.println(solution.search(array, 6));
        array = new int[]{1, 1, 2};
        System.out.println(solution.search(array, 1));
    }

}
