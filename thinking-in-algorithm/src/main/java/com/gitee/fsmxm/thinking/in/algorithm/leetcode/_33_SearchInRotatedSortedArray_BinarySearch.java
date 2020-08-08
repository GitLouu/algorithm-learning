package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 难度 中等
 */
public class _33_SearchInRotatedSortedArray_BinarySearch {

    // T(n)=O(logn)*2=O(logn)
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int i = findRotatedPos(nums);
            if (i == 0) {
                return binarySearch(nums, target, 0, nums.length);
            }
            if (nums[0] <= target) {
                return binarySearch(nums, target, 0, i);
            }
            return binarySearch(nums, target, i, nums.length - i);
        }

        int binarySearch(int[] nums, int target, int x, int len) {
            int low = x, high = x + len - 1, mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }

        // T(n)=O(logn)
        // 判断很多，写法不简洁
        int findRotatedPos(int[] nums) {
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
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));

        nums = new int[]{0,1,2,4,5,6,7};
        System.out.println(solution.search(nums, 0));
        System.out.println(solution.search(nums, 3));
    }

}
