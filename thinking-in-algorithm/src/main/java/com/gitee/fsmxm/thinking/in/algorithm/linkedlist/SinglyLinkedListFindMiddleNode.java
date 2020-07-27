package com.gitee.fsmxm.thinking.in.algorithm.linkedlist;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 查找单链表的中间节点，若中间节点有两个则返回第二个节点
 */
public class SinglyLinkedListFindMiddleNode {

    // O(n)  快慢指针法
    public static <T> SNode<T> findMiddleNode(SNode<T> head) {
        if (head == null) {
            return null;
        }

        SNode<T> sl = head;
        SNode<T> fa = head;

        while (fa.next != null && fa.next.next != null) {
            fa = fa.next.next;
            sl = sl.next;
        }

        // 奇偶中点问题
        if (fa.next != null) {
            return sl.next;
        }

        return sl;
    }

    // 循环条件的变化，不需要考虑奇偶中点，慢指针会落到后中点
    public static <T> SNode<T> findMiddleNode2(SNode<T> head) {
        if (head == null) {
            return null;
        }

        SNode<T> sl = head;
        SNode<T> fa = head;

        while (fa != null && fa.next != null) {
            fa = fa.next.next;
            sl = sl.next;
        }

        return sl;
    }


    public static void main(String[] args) {
        System.out.println(LinkedListUtil.toString(findMiddleNode(LinkedListUtil.createSinglyLinkedList("abcdefg"))));
        System.out.println(LinkedListUtil.toString(findMiddleNode(LinkedListUtil.createSinglyLinkedList("abcdef"))));
        System.out.println(LinkedListUtil.toString(findMiddleNode(LinkedListUtil.createSinglyLinkedList("ab"))));
        System.out.println(LinkedListUtil.toString(findMiddleNode(LinkedListUtil.createSinglyLinkedList("a"))));
        System.out.println(LinkedListUtil.toString(findMiddleNode(null)));
    }

}
