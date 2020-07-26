package com.gitee.fsmxm.thinking.in.algorithm;

public class NodeUtil {

    public static SNode<Character> createStringNodes(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        char[] chars = str.toCharArray();

        SNode<Character> head = new SNode<Character>(chars[0]);
        SNode<Character> p = head;
        for (int i = 1; i < chars.length; i++) {
            p.next = new SNode<Character>(chars[i]);
            p = p.next;
        }
        return head;
    }

    public static <T> String toString(SNode<T> head) {
        if (head == null) {
            return null;
        }
        SNode<T> p = head;
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (p != null) {
            count++;
            builder.append(p.data.toString()).append(", ");
            p = p.next;
        }
        return count + ": " + builder.deleteCharAt(builder.length() - 2).toString();
    }

    public static void main(String[] args) {
        SNode<Character> head = createStringNodes("abccba");
        System.out.println(toString(head));
    }

}
