package com.gitee.fsmxm.thinking.in.algorithm;

public class LinkedListUtil {

    public static SNode<Character> createSinglyLinkedList(String str) {
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

    public static <T> SNode<T> createSinglyLinkedList(T[] ts) {
        if (ts == null || ts.length == 0) {
            return null;
        }

        SNode<T> head = new SNode<T>(ts[0]);
        SNode<T> p = head;
        for (int i = 1; i < ts.length; i++) {
            p.next = new SNode<T>(ts[i]);
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
        SNode<Character> head = createSinglyLinkedList("abccba");
        System.out.println(toString(head));
    }

}
