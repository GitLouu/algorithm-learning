package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 * 难度 简单
 */
public class _290_WordPattern_Loop_Array_Set {
    // T(n) = O(n)
    static class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] ss = str.split(" ");
            if (pattern.length() != ss.length) {
                return false;
            }
            String[] pt = new String[26];
            Set<String> set = new HashSet<>();
            for (int i = 0; i < ss.length; i++) {
                char c = pattern.charAt(i);
                if (pt[c - 'a'] == null) {
                    pt[c - 'a'] = ss[i];
                    if (set.contains(ss[i])) {
                        return false;
                    }
                    set.add(ss[i]);
                } else {
                    if (!pt[c - 'a'].equals(ss[i])) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(solution.wordPattern("abba", "dog dog dog dog"));
    }
}
