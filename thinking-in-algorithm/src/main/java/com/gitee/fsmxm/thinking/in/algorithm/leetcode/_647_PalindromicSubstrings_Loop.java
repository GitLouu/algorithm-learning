package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 难度 中等
 */
public class _647_PalindromicSubstrings_Loop {

    // T(n) = O(n^3)
    static class Solution {
        public int countSubstrings(String s) {
            if (s == null || s.length() < 2) {
                return 1;
            }
            int count = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                count++;
                for (int j = i + 1; j < chars.length; j++) {
                    if (isPalindromic(chars, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isPalindromic(char[] chars, int s, int e) {
            while (s < e) {
                if (chars[s] != chars[e]) {
                    return false;
                }
                s++;
                e--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }

}
