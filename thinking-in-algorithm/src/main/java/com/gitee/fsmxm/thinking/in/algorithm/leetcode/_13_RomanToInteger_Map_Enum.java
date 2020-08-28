package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 难度 简单
 */
public class _13_RomanToInteger_Map_Enum {
    // T(n) = O(n*4) = O(n)
    static class Solution {
        /*
        I II III IV V VI VII VIII IX 1 - 9
        X XX XXX XL L LX LXX LXXX XC 10 - 90
        C CC CCC CD D DC DCC DCCC CM 100 - 900
        M MM MMM                     1000 - 3000
        */
        static Map<String, Integer> map = new HashMap<>(33);

        static {
            map.put("I", 1);
            map.put("II", 2);
            map.put("III", 3);
            map.put("IV", 4);
            map.put("V", 5);
            map.put("VI", 6);
            map.put("VII", 7);
            map.put("VIII", 8);
            map.put("IX", 9);
            map.put("X", 10);
            map.put("XX", 20);
            map.put("XXX", 30);
            map.put("XL", 40);
            map.put("L", 50);
            map.put("LX", 60);
            map.put("LXX", 70);
            map.put("LXXX", 80);
            map.put("XC", 90);
            map.put("C", 100);
            map.put("CC", 200);
            map.put("CCC", 300);
            map.put("CD", 400);
            map.put("D", 500);
            map.put("DC", 600);
            map.put("DCC", 700);
            map.put("DCCC", 800);
            map.put("CM", 900);
            map.put("M", 1000);
            map.put("MM", 2000);
            map.put("MMM", 3000);
        }

        public int romanToInt(String s) {
            int len = s.length();
            int sum = 0;
            for (int i = len; i > 0; ) {
                for (int j = 4; j > 0; j--) {
                    Integer v;
                    if (i - j >= 0 && (v = map.get(s.substring(i - j, i))) != null) {
                        sum += v;
                        i -= j;
                        break;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
