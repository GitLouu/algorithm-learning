package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 难度 简单
 */
public class _13_RomanToInteger {
    // https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
    // 把一个小值放在大值的左边，就是做减法，否则为加法。
    // T(n) = O(n)
    static class Solution {

        public int romanToInt(String s) {
            int sum = 0;
            int preV = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = getValue(s.charAt(i));
                if (preV < v) {
                    sum -= preV;
                } else {
                    sum += preV;
                }
                preV = v;
            }
            sum += preV;
            return sum;
        }

        private int getValue(char ch) {
            switch (ch) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
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
