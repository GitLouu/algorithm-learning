package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 难度 简单
 */
public class _Offer_50_第一个只出现一次的字符_LinkedHashMap {

    // T(n) = O(n)  n是字符串长度
    static class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            char[] ss = s.toCharArray();
            for (char c : ss) {
                Integer v = map.get(c);
                if (v == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, v + 1);
                }
            }
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (e.getValue() == 1) {
                    return e.getKey();
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
