package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 难度 简单
 */
public class _Offer_50_第一个只出现一次的字符_Loop {

    // T(n) = O(n)  n是字符串长度
    static class Solution {
        public char firstUniqChar(String s) {
            int[] cs = new int[26];
            char[] ss = s.toCharArray();
            for (char c : ss) {
                cs[c - 'a']++;
            }
            for (char c : ss) {
                if (cs[c - 'a'] == 1) {
                    return c;
                }
            }
            return ' ';
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.firstUniqChar("abaccdeff"));
        System.out.println(solution.firstUniqChar(""));
    }

}
