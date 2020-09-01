package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 * https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 * 难度 简单
 */
public class _1455_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence_Loop {

    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int wordCount = 0;
            int pos = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    wordCount++;
                    if (isPrefix(sentence, pos, i, searchWord)) {
                        return wordCount;
                    }
                    pos = i + 1;
                }
            }
            if (isPrefix(sentence, pos, sentence.length(), searchWord)) {
                return wordCount + 1;
            }
            return -1;
        }

        private boolean isPrefix(String sentence, int pos, int i, String searchWord) {
            if (i - pos < searchWord.length()) {
                return false;
            }
            int k = pos;
            while (k - pos < searchWord.length() && sentence.charAt(k) == searchWord.charAt(k - pos)) {
                k++;
            }
            return k - pos == searchWord.length();
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(solution.isPrefixOfWord("i am tired", "you"));
        System.out.println(solution.isPrefixOfWord("i use triple pillow", "pill"));
        System.out.println(solution.isPrefixOfWord("hello from the other side", "they"));
    }
}
