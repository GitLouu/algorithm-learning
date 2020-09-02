package com.gitee.fsmxm.thinking.in.algorithm.string;

/**
 * Rabin-Karp 算法
 */
public class RK {

    static int[] RK26 = new int[25];

    static {
        RK26[0] = 1;
        for (int i = 1; i < RK26.length; i++) {
            RK26[i] = 26 * RK26[i - 1];
        }
    }

    public static int indexOf(String str, String target) {
        if (str.length() < target.length()) {
            return -1;
        }
        int m = target.length();
        int[] rk = new int[str.length() - m + 1];
        rk[0] = countRk(str, 0, m);
        for (int i = 1; i < rk.length; i++) {
            rk[i] = (rk[i - 1] - RK26[m - 1] * (str.charAt(i - 1) - 'a')) * 26 + (str.charAt(i + m - 1) - 'a');
//            rk[i] = countRk(str, i, m); // 同上面计算结果一样
        }

        int rkT = countRk(target, 0, m);

        for (int i = 0; i < rk.length; i++) {
            if (rk[i] == rkT) { // 不考虑哈希冲突
                return i;
            }
        }

        return -1;
    }

    private static int countRk(String str, int pos, int length) {
        int rk = 0;
        for (int i = 0; i < length; i++) {
            rk += (str.charAt(pos + i) - 'a') * RK26[length - i - 1];
        }
        return rk;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("abcdef", "abc"));
        System.out.println(indexOf("abcdef", "bc"));
        System.out.println(indexOf("abcdef", "bce"));
        System.out.println(indexOf("abcdef", "def"));
        System.out.println(indexOf("abcdef", "defg"));
    }

}
