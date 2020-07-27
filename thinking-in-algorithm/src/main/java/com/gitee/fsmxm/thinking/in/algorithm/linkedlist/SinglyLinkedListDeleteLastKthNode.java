package com.gitee.fsmxm.thinking.in.algorithm.linkedlist;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 删除单链表的倒数第k个节点
 */
public class SinglyLinkedListDeleteLastKthNode {

    public static <T> SNode<T> deleteLastKthNode(SNode<T> head, int k) {
        return deleteLastKthNodeByFastSlowPointer2(head, k);
    }

    // 两指针遍历，保持指针距离k个节点，当快指针到达链表尾部null，慢指针则落在倒数第k个节点上
    public static <T> SNode<T> deleteLastKthNodeByFastSlowPointer(SNode<T> head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }

        SNode<T> fa = head;
        int i = 0;
        for (; i < k && fa != null; i++) {
            fa = fa.next;
        }

        // 如果 已经走到尾部null节点，且fa遍历次数小于k次（说明链表节点数量小于k个），则返回原链表
        if (fa == null && i < k) {
            return head;
        }

        SNode<T> sl = head;
        SNode<T> prev = null;
        while (fa != null) {
            fa = fa.next;
            prev = sl;
            sl = sl.next;
        }
        // 如果prev指针是null，表示fa已经是null（节点个数就等于k个），则要删除的倒数第k个节点就是头节点
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }

        return head;
    }

    // 使用了哨兵节点
    public static <T> SNode<T> deleteLastKthNodeByFastSlowPointer2(SNode<T> head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return head;
        }

        SNode<T> dummy = new SNode<T>(null);
        dummy.next = head;

        SNode<T> fa = dummy;
        int i = 0;
        for (; i < k && fa != null; i++) {
            fa = fa.next;
        }

        // 如果 fa遍历次数小于k次（说明链表节点数量小于k个），则返回原链表
//        if (i < k) {
//            return head;
//        }
        // 如果 fa 遍历次数等于k次 且 fa==null
        // 说明已经遍历到尾部null节点，实际有效节点次数等于i-1个(减去一个dummy节点)，节点个数实际上小于k个
        // ，则返回原链表
//        if (i == k && fa == null) {
//            return head;
//        }
        // 已经到尾部null节点，说明链表有效节点个数小于k个，则返回原链表
        if (fa == null) {
            return head;
        }

        SNode<T> sl = dummy;
        while (fa.next != null) {
            fa = fa.next;
            sl = sl.next;
        }
        sl.next = sl.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),0)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),1)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),2)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),3)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),4)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),5)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),6)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),7)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("abcdef"),8)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("a"),0)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("a"),1)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("a"),2)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"),0)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"),1)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"),2)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"),3)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"),4)));
        System.out.println(LinkedListUtil.toString(deleteLastKthNode(LinkedListUtil.createSinglyLinkedList("ab"), 5)));

    }

}
