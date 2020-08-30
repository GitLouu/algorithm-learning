package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 难度 简单
 */
public class _557_ReverseWordsInAStringIII_On {

    static class Solution {
        // T(n) = O(n)
        // S(n) = O(1)
        public String reverseWords(String s) {
            StringBuilder builder = new StringBuilder();
            int len = s.length(), i = 0;
            while (i < len) {
                int j = i;
                while (i < len && s.charAt(i) != ' ') {
                    i++;
                }
                for (int k = i - 1; k >= j; k--) {
                    builder.append(s.charAt(k));
                }
                while (i < len && s.charAt(i) == ' ') {
                    builder.append(s.charAt(i++));
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

}
