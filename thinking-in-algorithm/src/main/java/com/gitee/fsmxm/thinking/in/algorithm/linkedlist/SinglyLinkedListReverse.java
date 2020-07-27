package com.gitee.fsmxm.thinking.in.algorithm.linkedlist;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 单链表的反转
 */
public class SinglyLinkedListReverse {

    // O(n)
    public static <T> SNode<T> reverse(SNode<T> head) {
        if (head == null) {
            return null;
        }

        SNode<T> prev = null;
        SNode<T> curr = head;
        while (curr != null) {
            SNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(LinkedListUtil.toString(reverse(LinkedListUtil.createSinglyLinkedList("12345"))));
        System.out.println(LinkedListUtil.toString(reverse(LinkedListUtil.createSinglyLinkedList("a"))));
        System.out.println(LinkedListUtil.toString(reverse(LinkedListUtil.createSinglyLinkedList("ab"))));
        System.out.println(LinkedListUtil.toString(reverse(LinkedListUtil.createSinglyLinkedList(""))));
        System.out.println(LinkedListUtil.toString(reverse(null)));
    }

}
