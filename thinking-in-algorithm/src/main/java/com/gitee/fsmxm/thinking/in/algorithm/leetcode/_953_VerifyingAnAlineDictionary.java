package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 953. 验证外星语词典
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 * 难度 简单
 */
public class _953_VerifyingAnAlineDictionary {
    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            for (int i = 1; i < words.length; i++) {
                if (!ordered(words[i - 1], words[i], order)) {
                    return false;
                }
            }
            return true;
        }

        private boolean ordered(String s1, String s2, String order) {
            int i = 0;
            while (i < s1.length() && i < s2.length()) {
                int w1 = order.indexOf(s1.charAt(i));
                int w2 = order.indexOf(s2.charAt(i));
                if (w1 == w2) {
                    i++;
                } else {
                    return w1 < w2;
                }
            }
            return i == s1.length();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
