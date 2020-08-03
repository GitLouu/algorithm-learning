package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 难度 简单
 */
public class _20_ValidParentheses_Stack {

    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        Map<Character, Character> map;

        public Solution() {
            map = new HashMap<Character, Character>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
        }

        // '('，')'，'{'，'}'，'['，']'
        public boolean isValid(String s) {

            if (s == null || s.length() == 0) {
                return true;
            }

            Stack<Character> stack = new Stack<Character>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }

}
