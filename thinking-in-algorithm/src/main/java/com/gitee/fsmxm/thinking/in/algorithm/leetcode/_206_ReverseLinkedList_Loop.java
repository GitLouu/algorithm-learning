package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 难度 简单
 */
public class _206_ReverseLinkedList_Loop {

    // 方案1
    static class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode curr = head;
            ListNode prev = null;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    // 方案2
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = head;
            for (ListNode curr = head.next; curr != null; ) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = prev;
                prev = temp;
            }
            head.next = null;
            return prev;
        }
    }

    public static void main(String[] args) {
        // 输入: 1->2->3->4->5->NULL
        // 输出: 5->4->3->2->1->NULL
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        System.out.print("输入: ");
        printAll(h1);
        System.out.print("输出: ");
        printAll(new Solution2().reverseList(h1));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static void printAll(ListNode head) {
        if (head == null) {
            System.out.println();
        }
        StringBuilder builder = new StringBuilder();
        ListNode h = head;
        builder.append(h.val).append(" -> ");
        while (h.next != null) {
            builder.append(h.next.val).append(" -> ");
            h = h.next;
        }
        System.out.println(builder.append("NULL").toString());
    }

}
