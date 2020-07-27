package com.gitee.fsmxm.thinking.in.algorithm.palindrome;

import com.gitee.fsmxm.thinking.in.algorithm.LinkedListUtil;
import com.gitee.fsmxm.thinking.in.algorithm.SNode;

/**
 * 单链表存储的回文判断
 */
public class SingleLinkedListPalindrome {

    public static <T> boolean isPalindrome(SNode<T> head) {

        return slowFastPointer(head);
    }

    // 快慢指针法
    // 1. 快指针一次走两步，慢指针一次走一步
    // 2. 当快指针走到尾部指向null时，慢指针正好走完一半，指向后半段开始的节点
    // 3. 反转后半段链表，用后半段链表来与原链表头部开始比较直到后半段链表结束，有不相等则返回false
    // 4. 最后返回true
    // 时间复杂度O(n) 空间复杂度O(n)（新开辟节点）/O(1)（不开辟节点，最后要再反转链表）
    public static <T> boolean slowFastPointer(SNode<T> head) {
        SNode<T> sl = head;
        SNode<T> fa = head;
        while (fa != null) {
            fa = fa.next;
            if (fa != null) {
                fa = fa.next;
            }
            sl = sl.next;
        }

        SNode<T> nHead = null;
        while (sl != null) {
            SNode<T> temp = new SNode<T>(sl.data);
            temp.next = nHead;
            nHead = temp;
            sl = sl.next;
        }

        SNode<T> oHead = head;
        while (nHead != null) {
            if (!nHead.data.equals(oHead.data)) {
                return false;
            }
            nHead = nHead.next;
            oHead = oHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("abccba")));
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("abccbaa")));
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("abc")));
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("aa")));
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("a")));
        System.out.println(isPalindrome(LinkedListUtil.createSinglyLinkedList("")));
    }

}
