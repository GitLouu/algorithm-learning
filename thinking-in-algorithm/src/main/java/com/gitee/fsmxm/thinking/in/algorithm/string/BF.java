package com.gitee.fsmxm.thinking.in.algorithm.string;

/**
 * 暴力匹配算法 (朴素匹配算法)
 *
 * BF: Brute Force
 */
public class BF {

    // T(n) = O(n * m) n = str的长度 m = target的长度
    public static int indexOf(String str, String target) {
        for (int i = 0; i <= str.length() - target.length(); i++) {
            if (equals(str, i, target)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean equals(String str, int i, String target) {
        int end = i + target.length();
        int pos = i;
        while (pos < end) {
            if (str.charAt(pos) != target.charAt(pos - i)) {
                return false;
            }
            pos++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcdef", "abc"));
        System.out.println(indexOf("abcdef", "bc"));
        System.out.println(indexOf("abcdef", "bce"));
        System.out.println(indexOf("abcdef", "def"));
        System.out.println(indexOf("abcdef", "defg"));
    }

}
