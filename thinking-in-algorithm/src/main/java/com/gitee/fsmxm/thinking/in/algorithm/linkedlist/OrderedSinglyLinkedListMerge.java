package com.gitee.fsmxm.thinking.in.algorithm.linkedlist;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 有序单链表的合并
 */
public class OrderedSinglyLinkedListMerge {

    // O(m+n)
    public static <T extends Comparable<T>> SNode<T> merge(SNode<T> head1, SNode<T> head2) {
        return mergeSentinel(head1, head2);
    }

    // 使用哨兵节点，可简化操作
    private static <T extends Comparable<T>> SNode<T> mergeSentinel(SNode<T> head1, SNode<T> head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        SNode<T> p1 = head1;
        SNode<T> p2 = head2;
        SNode<T> nHead = new SNode<T>(null);
        SNode<T> np = nHead;
        while (p1 != null && p2 != null) {
            if (p1.data.compareTo(p2.data) <= 0) {
                np.next = p1;
                np = np.next;
                p1 = p1.next;
            } else {
                np.next = p2;
                np = np.next;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            np.next = p1;
        }
        if (p2 != null) {
            np.next = p2;
        }

        return nHead.next;
    }

    private static <T extends Comparable<T>> SNode<T> mergeNormal(SNode<T> head1, SNode<T> head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        SNode<T> p1 = head1;
        SNode<T> p2 = head2;
        SNode<T> nHead = null;
        SNode<T> np = null;
        while (p1 != null && p2 != null) {
            if (p1.data.compareTo(p2.data) <= 0) {
                if (nHead == null) {
                    nHead = p1;
                    np = nHead;
                } else {
                    np.next = p1;
                    np = np.next;
                }
                p1 = p1.next;
            } else {
                if (nHead == null) {
                    nHead = p2;
                    np = nHead;
                } else {
                    np.next = p2;
                    np = np.next;
                }
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            np.next = p1;
        }
        if (p2 != null) {
            np.next = p2;
        }

        return nHead;
    }

    public static void main(String[] args) {
        System.out.println(LinkedListUtil.toString(merge(LinkedListUtil.createSinglyLinkedList("13468"), LinkedListUtil.createSinglyLinkedList("2258"))));
        System.out.println(LinkedListUtil.toString(merge(null, LinkedListUtil.createSinglyLinkedList("2258"))));
        System.out.println(LinkedListUtil.toString(merge(LinkedListUtil.createSinglyLinkedList("13468"), null)));
        System.out.println(LinkedListUtil.toString(merge(null, null)));
        System.out.println(LinkedListUtil.toString(merge(LinkedListUtil.createSinglyLinkedList("1"), LinkedListUtil.createSinglyLinkedList("2258"))));
    }

}
