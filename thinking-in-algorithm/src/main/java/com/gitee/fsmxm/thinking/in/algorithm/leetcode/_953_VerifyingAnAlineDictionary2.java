package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 953. 验证外星语词典
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 * 难度 简单
 */
public class _953_VerifyingAnAlineDictionary2 {
    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] ord = new int[26];
            for (int i = 0; i < order.length(); i++) {
                ord[order.charAt(i) - 'a'] = i;
            }
            for (int i = 1; i < words.length; i++) {
                if (!ordered(words[i - 1], words[i], ord)) {
                    return false;
                }
            }
            return true;
        }

        private boolean ordered(String s1, String s2, int[] ord) {
            int i = 0;
            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) != s2.charAt(2)) {
                    return ord[s1.charAt(i) - 'a'] < ord[s2.charAt(i) - 'a'];
                }
                i++;
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
