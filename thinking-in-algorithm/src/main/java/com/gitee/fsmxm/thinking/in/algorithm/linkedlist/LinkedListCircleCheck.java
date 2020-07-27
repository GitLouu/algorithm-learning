package com.gitee.fsmxm.thinking.in.algorithm.linkedlist;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 检测链表中是否存在环
 * 比如，1指向2，2指向3...4指向5，而5又指向2，形成了环
 * 1 -> 2 -> 3 -> 4 -> 5 -> 2 -> 3 -> 4 -> 5
 *
 */
public class LinkedListCircleCheck {

    public static <T> boolean circleCheck(SNode<T> head) {

        return circleCheckBySlowFastPointer(head);
    }

    // 快慢指针检测是否存在环
    // 快指针走2步，慢指针走1步
    // 若存在环，快慢指针会相遇，否则不相遇
    // O(n)
    public static <T> boolean circleCheckBySlowFastPointer(SNode<T> head) {

        if (head == null) {
            return false;
        }

        SNode<T> sl = head;
        SNode<T> fa = head;

        while (fa.next != null && fa.next.next != null) {
            fa = fa.next.next;
            sl = sl.next;
            if (fa == sl) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(circleCheck(LinkedListUtil.createSinglyLinkedList("abc")));
        System.out.println(circleCheck(LinkedListUtil.createSinglyLinkedList("ab")));
        System.out.println(circleCheck(LinkedListUtil.createSinglyLinkedList("a")));
        System.out.println(circleCheck(null));

        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        SNode node5 = new SNode(5);
        SNode node6 = new SNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        System.out.println(circleCheck(node1));
        node6.next = node3;
        System.out.println(circleCheck(node1));
        node6.next = node4;
        System.out.println(circleCheck(node1));
        node6.next = node5;
        System.out.println(circleCheck(node1));
        node6.next = node6;
        System.out.println(circleCheck(node1));
        node6.next = null ;
        System.out.println(circleCheck(node1));
    }

}
