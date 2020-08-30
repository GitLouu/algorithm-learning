package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 557. 反转字符串中的单词 III
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 难度 简单
 */
public class _557_ReverseWordsInAStringIII {

    static class Solution {
        // 借助额外空间
        // T(n) = O(mk) = O(n) m=单词个数 k=单词的平均字母数
        // S(n) = O(n)
        public String reverseWords(String s) {
            StringBuilder builder = new StringBuilder();
            for (String word : s.split(" ")) {
                builder.append(reverse(word)).append(" ");
            }
            return builder.deleteCharAt(builder.length() - 1).toString();
        }

        // T(n) = O(n/2) = O(n)
        // S(n) = O(n)
        private char[] reverse(String word) {
            char[] res = word.toCharArray();
            for (int i = 0, j = res.length - 1; i < j; i++, j--) {
                char c = res[i];
                res[i] = res[j];
                res[j] = c;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }

}
