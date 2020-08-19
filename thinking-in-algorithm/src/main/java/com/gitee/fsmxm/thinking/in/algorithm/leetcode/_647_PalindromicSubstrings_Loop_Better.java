package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 难度 中等
 */
public class _647_PalindromicSubstrings_Loop_Better {

    // 中心扩展
    // T(n) = O(n * 2 * n) = O(n^2)
    // S(n) = O(n)
    static class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() < 2) {
                return 1;
            }
            int count = 0;
            char[] chars = s.toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 2; j++) {
                    int left = i;
                    int right = i + j;
                    while (left > -1 && right < len && chars[left--] == chars[right++]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
        System.out.println(solution.countSubstrings("hello"));
    }

}
