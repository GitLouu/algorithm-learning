package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * 难度 简单
 */
public class _459_RepeatedSubstringPattern_DoubleStr {
    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() < 2)
                return false;
            return (s + s).indexOf(s, 1) != s.length();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("babbabbabbabbab"));
    }
}
