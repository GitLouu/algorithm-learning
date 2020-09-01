package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 * 难度 简单
 */
public class _1455_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence_Api {
    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int count = 0;
            for (String word : sentence.split(" ")) {
                count++;
                if (word.indexOf(searchWord) == 0) {
                    return count;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(solution.isPrefixOfWord("i am tired", "you"));
        System.out.println(solution.isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(solution.isPrefixOfWord("hello from the other side", "they"));
    }
}
