package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 * 难度 中等
 */
public class _17_14_SmallestKLCCI_Partition {

    // 使用快速排序分区的思想
    static class Solution {

        public int[] smallestK(int[] arr, int k) {

            if (arr == null || arr.length <= k) {
                return arr;
            }

            internallyQuick(arr, k, 0, arr.length - 1);

            int[] res = new int[k];
            System.arraycopy(arr, 0, res, 0, k);
            return res;
        }

        private void internallyQuick(int[] arr, int k, int q, int r) {

            if (q >= r) {
                return;
            }

            int p = partition(arr, q, r);

            if (k - 1 == p) {
                return;
            }
            if (k - 1 < p) {
                internallyQuick(arr, k, q, p - 1);
            } else {
                internallyQuick(arr, k, p + 1, r);
            }
        }

        private int partition(int[] arr, int q, int r) {

            int pivot = arr[r];

            int i = q;

            for (int j = i; j < r; j++) {
                if (arr[j] < pivot) {
                    if (j != i) {
                        int t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                    }
                    i++;
                }
            }
            arr[r] = arr[i];
            arr[i] = pivot;
            return i;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 6, 5, 9, 8, 0, 2, 7, 4};
        int[] ks = solution.smallestK(arr, 11);
        System.out.println(Arrays.toString(ks));
        System.out.println(Arrays.toString(arr));
    }

}
