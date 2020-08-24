package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 459. 重复的子字符串
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 * 难度 简单
 */
public class _459_RepeatedSubstringPattern_Loop_Force {
    // T(n) = O(n^2)
    // S(n) = O(n)
    static class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s == null || s.length() < 2)
                return false;
            char[] chars = s.toCharArray();
            for (int i = 1; i <= chars.length / 2; i++) {
                if (chars.length % i == 0) {
                    boolean match = true;
                    for (int j = i; j < chars.length; j++) {
                        if (chars[j] != chars[j - i]) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("babbabbabbabbab"));
    }
}
